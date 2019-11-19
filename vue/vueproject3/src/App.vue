<template>
<div id="app">
<div class='headtitle'><h2>SSAFY HRM LIST</h2></div>
<div class='search_box'>
 <nav>
        <router-link class="btn btn-primary" to="/">모든사원 보기</router-link> |
        <router-link class="btn btn-primary" to="/add">사원추가</router-link> |
        <router-link class="btn btn-primary" to="/search">이름으로 사원 찾기</router-link> |
        <router-link class="btn btn-primary" to="/searchbyid">아이디로 사원 찾기</router-link> |
        <router-link class="btn btn-primary" to="/chartcustomer">부서별 인원보기</router-link>
 </nav>
</div>
        <router-view/>
</div>
</template>

<script>
//최상위 컴포넌트, 라우터 링크의 to로 연결하기 -> 아래 라우터 뷰에서 보여주기
//컴포넌트는  template와 뷰 한개로 구성
export default {
  name: "app" //위 div id와 똑같음
};
</script>

<style>

</style>
