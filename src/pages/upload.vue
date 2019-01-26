<template>
  <section class="upload-container">
    <section class="upload-area">
      <q-uploader :url="url" color="primary"  inverted stack-label="可将文件拖至空白区域" maltiple="true"  />
    </section>
  </section>
</template>

<script>
export default {
  name:'upload',
  data() {
    return {
      url:''
    }
  }
}
</script>

<style scoped>
  .upload-container {
    width: 100vw;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: flex-start;
  }
  .upload-area {
    width: 90%;
    height: 50%;
    margin: 0 auto;
    display: flex;
    align-items: flex-end;
    justify-content: center;
    background: transparent;
    box-shadow: 0 1px 5px rgba(0, 0, 0, .2);
  }
  .q-uploader {
    width: 100%;
    min-width: 160px;
    padding-left: 25%;
    padding-right: 25%;
    padding-top: 50%;
  }
</style>
