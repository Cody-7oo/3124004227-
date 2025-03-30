<template>
  <div class="top-text"><h2>{{ islogin ? '登录' : '注册' }}</h2></div>
  <div id="app">
    <div class="login">

      <label >账号</label>
      <input
          type="text"
          required
      />
      <br>
      </div>
    <div>
      <label >密码</label>
      <input   type="password" required >

      <button class="myButton" type="submit">{{ islogin ? '登录' : '注册' }}</button>
      <button class="myButton" @click="signup">没有账号？点击注册</button>
    </div>
    <div v-if="!islogin">
      <label>确认密码</label>
      <input type="password" required>
    </div>

  </div>

</template>


<script setup>

const signup=()=>{
  islogin.value=!islogin.value;
}

import {ref} from "vue";

const islogin=ref(true);

</script >

<style scoped>



.length{
  width: 100%;

}


.login{


}
.myButton{
  background-color: green;
  color: white;
  text-align: center;
  display: flex;
  gap: 10px;
}

.top-text {
  position: fixed;
  text-align: center;
  top: 0;
  left: 0;
  width: 100%;
  background: pink;
  z-index: 1000;
  padding: 10px;
  box-shadow: 0 2px 5px rgba(0,0,0,0.1);
  font-size: large;
}
</style>
<script setup lang="ts">
</script>