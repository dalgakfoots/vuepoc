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
    <a v-for="i in totalPage"
       style="padding-right: 10px ; padding-left: 10px"
       :href="`/list?page=${i}`" @click="changeCurrentPage(`${i}`)"
              :style="{fontWeight : i === +currentPage ? 'bold' : 'normal'}"
    >
      {{i}}
    </a>
  </div>
</template>