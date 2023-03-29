<script setup>
import {useRoute , useRouter} from "nuxt/app";
import {useBoardStore} from "../../stores/boardStore";
import {onUnmounted, onBeforeMount, onServerPrefetch, onErrorCaptured} from "vue";

const route = useRoute();
const router = useRouter();
const store = useBoardStore();

const board = computed(() => {
  return store.board;
})

onServerPrefetch(async () => {
  await store.fetchDataForServer(route.params.id);
})

onBeforeMount(async () => {
  await store.fetchDataForClient(route.params.id);
})

onUnmounted(() => {
  store.unmountData();
})

const deleteBoard = async (id) => {
  // TODO 작성자인지 판단하는 메서드 필요
  let response = await fetch(`/api/list/${id}`, {
    method : 'DELETE',
  });
  await router.push('/list');
}

definePageMeta({
  validate: async (route) => {
    // return 값(boolean)에 따라 404 에러 발생
    return /^\d+$/.test(route.params.id);
  },
});


</script>
<template>
  <h1>DETAIL TEST</h1>
  <navigation></navigation>
    <div v-if="store.loading">
      <h1>TITLE : {{ board.title }}</h1>
      <h3>Author : {{board.author}}</h3>
      <p>{{board.content}}</p>
      <span>regDate : {{board.regDate}}</span> <br/>
      <span>upDate : {{board.upDate}}</span>
    </div>

    <button @click="router.push({ path : '/list'})">
      Go To List
    </button>
    <button @click="deleteBoard(route.params.id)">
      Delete
    </button>
    <button @click="router.push({path : `/list/update/${route.params.id}`})">
      Update Form
    </button>
</template>