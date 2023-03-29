<template>
<button @click="handleError">
  clear error
</button>
  <div>
    {{ error.url}}
    {{ error.statusCode}}
    {{ error.message}}
  </div>
</template>

<script setup>
const props = defineProps({
  error: Object, // ts 로 interface 작성 필요할지도..
});

const handleError = () => clearError( {redirect : '/'});
</script>