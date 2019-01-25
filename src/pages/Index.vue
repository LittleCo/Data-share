<template>
  <q-page>
    <q-search v-model="search" type="text" placeholder="请输入要查找的学科" class="search-box" />
      <section class="l-sub-search" id="recent-search">
        <h5 class="subtitle">最近搜索</h5>
        <ul class="items-list">
          <li><a href="#">线性代数</a></li>
          <li><a href="#">汇编语言</a></li>
          <li><a href="#">已经是过了</a></li>
        </ul>
      </section>
    <span class="single-line"></span>
    <section class="l-sub-search" id="hot-points">
      <h5 class="subtitle">热门</h5>
      <ul class="items-list">
        <li><a href="#">高等数学</a></li>
          <li><a href="#">大学英语</a></li>
          <li><a href="#">C语言程序设计</a></li>
      </ul>
    </section>
  </q-page>
</template>

<style>
</style>

<script>
import paperItem from "../components/paperItem";
export default {
  name: "PageIndex",
  components: {
    paperItem
  }
};
</script>
<style>
.search-box {
  width:80%;
  margin: 0 auto;
  padding-top:12%;
}
.l-sub-search {
  width:80%;
  margin: 0 auto;
  padding-top: 8%;
}
.subtitle{ 
  font-size: 1.3em;
}
.items-list {
  list-style-type: none;
}
.items-list > li {
  padding-top: .2em;
  padding-bottom: .2em;
}
.items-list >li > a {
  text-decoration: none;
  color: rgb(20,20,20);
}
</style>