<template>
<div class="booking">
  <span class="date"><b>Date:</b> {{ date }}</span>
  <span class="price"><b>Price:</b> {{ price }}€</span>
  <span class="canBeBooked" v-if="customer == null">Can be booked.</span>
  <span class="alreadyBooked" v-if="customer != null">Booked by {{ customer }}</span>
</div>
</template>

<script>
export default {
  name: 'BookingBox',
  props: ['id', 'date', 'price', 'customer']
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
