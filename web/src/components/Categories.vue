<template>
  <div class="categories">
    <div class="filter">
      <input id="locationInput" type="text" name="myLocation" placeholder="Choose location"/>
      <input id="timeInput" type="date" name="myTime" placeholder="When?"/>
      <input id="peopleInput" type="number" name="myPeople" placeholder="How many people?"/>
      <input id="priceInput" type="number" name="myPrice" placeholder="Price per hour"/>

    </div>
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

<style>
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
