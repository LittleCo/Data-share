<template>
  <q-layout view="lHh Lpr lFf">
    <q-layout-header>
      <q-toolbar color="primary" :glossy="$q.theme === 'mat'" :inverted="$q.theme === 'ios'">
        <q-btn flat dense round @click="leftDrawerOpen = !leftDrawerOpen" aria-label="Menu">
          <q-icon name="menu"/>
        </q-btn>
        <q-toolbar-title>
          <a href="#" class="app-title">工大考试资料分享</a>
        </q-toolbar-title>
      </q-toolbar>
    </q-layout-header>

    <q-layout-drawer
      v-model="leftDrawerOpen"
      :content-class="$q.theme === 'mat' ? 'bg-grey-2' : null"
    >
      <q-list no-border link inset-delimiter>
        <q-list-header>待考试课程</q-list-header>
        <div class="side-item">
          <a href="../pages/math" class="side-links">
            <q-item>
              <q-item-side icon="school"/>
              <q-item-main label="高等数学1 " sublabel="02-01 公共楼301考试"/>
            </q-item>
          </a>
        </div>
        <div class="side-item">
          <a href="../pages/english" class="side-links">
            <q-item>
              <q-item-side icon="school"/>
              <q-item-main label="大学英语 3 " sublabel="02-01 公共楼301考试"/>
            </q-item>
          </a>
        </div>
        <div class="side-item">
          <a href="../pages/programC" class="side-links">
            <q-item>
              <q-item-side icon="school"/>
              <q-item-main label="C语言程序设计" sublabel="02-01 公共楼301考试"/>
            </q-item>
          </a>
        </div>
        <div class="side-item">
          <a href="../pages/digitalLogic" class="side-links">
            <q-item>
              <q-item-side icon="school"/>
              <q-item-main label="数字逻辑与数字系统" sublabel="02-01 公共楼301考试"/>
            </q-item>
          </a>
        </div>
        <div class="side-item">
          <a href="../pages/OOP" class="side-links">
            <q-item>
              <q-item-side icon="school"/>
              <q-item-main label="面向对象程序设计" sublabel="02-01 公共楼301考试"/>
            </q-item>
          </a>
        </div>
      </q-list>
    </q-layout-drawer>

    <q-page-container>
      <router-view/>
    </q-page-container>
  </q-layout>
</template>

<script>
import { openURL } from "quasar";

export default {
  name: "MyLayout",
  data() {
    return {
      leftDrawerOpen: this.$q.platform.is.desktop
    };
  },
  methods: {
    openURL
  }
};
</script>

<style scope>
.app-title {
  text-decoration: none;
  color: #fff;
}
.side-links {
  text-decoration: none;
  color: rgb(20, 20, 20);
}
.side-item:hover {
  background: rgba(189, 189, 189, 0.5);
}
</style>
