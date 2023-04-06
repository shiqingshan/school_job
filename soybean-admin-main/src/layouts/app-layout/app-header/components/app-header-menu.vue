<template>
  <div class="flex-1-hidden h-full px-10px">
    <n-scrollbar :x-scrollable="true" class="flex-1-hidden h-full" content-class="h-full">
      <div class="flex-y-center h-full" :style="{ justifyContent: theme.menu.horizontalPosition }">
        <n-menu
          :value="activeKey"
          mode="horizontal"
          :options="menus"
          :inverted="theme.header.inverted"
          @update:value="handleUpdateMenu"
        />
      </div>
    </n-scrollbar>
  </div>
</template>

<script setup lang="ts">
import { computed, h } from 'vue';
import { useRoute } from 'vue-router';
import { type MenuOption } from 'naive-ui';
import { useRouteStore, useThemeStore } from '@/store';
import { useRouterPush } from '@/composables';

defineOptions({ name: 'HeaderMenu' });

const route = useRoute();
const theme = useThemeStore();
const { routerPush } = useRouterPush();

const menus: MenuOption[] = [
  {
    label: () =>
      h(
        'span',
        {
          class: 'hmenu'
        },
        '首页'
      ),
    key: 'hear-the-wind-sing'
  },
  {
    label: '职位',
    key: 'a-wild-sheep-chase'
  }
];

const activeKey = computed(() => (route.meta?.activeMenu ? route.meta.activeMenu : route.name) as string);

function handleUpdateMenu(_key: string, item: MenuOption) {
  const menuItem = item as App.GlobalMenuOption;
  routerPush(menuItem.routePath);
}
</script>

<style lang="scss" scoped>
.hmenu {
  color: #fff;
  background-color: #fff;
  height: 10000px;
}
</style>
