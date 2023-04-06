<template>
  <n-layout style="margin: 2px 0 0 0; background-color: #6979cb">
    <n-space vertical>
      <n-layout-header>
        <appHeader />
      </n-layout-header>
      <n-layout-content content-style="margin: 0 20% 0 20%; height: 80%">
        <router-view v-slot="{ Component, route }">
          <keep-alive :include="routeStore.cacheRoutes">
            <component
              :is="Component"
              v-if="app.reloadFlag"
              :key="route.fullPath"
              :class="{ 'p-16px': showPadding }"
              class="flex-grow bg-#f6f9f8 transition duration-300 ease-in-out"
            />
          </keep-alive>
        </router-view>
      </n-layout-content>
      <n-layout-footer>成府路</n-layout-footer>
    </n-space>
  </n-layout>
</template>

<script lang="ts" setup>
import { useAppStore, useRouteStore } from '@/store';
import appHeader from './app-header/index.vue';

interface Props {
  /** 显示padding */
  showPadding?: boolean;
}

defineOptions({ name: 'AppLayout' });

withDefaults(defineProps<Props>(), {
  showPadding: true
});

const app = useAppStore();
const routeStore = useRouteStore();
</script>

<style scoped lang="less"></style>
