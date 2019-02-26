<template>
  <div class="places">
    <h1>{{ msg }}</h1>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: 'App',
    data () {
      return {
        msg: null
      }
    },
    mounted () {
      axios.get('http://localhost:8080/places/getAll').then(response => (this.msg = response.data))
    }
  }
</script>
