<template>
  <q-page class="flex flex-center">
    <q-card inline class="login-card q-mt-lg relative-position" color="white">
      <q-card-title class="bg-primary text-white">
        Login
      </q-card-title>
      <q-card-main>
        <q-field helper="学号" class="q-mt-lg">
          <q-input v-model.trim="user.stuId" type="text" ref="stuId" />
        </q-field>
        <q-field helper="密码"  class="q-mt-lg">
          <q-input v-model.trim="user.password" type="password" ref="password" @keyup.enter="login" /> 
        </q-field>
      </q-card-main>
      <q-card-separator class="q-mt-lg" />
        <q-card-action  class="button-action">
          <q-btn label="注册"  flat color="secondary" @click="$router.push({name:'register'})" />
          <q-btn label="登录" @click="login()" icon="arrow_right_alt" color="primary"  />
        </q-card-action>
        <inner-loading :loading="loading"></inner-loading>
    </q-card>
  </q-page>
</template>

<script>
import innerLoading from '../../components/innerLoading'

export default {
  name:'Login',
  components: {
    innerLoading
  },
  data() {
    return {
      loading: false,
      user: {
        stuId:'',
        password: ''
      }
    }
  },
  methods: {
    login() {
      this.$v.user.$toucu()
      this.loading = true
      this.$store.dispatch('session/login',this.user).then(() => {
        this.loading = false
        this.$router.push({name:'index'})
        this.$q.notify({
          color:'positive',
          position:'top',
          message:'Login Successful',
          icon:'check_circle'
        })
      }).catch(error => {
        this.loading = false
        this.$q.notify({
          color:'native',
          position:'top',
          message: error.response.data.message || '密码错误',
          icon:'error_outline'
        })
      })
    },
    checkLogin() {
      if(!this.getCookie('session')){
        this.$router.push({name:'login'})
      }else {
        this.$router.push({name:'index'})
      }
    },
    // 请求用户信息
    getUserInfo(){
      
    }
  },
  // 检测是否已登录
  created() {
    this.checkLogin()
  },
  mounted() {
    this.$refs.user.focus()
  },
  // 检测路由变化
  watch: {
    '$route' : 'checkLogin'
  },
}
</script>

<style scoped>
  .login-card {
    width: 320px;
  }
  .button-action {
    display: flex;
    justify-content: flex-end;
    padding-bottom: .6em;
    padding-right: .6em;
  }
  .q-card-separator {
    height: 0;
  }
</style>
