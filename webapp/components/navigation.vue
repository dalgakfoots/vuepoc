<script setup>
import {useAuthStore} from "../stores/authStore";

const authStore = useAuthStore();

</script>
<template>
  <nav>
    <ul>
      <li>
        <NuxtLink to="/">HOME</NuxtLink>
      </li>
      <li>
        <NuxtLink to="/list">LIST</NuxtLink>
      </li>
    </ul>
  </nav> <br/>
  <div v-if="Object.keys(authStore.user).length !== 0">
    <span>userId : {{ authStore.user.id}} </span> <br/>
    <span>username : {{ authStore.user.username}} </span> <br/>
    <span>nickname : {{ authStore.user.nickname}} </span> <br/>
  </div>
</template>