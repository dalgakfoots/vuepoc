<script setup>
import {useRouter} from "nuxt/app";
import {ref} from "vue";

const router = useRouter();
const title = ref('');
const author = ref('');
const content = ref('');

const handleSubmit = async () => {
  const data = {
    title: title.value,
    author: author.value,
    content: content.value,
  };


  let response = await fetch('/api/list/new', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(data),
  });

  let result = await response.json();
  await router.push({path : '/list'})
}

const reset = () => {
  title.value = '';
  author.value = '';
  content.value = '';
}

</script>
<template>
  <form @submit.prevent="handleSubmit" id="boardForm">
    <label for="title">title</label>
    <input id="title" name="title" type="text" v-model="title">
    <br/>
    <label for="author">author</label>
    <input id="author" name="author" type="text" v-model="author">
    <br/>
    <label for="content">content</label>
    <textarea id="content" name="content" v-model="content"></textarea>
    <br/>
    <button type="submit">submit</button>
    <button type="button" @click="reset">reset</button>
    <button type="button" @click="router.push({path : '/list'})">Go To List</button>
  </form>
</template>