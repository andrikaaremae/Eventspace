<template>
  <div class="place">
    <div class="photo"><img src="../assets/house.jpg" alt="Photo" height="160px" width="240px"></div>
    <div class="name"><strong>{{ name }}</strong></div>
    <div class="address">{{ address.country }}, {{ address.state}}, {{ address.city}}, {{ address.street}}, {{ address.houseNumber }}, {{ address.zipCode }}</div>
    <div class="description"><i>{{ description }}</i></div>
    <div class="category"><b>Available for: </b>{{ category }}</div>
    <b>Bookings</b>
    <div class="bookingBox"><BookingBox v-for="booking in bookings" v-bind="booking" v-bind:key="booking.id">></BookingBox></div>
    <div class="addBookingForm">
      <form method="post" @submit.prevent="addBooking">
        <label>
          Date:
          <input type="date" v-model="date" required>
        </label>
        <label>
          Price:
          <input type="number" name="price" min="0" v-model="price" required>
        </label>
        <button class="placeButton">Add booking</button>
      </form>
      <button v-on:click="deletePlace"  class="placeButton">Delete</button>
      <router-link class="placeButton" :to="{ name: 'Edit', query: {id: id}} ">Edit</router-link>
    </div>
  </div>
</template>

<script>
import BookingBox from './BookingBox'
import axios from 'axios'

export default {
  name: 'App',
  components: {BookingBox},
  data () {
    return {
      price: 0,
      date: null,
      customer: null,
    }
  },
  props: ['id', 'name', 'description', 'address', 'category', 'bookings'],
  methods: {
    addBooking() {
      axios.post('http://localhost:8080/bookings/save/' + this.id, {
          date: this.date,
          price: this.price,
        },
        {headers: {'Content-type': 'application/json'}}).then(response => response.data).then(response => this.bookings.push(response))
    },

    deletePlace() {
      axios.delete('http://localhost:8080/places/delete/' + this.id,
        {headers: {'Content-type': 'application/json'}})
    },

  }
}
</script>

<style scoped>
  .place {
    border: 1px solid;
    display: inline-block;
    width: 60%;
    margin-bottom: 10px;
  }

  .name {
    font-size: 20px;
  }

  .placeButton {
    display: inline-block;
    outline: none;
    cursor: pointer;
    border: solid 1px #000000;
    background: #FFFFFF;
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

</style>
