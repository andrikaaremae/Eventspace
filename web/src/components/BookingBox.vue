<template>
<div class="booking">
  <span class="date"><b>Date:</b> {{ startDate }} - {{ endDate }}</span><br>
  <span class="price"><b>Price:</b> {{ price }}€</span>
  <span class="price"><b>Booked by:</b> {{ customer.username }}</span>
</div>
</template>

<script>
import axios from 'axios'


export default {
  name: 'BookingBox',
  data () {
    return {}
  },
  props: ['id', 'startDate','endDate', 'price','customer'],

}
</script>

<style scoped>
  .booking {
    border: 1px solid;
    border-radius: 5px;
    width: 100%;

}
  .canBeBooked {
    color: green;
  }

  .alreadyBooked {
    color: red;
  }


</style>
