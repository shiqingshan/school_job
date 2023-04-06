<template>
  <div id="wrap" class="wrap-sign">
    <div class="page-sign">
      <div id="header"></div>
      <div class="login-register-unite">
        <div class="side-slide-box">
          <ul class="desc-list"></ul>
        </div>
        <div class="login-register-content">
          <div class="login-phone-wrapper">
            <h3 class="title">校园招聘登录</h3>
            <AppLoginform />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import AppLoginform from './components/loginform/index.vue';
</script>

<style lang="scss" scoped>
#wrap {
  min-height: 100%;
  overflow: visible;
  overflow-x: hidden;
}
.wrap-sign {
  height: 100%;
}
.page-sign {
  background: #6979cb url(https://img.bosszhipin.com/static/file/2022/zlqc2m9fao1667185843533.png) bottom/100% auto
    no-repeat;
  width: 100vw;
  height: 100vh;
  #header {
    background: 0 0;
    box-shadow: none;
  }
}
.login-register-unite {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 728px;
  height: 580px;
  margin-left: -364px;
  margin-top: -290px;
  background: #fff;
  box-shadow: 0 6px 13px 0 rgba(0, 0, 0, 0.1);
  border-radius: 28px;
  z-index: 2;
  box-sizing: border-box;
}
.side-slide-box {
  float: left;
  width: 240px;
  height: 100%;
  background: linear-gradient(192deg, #697ecb, #edded2);
  border-radius: 28px 0 0 28px;
  padding-left: 32px;
  font-size: 14px;
  box-sizing: border-box;
  .desc-list {
    overflow: hidden;
    li {
      margin-top: 50px;
    }
  }
}
.login-phone-wrapper {
  position: relative;
  width: 360px;
  margin: 0 auto;
}

.title {
  font-size: 22px;
  font-weight: 500;
  color: #222;
  line-height: 30px;
  text-align: center;
  margin-top: 10%;
}

a,
b,
body,
button,
dd,
div,
dl,
em,
footer,
form,
h1,
h2,
h3,
h4,
h5,
h6,
i,
input,
label,
li,
nav,
p,
select,
span,
td,
textarea,
u,
ul {
  padding: 0;
  margin: 0;
  -webkit-tap-highlight-color: transparent;
  -webkit-text-size-adjust: none;
}
ul {
  display: block;
  list-style-type: disc;
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
  padding-inline-start: 40px;
}
</style>
