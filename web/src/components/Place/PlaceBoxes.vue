<template>
  <div class="place">
    <div class="photo"><img src="../../assets/house.jpg" alt="Photo" height="160px" width="240px"></div>
    <div class="name"><h1>{{ name }}</h1></div>
    <div class="category"> <h4>{{ category }}</h4></div>
    <div class="price"> <h4>Price: {{price}}€</h4></div>
    <div class="address"> <h4>{{ address.country }}, {{ address.state}}, {{ address.city}}</h4></div>
    <router-link class="placeButton" :to="{ name: 'PlaceDetails', query: {id: id}} ">Details</router-link>
  </div>
</template>

<script>
import BookingBox from '../BookingBox'

export default {
  name: 'App',
  components: {BookingBox},
  data () {
    return {
      owner: null,
      date: null,
      customer: null,
      rating: null,
      ratingToShow: null,
      ratingList: [],
      place: ''
    }
  },
  props: ['id', 'name', 'description', 'address', 'category', 'bookings', 'price'],

}
</script>

<style scoped>
  .place {
    border: 1px solid;
    display: inline-block;
    width: 60%;
    margin: 10px 0 10px 0;
    border-radius: 10px;
    background-image: url('../../assets/AsfaltBackground.png');

  }

  .name {
    font-size: 20px;
  }

  .placeButton {
    display: inline-block;
    outline: none;
    cursor: pointer;
    border: solid 1px #000000;
    background: lightgray;
    text-align: center;
    color: black;
    text-decoration: none;
    font: 14px/100% Arial, Helvetica, sans-serif;
    padding: .5em 2em .55em;
    text-shadow: 0 1px 1px rgba(0,0,0,.3);
    -webkit-border-radius: .5em;
    -moz-border-radius: .5em;
    border-radius: .3em;
    -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.2);
    -moz-box-shadow: 0 1px 2px rgba(0,0,0,.2);
    box-shadow: 0 1px 2px rgba(0,0,0,.2);
    margin: 10px 0 10px 5px;
  }
  .placeButton:hover {
    background: whitesmoke;
  }
  router-link {
    background-color: darkred;
  }
  h1{
    color: black;
  }
  img {
    border-radius: 20px;
    margin-top: 35px;
  }

</style>
