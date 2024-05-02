import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'
import { dom, library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { fas } from '@fortawesome/free-solid-svg-icons'
import { fab } from '@fortawesome/free-brands-svg-icons'
import { far } from '@fortawesome/free-regular-svg-icons'
import axios from 'axios'
import Vue3Toastify, { toast } from 'vue3-toastify'
// Import css
import 'vue3-toastify/dist/index.css'
import 'vue-loading-overlay/dist/css/index.css'
import '.././node_modules/flowbite-vue/dist/index.css'
import './css/main.css'
import { useLoaderStore } from '@/stores/loader'

// Init font awesome
library.add(fas)
library.add(fab)
library.add(far)
dom.watch()

// Init Pinia
const pinia = createPinia()

// Create Vue app
const app = createApp(App)
app.use(router).use(pinia)
  .use(Vue3Toastify, { autoClose: 2000 })
app.component('font-awesome-icon', FontAwesomeIcon)

app.mount('#app')
/*/get-all-user*/
// Init main store

// Fetch sample data
// mainStore.fetchSampleClients()
// mainStore.fetchSampleHistory()

// Dark mode
// Uncomment, if you'd like to restore persisted darkMode setting, or use `prefers-color-scheme: dark`. Make sure to uncomment localStorage block in src/stores/darkMode.js
// import { useDarkModeStore } from './stores/darkMode'

// const darkModeStore = useDarkModeStore(pinia)

// if (
//   (!localStorage['darkMode'] && window.matchMedia('(prefers-color-scheme: dark)').matches) ||
//   localStorage['darkMode'] === '1'
// ) {
//   darkModeStore.set(true)
// }

// Default title tag
const defaultDocumentTitle = 'Movie Circle'
const axiosInstance = axios.create()

axiosInstance.defaults.headers.common['Access-Control-Allow-Origin'] = '*'
axiosInstance.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest'
let token = document.head.querySelector('meta[name="csrf-token"]')
app.config.globalProperties.$axios = axiosInstance

let userData = JSON.parse(localStorage.getItem('user'))

//----------------------------------------Request interceptor for API calls-------------------------
const loaderStore = useLoaderStore()
axios.interceptors.request.use(
  async (config) => {
    // if (!(config.params && config.params.dontLoad === true)) {
    //   loaderStore.setShowLoader(true)
    // } else {
    //   config.params.dontLoad = null
    // }
    loaderStore.setShowLoader(true)

    if (userData == null) {
      userData = JSON.parse(localStorage.getItem('user'))
    }
    // await new Promise(resolve => setTimeout(resolve, 3000))
    /*console.log("Host",userData.token.token);*/
    /*if (token) {*/
    /*config.headers.common["Authorization"] = tokenType + ' ' + tokenData;*/
    if (null != userData) {
      config.headers.Authorization = `Bearer ${userData.token.token}`
    } else {
      /*config.headers.Authorization = `Bearer ${tokenData}`*/
    }
    /*}*/
    return config
  },
  (error) => {
    loaderStore.setShowLoader(false)
    return Promise.reject(error)
  }
)

axios.interceptors.response.use(
  (config) => {
    loaderStore.setShowLoader(false)
    if (config.data.status === false) {
      toast.error(config.data.message, {
        autoClose: 2500,
        theme: 'dark'
      })
    }
    return config
  },
  (error) => {
    loaderStore.setShowLoader(false)
    if (error.response.data.message) {
      toast.error(error.response.data.message, {
        autoClose: 2500,
        theme: 'dark'
      })
    } else {
      toast.error('Something went wrong!', {
        autoClose: 2500,
        theme: 'dark'
      })
    }
    return Promise.reject(error)
  }
)


// Set document title from route meta
router.afterEach((to) => {
  document.title = to.meta?.title
    ? `${to.meta.title} — ${defaultDocumentTitle}`
    : defaultDocumentTitle
})
