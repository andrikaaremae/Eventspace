<template>
<section class="booking">
  <span class="date"><b>Date:</b> {{ startDate }} - {{ endDate }}</span><br>
  <span class="price"><b>Price:</b> {{ price }}€</span><br>
  <span class="price"><b>Booked by:</b> {{ customer.username }}</span><br>
  <button v-on:click="deleteBooking"  class="bookingButton">Delete</button>
</section>
</template>

<script>
import axios from 'axios'
import authHeader from '../services/auth-header'


export default {
  name: 'BookingBox',
  data () {
    return {
      loggedIn: '',
    }
  },
  props: ['id', 'startDate','endDate', 'price','customer'],
  mounted() {
    axios.get(process.env.API_URL + '/user/username').then(response => { this.loggedIn = response.data});
  },
  methods: {
    deleteBooking () {
      axios.delete(process.env.API_URL + '/bookings/delete/' + this.id,
        {headers: authHeader()}).then(response => window.location.reload())
    }
  }
}
</script>

<style scoped>
  .booking {
    border: 1px solid;
    border-radius: 5px;
    width: 100%;
}
  .bookingButton {
    display: inline-block;
    outline: none;
    cursor: pointer;
    border: solid 1px #000000;
    background: lightgray;
    text-align: center;
    color: black;
    text-decoration: none;
    font: 14px/100% Arial, Helvetica, sans-serif;
    padding: .3em 1em .55em;
    text-shadow: 0 1px 1px rgba(0,0,0,.3);
    -webkit-border-radius: .5em;
    -moz-border-radius: .5em;
    border-radius: .3em;
    -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.2);
    -moz-box-shadow: 0 1px 2px rgba(0,0,0,.2);
    box-shadow: 0 1px 2px rgba(0,0,0,.2);
    margin: 10px 20px 10px 5px;
    float: right;
  }
  .bookingButton:hover {
    background: whitesmoke;
  }



</style>
