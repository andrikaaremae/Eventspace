<template>
<div class="booking">
  <span class="date"><b>Date:</b> {{ date }}</span>
  <span class="price"><b>Price:</b> {{ price }}€</span>
  <span class="canBeBooked" v-if="customer == null">Can be booked.</span>
  <span class="alreadyBooked" v-if="localCustomer != null">Booked by {{ this.localCustomer.username }}</span>
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
  data () {
    return {
      username: '',
      localCustomer: this.customer
    }
  },
  props: ['id', 'date', 'price', 'customer'],
  methods: {
    book () {
      this.localCustomer = {username: this.username}
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
