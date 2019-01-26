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
        <q-field helper="密码" class="q-mt-lg">
          <q-input v-model.trim="user.password" type="password" ref="password" /> 
        </q-field>
      </q-card-main>
      <q-card-separator class="q-mt-lg" />
        <q-card-action  class="button-action">
          <q-btn label="忘记密码"  flat color="secondary" />
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
      this.loading = true
      setTimeout(() => {
        this.loading = false
        this.$router.push({name:'index'})
      },1000) 
    }
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
