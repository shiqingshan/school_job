<template>
  <div class="home">
    <div class="search"></div>
    <div class="jobmenuslect">
      <JobMenuSelect />
    </div>
    <div class="hotjob">
      <HotJob />
    </div>
    <div class="hotcompany">
      <HotCompany />
    </div>
  </div>
</template>

<script lang="ts" setup>
import JobMenuSelect from './componets/jobmenuselect/index.vue';
import HotJob from './componets/hotjob/index.vue';
import HotCompany from './componets/hotcompany/index.vue';
</script>

<style lang="scss" scoped>
.jobmenuslect {
  margin-top: 20px;
}
</style>
