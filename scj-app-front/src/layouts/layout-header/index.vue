<template>
    <el-menu
      :default-active="activeIndex"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      mode="horizontal"
      :ellipsis="false"
      @select="handleSelect"
    >
      <el-menu-item index="0">LOGO</el-menu-item>

      <el-menu-item index="1">首页</el-menu-item>
      <el-menu-item index="2">职位</el-menu-item>
      <el-menu-item index="3">公司</el-menu-item>
      <div class="flex-grow" />
      <el-menu-item index="4">上传简历</el-menu-item>
      <el-menu-item index="5">我要找工作</el-menu-item>
      <el-menu-item index="6">我要招聘</el-menu-item>
      <li style="margin-top: 10px;"><el-button info round>注册/登录</el-button></li>
    </el-menu>
    
  </template>

<script lang="ts" setup>
import { ref } from 'vue'

const activeIndex = ref('1')
const handleSelect = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>