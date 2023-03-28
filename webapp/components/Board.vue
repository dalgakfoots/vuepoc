<script setup>
const props = defineProps({
  board : Object,
})
const {board} = toRefs(props);

</script>
<template>
  <tr>
    <td>
      {{ board.id }}
    </td>
    <td>
      <NuxtLink :to="`/list/${board.id}`">{{ board.title }}</NuxtLink>
    </td>
    <td>
      {{ board.author }}
    </td>
    <td>
      {{ board.content }}
    </td>
    <td>
      {{ board.regDate }}
    </td>
    <td>
      {{ board.upDate }}
    </td>
    <td>
      made by Board Component
    </td>
  </tr>
</template>