<template>
  <div>
    <div class="hello">
      <h1>{{ msg }}</h1>
      <div class="searchboxes">
          <input id="eventInput" type="text" name="myEvent" placeholder="What are you planning?">
          <input id="countryInput" type="text" name="myCountry" placeholder="Where?">
      </div>
    </div>
    <div class="background">
      <h1 class="categoriesHeading">Event categories</h1>
      <div>
        <li>
          <router-link class="router" :to="{ name: 'Categories' }">
        <ul><img src="../assets/Birthday.jpg"/></ul>
        <ul><h2 class="categoriesHeading">Birthday Party</h2></ul>
          </router-link>
        </li>
      </div>
      <div>
        <li>
          <router-link class="router" to="/categories">
          <ul><img src="../assets/Meeting.jpg"/></ul>
          <ul><h2 class="categoriesHeading">Meeting</h2></ul>
          </router-link>
        </li>
      </div>
      <div>
        <li>
          <router-link class="router" to="/categories">
          <ul><img src="../assets/Performance.jpg"/></ul>
          <ul><h2 class="categoriesHeading">Performance</h2></ul>
          </router-link>
        </li>
      </div>
      <div>
        <li>
          <router-link class="router" to="/categories">
          <ul><img src="../assets/Wedding.jpg"/></ul>
          <ul><h2 class="categoriesHeading">Wedding</h2></ul>
          </router-link>
        </li>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'App',
  data () {
    return {
      msg: null
    }
  },
  mounted () {
    axios.get('http://localhost:8080/api/hello').then(response => (this.msg = response.data))
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
    padding-left: 27px;
  }
  input {
    height: 40px;
    background-color: whitesmoke;
    width: 400px;
    border-radius: 5px;
    font-size: large;
    padding: 5px 0 5px 20px;
  }
  img {
    height: 200px;
    width: 250px;
    border-radius: 20px;
  }
  li {
    list-style: none;
    float: left;
    margin-right: 0;
  }
  ul {
    margin-left:45px;
    margin-right: 0;
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
</style>
