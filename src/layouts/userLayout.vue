<template>
  <q-layout>
    <q-page-conainer>
      <!-- injected pages -->
      <router-view></router-view>
    </q-page-conainer>
  </q-layout>
</template>

<script>
export default {
  name:'userLayout',
  data() {
    return {}
  }
}
</script>
<style scoped>
  .q-layout {
    background: url('../assets/background.png') no-repeat center center fixed;
    background-size: cover;
  }
</style>

