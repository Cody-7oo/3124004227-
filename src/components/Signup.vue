<template>
  <!-- 文字直接放在模板顶部 -->
  <div class="top-text">注册</div>
  <div id="app">
    <label for="username">账号</label>
    <input   type="text" >
    <button>登录</button>
  </div>

</template>


<script>



</script>

<style scoped>

.top-text {
  position: fixed;  /* 固定定位 */
  text-align: center;
  top: 0;           /* 距离顶部0像素 */
  left: 0;          /* 距离左侧0像素 */
  width: 100%;      /* 宽度撑满 */
  background: pink; /* 可选：添加背景色 */
  z-index: 1000;    /* 确保在最上层 */
  padding: 10px;    /* 可选：内边距 */
  box-shadow: 0 2px 5px rgba(0,0,0,0.1); /* 可选：阴影效果 */
  font-size: large;
}
</style>
<script setup lang="ts">
</script>