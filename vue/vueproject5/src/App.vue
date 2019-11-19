<template>
    <div id="app">
    <div class='headtitle'><h1>SSAFY HRM</h1></div>

<div id="top_menu_wrap">
	<div id="_top_menu">
		<ul class="navi">
      <li v-if="isAuthenticated && isProfileLoaded">
        <span class="logout">[{{name}}님]</span> | 
      </li>
      <li v-if="isAuthenticated" @click="logout">
        <span class="logout">Logout</span> | 
      </li>
      <li v-if="isAuthenticated" @click="aboutme">
         <span class="aboutme">자신의 정보</span>
      </li>
      <!--<li v-if="!isAuthenticated">
       <router-link to="/login">로그인</router-link> 
           <login/>
      </li>-->
		</ul>
	</div>
</div>
      
<div class='search_box' v-if="isAuthenticated">
 <nav>
        <router-link class="btn btn-primary" to="/">모든사원 보기</router-link> |
        <router-link class="btn btn-primary" to="/add">사원추가</router-link> |
        <router-link class="btn btn-primary" to="/search">이름으로 사원 찾기</router-link> |
        <router-link class="btn btn-primary" to="/searchbyid">아이디로 사원 찾기</router-link> |
        <router-link class="btn btn-primary" to="/chartcustomer">부서별 인원보기</router-link> |
        <router-link class="btn btn-primary" to="/chartpiecustomer">부서별 인원보기2</router-link>
 </nav>
</div>
<div>
        <router-view v-if="isAuthenticated" />
</div>
<div v-if="!isAuthenticated">
           <login/>
</div>
    </div>
  
</template>

<script>
  import { mapGetters, mapState } from 'vuex'
  import Login from './components/Login'
  import {AUTH_LOGOUT} from './store/actions/auth'

export default {
  name: "app",
  components: {
      Login
    },
    methods: {
      logout: function () {
        alert('로그아웃 합니다. 로그인 하십시오.')
        this.$store.dispatch(AUTH_LOGOUT).then(() => this.$router.push('/login'))
      },
       aboutme: function () {
        alert('본인의 정보를 보입니다. 구현하세요.~~.')
        //this.$router.push('/')
      }
    },
    computed: {
      ...mapGetters(['isAuthenticated', 'isProfileLoaded','getProfile']),
      ...mapState({
        authLoading: state => state.auth.status === 'loading',
        name: state => `${state.user.profile.name}`,
      }),
    loading: function () {
      return this.authStatus === 'loading' && !this.isAuthenticated
    }
  }
};
</script>
<style>
.navi {list-style-type: none }
.navi li {display: inline-block; text-decoration: none }
.logout{background-color: blue; color: burlywood}
</style>
