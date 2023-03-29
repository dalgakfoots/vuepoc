<script setup>
import {useRoute, useRouter, createError , showError} from "nuxt/app";
import {useBoardStore} from "../../../stores/boardStore";
import {useAuthStore} from "../../../stores/authStore";
import {onBeforeMount, onServerPrefetch, onUnmounted} from "vue";

const route = useRoute();
const router = useRouter();
const store = useBoardStore();
const authStore = useAuthStore();

const board = computed(() => {
  return store.board;
})

onServerPrefetch(async () => {
  // TODO 작성자인지 판단하는 메서드 필요
  await store.fetchDataForServer(route.params.id);
});

onBeforeMount(async () => {
  // TODO 작성자인지 판단하는 메서드 필요
  await store.fetchDataForClient(route.params.id);
});

onUnmounted(() => {
  store.unmountData();
})


const handleSubmit = async () => {

  let response = await fetch('/api/list/update', {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(board.value),
  });

  if(!response.ok) throw showError({statusCode: response.statusCode , message : response.statusText})

  let result = await response.json();
  await router.push({path: `/list/${route.params.id}`})
}

</script>
<template>
  <form @submit.prevent="handleSubmit" id="boardForm">
    <label for="title">title</label>
    <input id="title" name="title" type="text" v-model="board.title">
    <br/>
    <label for="author">author&nbsp;&nbsp;</label>
    <span id="author">{{ authStore.user.nickname }}</span>
    <br/>
    <label for="content">content</label>
    <textarea id="content" name="content" v-model="board.content"></textarea>
    <br/>
    <button type="submit">submit</button>
    <button type="button" @click="router.push({path : '/list'})">Go To List</button>
  </form>
</template>