<script setup>
import {useListStore} from '../../stores/listStore';
import {useAuthStore} from '../../stores/authStore';

import {onMounted, onServerPrefetch, onUpdated} from "vue";
import {useRouter , useRoute , createError , showError} from "nuxt/app";

const store = useListStore();
const userStore = useAuthStore();

const router = useRouter();
const route = useRoute();

const isLogin = computed( () => {
  return Object.keys(userStore.user).length !== 0
})

const list = computed( () => {
  return store.list;
})

onMounted(async () => {
  console.log('on client side!')
  await store.fetchListForClient(route);
  if(list.value.length === 0) throw createError({
    statusCode : 404,
    message : `Not Found Page number ${route.query.page}`
  });
})

onServerPrefetch(async () => {
  console.log('on server side!')
  await store.fetchListForServer(route);
  if(list.value.length === 0) throw showError({
    statusCode : 404,
    message : `Not Found Page number ${route.query.page}`
  });
})

</script>
<template>
  <div>
    <h1>LIST TEST</h1>
    <navigation></navigation>
    <table>
      <thead>
      <tr>
        <th>id</th>
        <th>title</th>
        <th>author</th>
        <th>content</th>
        <th>regDate</th>
        <th>upDate</th>
        <th>etc.</th>
      </tr>
      </thead>
      <tbody>
      <Board v-for="item in list" :board="item"/>
      </tbody>
    </table>
    <hr/>
    <button @click=" isLogin ? router.push('/list/new'): ''">WRITE</button>
    <Pagination/>
  </div>
</template>