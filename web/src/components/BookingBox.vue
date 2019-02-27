<template>
<div class="booking">
  <span class="date"><b>Date:</b> {{ date }}</span>
  <span class="price"><b>Price:</b> {{ price }}€</span>
  <span class="canBeBooked" v-if="customer == null">Can be booked.</span>
  <span class="alreadyBooked" v-if="customer != null">Booked by {{ customer.username }}</span>
  <form v-if="customer == null" @submit.prevent="book">
    <input type="text" placeholder="Username" v-model="username">
    <button type="submit">Book</button>
  </form>
</div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'BookingBox',
  props: ['id', 'date', 'price', 'customer'],
  methods: {
    book () {
      axios.patch('http://localhost:8080/bookings/setCustomer/' + this.id, {username: this.username})
    }
  }
}
</script>

<style scoped>
  .booking {
    border: 1px solid;
}
  .canBeBooked {
    color: green;
  }

  .alreadyBooked {
    color: red;
  }
</style>
