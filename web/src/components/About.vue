<template>
  <div class="about">
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
    axios.get('http://localhost:8080/api/about').then(response => (this.msg = response.data))
  }
}
</script>
