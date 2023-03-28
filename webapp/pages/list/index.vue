<script setup>
import {useListStore} from '../../stores/listStore';
import {onMounted, onServerPrefetch} from "vue";
import {useRouter} from "nuxt/app";

const store = useListStore();
const router = useRouter();

const getList = computed( () => {
  return store.getList;
})

const list = computed( () => {
  return store.list;
})

onMounted(async () => {
  await store.fetchListForClient();
})

onServerPrefetch(async () => {
  await store.fetchListForServer();
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
    <button @click="router.push({'path' : '/list/new'})">FETCH</button>
  </div>
</template>