<template>
  <section class="download-container">
    <a href="#" class="paper-title">{{this.title}}
      <q-btn icon="create" label="下载" class="download-button"></q-btn>
    </a>
  </section>
</template>

<script>
export default {
  name: "PaperItem",
  props: {
    title: {
      type: String,
      default:'试卷标题'
    }
  }
};
</script>
<style scoped>
.download-container {
  display: flex;
  padding-top: .6em;
  padding-bottom: .4em;
  background: transparent;
  vertical-align: middle;
  box-shadow: 0 1px 5px rgba(0, 0, 0, 0.2);
}
.paper-title {
  display: flex;
  align-items: center;
  text-decoration: none;
  cursor: pointer;
  color: rgb(20, 20, 20);
  padding-left: 2vw;
  vertical-align: middle;
}
.download-button {
  box-shadow: none;
  background-color: #fff;
  color: blue;
  margin-left: 2vw;
}
</style>

