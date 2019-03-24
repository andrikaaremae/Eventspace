<template>
  <div class="places">
    <PlaceBox v-for="place in places" v-bind="place" v-bind:key="place.id"></PlaceBox>
  </div>
</template>

<script>
import axios from 'axios'
import PlaceBox from './PlaceBox'
import authHeader from '../services/auth-header'

export default {
  name: 'App',
  components: {
    PlaceBox
  },
  data () {
    return {
      places: []
    }
  },
  mounted () {
    axios.get('http://localhost:8080/places/getAll').then(response => { this.places = response.data })
  }
}
</script>
