<template>
    <div>
        <el-container>
            <LayoutHeader/>
            <el-main class="text-center h-prose"><router-view></router-view></el-main>
            <el-footer class="text-center">
                SCJ
            </el-footer>
        </el-container>
    </div>
</template>


<script setup lang="ts">
import LayoutHeader from './layout-header/index.vue'
</script>

<style scoped>

</style>