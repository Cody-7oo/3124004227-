<template>
  <!-- 文字直接放在模板顶部 -->
  <div class="top-text">登录</div>
  <div id="app">
    <div class="login">
      <label >账号</label>
      <input   type="text" >
      <label >密码</label>
      <input   type="password" class="length" >
      <button class="myButton">登录</button>
      <button class="myButton" @click="signup">没有账号？点击注册</button>
    </div>

  </div>

</template>


<script>

export default {
  methods:{
    signup(){


    }


  }

}

</script>

<style scoped>



.length{
  width: 100%;

}


.login{
width: ;

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