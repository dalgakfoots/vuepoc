<script setup>
import {useRoute , useRouter} from "nuxt/app";
import {useBoardStore} from "../../stores/boardStore";
import {onUnmounted, onBeforeMount, onServerPrefetch} from "vue";

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
</template>