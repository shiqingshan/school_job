<template>
  <div class="loginform">
    <div class="identity-tab">
      <n-tabs type="segment">
        <n-tab name="求职"> 求职 </n-tab>
        <n-tab name="招聘"> 招聘 </n-tab>
      </n-tabs>
    </div>
    <div class="form">
      <n-form :model="form" :rules="rules" size="large" :label-width="80">
        <n-form-item label="用户名" path="username" label-placement="left">
          <n-input v-model="form.username" placeholder="请输入用户名" />
        </n-form-item>
        <n-form-item label="密码" path="password" label-placement="left">
          <n-input
            v-model="form.password"
            show-password-on="mousedown"
            placeholder="请输入密码"
            type="password"
            :input-props="{ autocomplete: 'current-password webauthn' }"
          />
        </n-form-item>
      </n-form>
      <n-grid :x-gap="12" :y-gap="8" :cols="1">
        <n-grid-item>
          <n-button block type="primary" ghost color="#6979cb" round @click="submitForm">登录</n-button>
        </n-grid-item>
        <n-grid-item>
          <n-button block type="primary" ghost color="#6979cb" round @click="registerForm">注册</n-button>
        </n-grid-item>
      </n-grid>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue';
const form = ref({
  username: '',
  password: ''
});

const rules = ref({
  username: [
    {
      required: true,
      message: '请输入用户名',
      trigger: 'blur'
    }
  ],
  password: [
    {
      required: true,
      message: '请输入密码',
      trigger: 'blur'
    }
  ]
});

const submitForm = () => {
  // handle form submission
};
const registerForm = () => {
  // handle form registration
};
</script>

<style lang="scss" scoped>
.loginform {
  margin-top: 20%;
  margin-left: 20%;
}
.form {
  margin-top: 20px;
}
</style>
