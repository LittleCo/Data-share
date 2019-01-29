<template>
  <q-page class="flex flex-center">
    <q-card inline class="register-card q-mt-lg relative-position" color="white">
      <q-card-title class="bg-primary text-white">
        Register
      </q-card-title>
      <q-card-main>
        <q-field helper="昵称" :error="$v.user.name.$error" error-label="请输入昵称" class="q-mt-lg">
          <q-input v-model.trim="user.name" :autofocus="true" @input="$v.user.name.$touch()" />
        </q-field>
        <q-field helper="学号" :error="$v.user.stuId.$error" error-label="请输入学号" class="q-mt-lg">
          <q-input v-model.trim="user.stuId" type="text" @input="$v.user.stuId.$touch()" ref="stuId" />
        </q-field>
        <q-field helper="密码" :error="$v.user.password.$error" error-label="密码最低 6 位"  class="q-mt-lg">
          <q-input v-model.trim="user.password" type="password" @input="$v.user.password.$touch()" ref="password" @keyup.enter="login" /> 
        </q-field>
      </q-card-main>
      <q-card-separator class="q-mt-lg" />
        <q-card-action  class="button-action">
          <q-btn label="登录"  flat color="secondary" @click="$router.push({name:'login'})" />
          <q-btn label="注册"   :disable="$v.user.$invalid" icon="arrow_right_alt" color="primary"  />
        </q-card-action>
        <inner-loading :loading="loading"></inner-loading>
    </q-card>
  </q-page>
</template>

<script>
import innerLoading from '../../components/innerLoading'
import {minLength, required} from 'vuelidate/lib/validators'

export default {
  name:'Login',
  components: {
    innerLoading
  },
  data() {
    return {
      loading: false,
      user: {
        name:'',
        stuId:'',
        password: ''
      }
    }
  },
  validations: {
    user: {
      name:{required },
      stuId:{required },
      password: {required, minLength: minLength(6)}
    }
  }
}
</script>

<style scoped>
  .register-card {
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
