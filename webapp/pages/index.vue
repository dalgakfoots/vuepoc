<script setup>
import Navigation from "../components/navigation.vue";
import {useAuthStore} from "../stores/authStore";

const store = useAuthStore();

const getLoginUser = store.loginUser;

const user = computed( () => {
  return store.user;
})

</script>
<template>
  <header>
    <h1>WELCOME TO THE HOMEPAGE</h1>
    <navigation></navigation>
    <p v-if="user">
      {{user}}
    </p>
    <button @click="getLoginUser">
      GET LOGIN USER
    </button>
  </header>
</template>
