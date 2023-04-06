<template>
  <div class="cpgrid">
    <n-grid :x-gap="12" :y-gap="8" :cols="4">
      <n-grid-item>
        <n-card
          hoverable
          :segmented="{
            content: true,
            footer: 'soft'
          }"
        >
          卡片内容
          <template #footer> #footer </template>
        </n-card>
      </n-grid-item>
      <n-grid-item>
        <n-card title="卡片" hoverable> 卡片内容 </n-card>
      </n-grid-item>
      <n-grid-item>
        <n-card title="卡片" hoverable> 卡片内容 </n-card>
      </n-grid-item>
      <n-grid-item>
        <n-card title="卡片" hoverable> 卡片内容 </n-card>
      </n-grid-item>
      <n-grid-item>
        <div class="light-green" />
      </n-grid-item>
      <n-grid-item>
        <div class="green" />
      </n-grid-item>
      <n-grid-item>
        <div class="light-green" />
      </n-grid-item>
      <n-grid-item>
        <div class="green" />
      </n-grid-item>
    </n-grid>
  </div>
  <div class="pageclass">
    <n-pagination v-model:page="page" :page-count="100" />
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue';

const page = ref(2);
</script>

<style scoped>
.light-green {
  height: 108px;
  background-color: rgba(0, 128, 0, 0.12);
}
.green {
  height: 108px;
  background-color: rgba(0, 128, 0, 0.24);
}
.pageclass {
  margin-top: 10px;
}
</style>
