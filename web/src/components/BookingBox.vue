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
    width: 341px;

}
  .canBeBooked {
    color: green;
  }

  .alreadyBooked {
    color: red;
  }

  .placeButton {
    display: inline-block;
    outline: none;
    cursor: pointer;
    border: solid 1px #000000;
    background: lightgrey;
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
</style>
