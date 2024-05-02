<script setup>
import { RouterView } from 'vue-router'
import Loading from 'vue-loading-overlay'
import { computed } from 'vue'
import { useLoaderStore } from '@/stores/loader'

const loaderStore = useLoaderStore()
const isLoading = computed(() => {
  return loaderStore.showLoader
})

function onCancel() {
  loaderStore.setShowLoader(false)
}
</script>

<template>
  <div>
    <RouterView />
    <loading v-model:active="isLoading"
             :can-cancel="true"
             :height="60"
             :is-full-page="true"
             :on-cancel="onCancel"
             :width="60"
             background-color="#696969"
             color="black"
             loader="dots" />
  </div>
</template>
