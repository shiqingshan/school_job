<template>
  <dark-mode-container class="header flex justify-center h-full">
    <global-logo :show-title="true" class="h-full" :style="{ width: theme.sider.width + 'px' }" />
    <AppHeaderMenu />
    <div class="endheader flex justify-end h-full">
      <n-space>
        <messageHeader />
        <resumeHeader />
        <userLoginHeader />
      </n-space>
    </div>
  </dark-mode-container>
</template>
<script lang="ts" setup>
import { useThemeStore } from '@/store';
import GlobalLogo from '../../common/global-logo/index.vue';
import AppHeaderMenu from './components/app-header-menu.vue';
import messageHeader from './components/message-header.vue';
import resumeHeader from './components/resume-header.vue';
import userLoginHeader from './components/user-login-header.vue';

const theme = useThemeStore();
</script>

<style scoped lang="scss"></style>
