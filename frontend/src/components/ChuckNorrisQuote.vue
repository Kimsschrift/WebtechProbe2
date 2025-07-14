<template>
  <div class="quote-wrapper">
    <img
        alt="chuck-norris"
        src="../assets/chuck-norris.png"
        class="img"
        @click="loadRandomQuote"
    />
    <h1 class="quote">"{{ randomQuote }}"</h1>
  </div>
</template>

<script setup>
import {ref} from 'vue'
import axios from 'axios'

const randomQuote = ref('Wenn alles funktioniert, steht hier ein Chuck Norris Spruch.')

function loadRandomQuote() {
  // TODO: Rufen Sie hier das Backend mittels axios.get(...).then(...).catch(...) auf
  const index = getRandomInt(79);
  axios.get(`api/v1/quotes?index=${index}`)
      .then(response => {
        randomQuote.value = response.data.quote;
      })
      .catch(error => {
        console.error("Fehler beim Laden des Spruchs:", error)
        randomQuote.value = "Hoppla, da ist Chuck Norris wohl ein Fehler unterlaufen."
      })
}

function getRandomInt(maxExclusive) {
  return Math.floor(Math.random() * maxExclusive);
}
</script>

<style scoped>
.quote-wrapper {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  height: 100%;
  width: 95%;
  margin: auto;
}
h1 {
  font-size: 4vw;
  text-align: center;
  font-style: italic;
}
.img {
  width: 50%;
}
.quote {
  width: 50%;
}

@media screen and (max-width: 780px) {
  .quote-wrapper {
    display: flex;
    flex-direction: column;
  }
  .img {
    width: 100%;
  }
  .quote {
    width: 100%;
  }
}
</style>
