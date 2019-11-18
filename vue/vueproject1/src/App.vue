<template>
<div id="app">
<div class='headtitle'><h2>SSAFY HRM LIST</h2></div>
<div class='search_box'>
 <nav>
        <router-link class="btn btn-primary" to="/">모든사원 보기</router-link> |
        <router-link class="btn btn-primary" to="/search">이름으로 사원 찾기</router-link> |
        <router-link class="btn btn-primary" to="/searchbyid">아이디로 사원 찾기</router-link> |
 </nav>
</div>
        <router-view/>
</div>
</template>

<script>
export default {
  name: "app"
};
</script>

<style>

</style>
