<template>
  <div>
    <div class="hello">
      <h1>Find your perfect event space</h1>
      <form>
        <div class="searchboxes">
          <select id="categoryInput" ref="categoryInput" @change="getCities()">
            <option value="">Choose event category</option>
            <option  v-for="category in categories" :value="category" :key="category">{{ category }}</option>
          </select>
          <select id="cityInput" ref="cityInput">
            <option value="">Choose city</option>
            <option v-for="city in cities" :value="city" :key="city">{{ city }}</option>
          </select>
          <router-link class="searchBtn" :to="{ name: 'CategoryCitySearch', query: {category: category, city: city}}">
            <div v-on:click="getFormValues">Search</div>
          </router-link>
        </div>
      </form>
    </div>
    <div class="background">
      <h1 class="categoriesHeading">Event categories</h1>
      <div>
        <section>
          <router-link class="router" :to="{ name: 'Categories', query: {category: 'Birthday Party'}}">
        <ul><img src="../assets/Birthday.jpg"/></ul>
        <ul><h2 class="categoriesHeading">Birthday Party</h2></ul>
          </router-link>
        </section>
      </div>
      <div>
        <section>
          <router-link class="router" :to="{ name: 'Categories', query: {category: 'Meeting'}}">
          <ul><img src="../assets/Meeting.jpg"/></ul>
          <ul><h2 class="categoriesHeading">Meeting</h2></ul>
          </router-link>
        </section>
      </div>
      <div>
        <section>
          <router-link class="router" :to="{ name: 'Categories', query: {category: 'Performance'}}">
          <ul><img src="../assets/Performance.jpg"/></ul>
          <ul><h2 class="categoriesHeading">Performance</h2></ul>
          </router-link>
        </section>
      </div>
      <div>
        <section>
          <router-link class="router" :to="{ name: 'Categories', query: {category: 'Wedding'}}">
          <ul><img src="../assets/Wedding.jpg"/></ul>
          <ul><h2 class="categoriesHeading">Wedding</h2></ul>
          </router-link>
        </section>
      </div>
    </div>
  </div>
</template>

<script>
import json from '@/assets/Categories'
import axios from 'axios'

export default {
  name: 'App',
  data () {
    return {
      categories: json,
      places: [],
      cities: [],
      category: '',
      city: ''
    }
  },
  methods: {
    getFormValues () {
      console.log(this.$refs.categoryInput.value, this.$refs.cityInput.value)
      this.category = this.$refs.categoryInput.value
      this.city = this.$refs.cityInput.value
    },
    getCities () {
      axios.get(`${process.env.API_URL}/places/getCitiesByCategory/${this.$refs.categoryInput.value}`).then(response => { this.cities = response.data })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1 {
    font-weight: bolder;
    font-size: 38px;
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
    color: white;
    margin: 0;
    padding-top: 150px;
  }
  h1.categoriesHeading {
    color: black;
    padding-top: 75px;
    padding-bottom: 70px;
    text-decoration: none;
  }
  h2 {
    font-weight: bolder;
    font-size: 38px;
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
    color: black;
    text-align: center;
  }
  select {
    height: 40px;
    background-color: whitesmoke;
    width: 400px;
    border-radius: 5px;
    font-size: large;
    padding: 5px 0 5px 20px;
  }
  img {
    height: 200px;
    width: 75%;
    border-radius: 20px;
    margin-left: 45px;
  }
  li {
    list-style: none;
    float: left;
    margin-right: 0;
  }
  ul {
    background-color: white;
  }
  .searchboxes {
    padding-top: 30px;
  }
  .hello {
    height: 500px;
    background-image: url("../assets/background.jpg");
    background-size: cover;
    background-size: 100%;
    background-position: center;
  }
  .router {
    text-decoration: none;
  }
  .router:hover {
    background-color: white;
  }

  .searchBtn {
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
    border-radius: .3em;
  }
  .searchBtn:hover {
    background: lightgrey;
  }
  section {
    float: left;
    width: 25%;
  }
</style>
