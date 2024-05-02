import { createRouter, createWebHistory } from 'vue-router'
import HomePage from '@/pages/HomePage.vue'

const routes = [
  {
    meta: {
      title: 'Home'
    },
    path: '/',
    name: 'home',
    component: () => HomePage
  },
  {
    path: '/:pathMatch(.*)*',
    redirect: { name: 'error' }
  }
]

const router = createRouter({
  /*history: createWebHashHistory(),*/
  history: createWebHistory(),
  routes,
  scrollBehavior(to, from, savedPosition) {
    return savedPosition || { top: 0 }
  }
})

export default router
