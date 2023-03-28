<script setup>
import {useRouter} from "nuxt/app";
const router = useRouter();

</script>
<template>
  <form id="boardForm">
    <label for="title">title</label>
    <input id="title" name="title" type="text">
    <br/>
    <label for="author">author</label>
    <input id="author" name="author" type="text">
    <br/>
    <label for="content">content</label>
    <textarea id="content" name="content">

    </textarea>
    <br/>
    <button type="submit">submit</button>
    <button type="reset">reset</button>
    <button type="button" @click="router.push({path : '/list'})">Go To List</button>
  </form>
</template>