<template>
  <div class="places">
    <PlaceBoxes v-for="place in places" v-bind="place" v-bind:key="place.id"></PlaceBoxes>
  </div>
</template>

<script>
import axios from 'axios'
import PlaceBoxes from './PlaceBoxes'
import authHeader from '../../services/auth-header'

export default {
  name: 'App',
  components: {
    PlaceBoxes
  },
  data () {
    return {
      places: [],
      id: this.$route.query.id
    }
  },
  mounted () {
    axios.get(process.env.API_URL + '/places/getAll', { headers: authHeader() }).then(response => { this.places = response.data })
  }
}
</script>
<style>
  .places{
    margin-top: 5px;
  }
</style>
