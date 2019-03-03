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
        <button class="addBookingButton">Add booking</button>
      </form>
      <button v-on:click="deletePlace"  class="deleteButton">Delete</button>
    </div>
  </div>
</template>

<script>
import BookingBox from './BookingBox'
import axios from 'axios'

export default {
  name: 'App',
  components: {BookingBox},
  props: ['id', 'name', 'description', 'address', 'category', 'bookings'],
  methods: {
    addBooking() {
      axios.post('http://localhost:8080/bookings/save/' + this.id, {
          date: this.date,
          price: this.price
        },
        {headers: {'Content-type': 'application/json'}}).then(response => response.data).then(response => this.bookings.push(response))
    },

    deletePlace() {
      axios.delete('http://localhost:8080/places/delete/' + this.id,
        {headers: {'Content-type': 'application/json'}})

    }

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

</style>
