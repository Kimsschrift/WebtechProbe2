<template>
  <div class="about-me">
    <!-- TODO:  -->
    <h1>Über mich</h1>
    <AboutMeDetails></AboutMeDetails>

  </div>
</template>

<script setup lang="ts">
import AboutMeDetails from "@/components/AboutMeDetails.vue";
</script>

<style scoped>
.about-me {
  text-align: center;
  padding-top: 2rem;
}
</style>