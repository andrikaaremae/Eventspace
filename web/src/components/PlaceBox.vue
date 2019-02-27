<template>
  <div class="place">
    <div id="photo"><img src="../assets/house.jpg" alt="Photo" height="160px" width="240px"></div>
    <div id="name"><strong>{{ name }}</strong></div>
    <div id="address">{{ address.country }}, {{ address.state}}, {{ address.city}}, {{ address.street}}, {{ address.houseNumber }}, {{ address.zipCode }}</div>
    <div id="category">{{ category }}</div>
    <div id="description">{{ description }}</div>
  </div>
</template>

<script>

export default {
  name: 'App',
  props: ['name','category', 'description', 'address']
}
</script>

<style scoped>
  .place {
    border: 1px solid;
    display: inline-block;
    width: 60%;
    margin-bottom: 10px;
  }

  #name {
    font-size: 20px;
  }
</style>
