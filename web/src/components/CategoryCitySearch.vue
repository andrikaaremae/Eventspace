<template>
  <div class="categories">
    <div class="filter">
      <input id="locationInput" type="text" name="myLocation" placeholder="Choose location"/>
      <input id="timeInput" type="date" name="myTime" placeholder="When?"/>
      <input id="peopleInput" type="number" name="myPeople" placeholder="How many people?"/>
      <input id="priceInput" type="number" name="myPrice" placeholder="Price per hour"/>
    </div>
    <PlaceBox v-for="place in places" v-if="place.category==category && place.address.city==city" v-bind="place" v-bind:key="place.id"></PlaceBox>
  </div>
</template>

<script>
  import axios from 'axios'
  import PlaceBox from './PlaceBox'

  export default {
    name: 'App',
    components: {
      PlaceBox
    },
    data () {
      return {
        places: [],
        category: this.$route.query.category,
        city: this.$route.query.city,
      }
    },
    mounted () {
      axios.get('http://localhost:8080/places/getAll').then(response => { this.places = response.data })
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
