<template>
  <div class="categories">
    <div class="filter">
      <input id="locationInput" type="text" name="myLocation" placeholder="Choose location"/>
      <input id="timeInput" type="date" name="myTime" placeholder="When?"/>
      <input id="peopleInput" type="number" name="myPeople" placeholder="How many people?"/>
      <input id="priceInput" type="number" name="myPrice" placeholder="Price per hour"/>
    </div>
    <PlaceBoxes v-for="place in places" v-if="place.category==category" v-bind="place" v-bind:key="place.id"></PlaceBoxes>
  </div>
</template>

<script>
import axios from 'axios'
import PlaceBoxes from '../Place/PlaceBoxes'

export default {
  name: 'App',
  components: {
    PlaceBoxes
  },
  data () {
    return {
      places: [],
      categories: [],
      category: this.$route.query.category
    }
  },
  mounted () {
    axios.get(process.env.API_URL + '/places/getAll').then(response => { this.places = response.data })
  }
}
</script>

<style scoped>
  h1 {
    font-size: 50px;
  }
  input {
    height: 30px;
    background-color: whitesmoke;
    width: 300px;
    border-radius: 5px;
    font-size: large;
    padding: 5px 0 5px 20px;
  }
</style>
