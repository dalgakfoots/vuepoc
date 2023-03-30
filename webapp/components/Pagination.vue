<script setup>
import {useListStore} from "../stores/listStore";

const listStore = useListStore();

const totalPage = computed( ()=> {
  return listStore.getTotalPageNumber
});

const currentPage = computed(() => {
  return listStore.getCurrentPageNumber;
});

const changeCurrentPage = listStore.changeCurrentPageNumber;

</script>
<template>
  <div>
    <NuxtLink v-for="i in totalPage"
       style="padding-right: 10px ; padding-left: 10px"
       :to="`/list?page=${i}`" @click="changeCurrentPage(`${i}`)"
              :style="{fontWeight : i === +currentPage ? 'bold' : 'normal'}"
    >
      {{i}}
    </NuxtLink>
  </div>
</template>