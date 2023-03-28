<script setup>
import {usePiniaTestStore} from "../stores/listStore";
import {onMounted, onServerPrefetch} from "vue";

const store = usePiniaTestStore();
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
    <h1>PINIA TEST</h1>
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
    <button @click="store.fetchListForClient">FETCH</button>
  </div>
</template>