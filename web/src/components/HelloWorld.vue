<template>
  <div>
    <div class="hello">
      <h1>{{ msg }}</h1>
      <form>
        <div class="searchboxes">
          <input ref="categoryInput" type="text" placeholder="What are you planning?">
          <input ref="cityInput" type="text" placeholder="Where?">
          <router-link class="router" :to="{ name: 'CategoryCitySearch', query: {category: category, city:city}}">
            <div v-on:click="getFormValues"> Peksa lahti</div>
          </router-link>
        </div>
      </form>
    </div>
    <div class="background">
      <h1 class="categoriesHeading">Event categories</h1>
      <div>
        <li>
          <router-link class="router" :to="{ name: 'Categories', query: {category: 'Birthday Party'}}">
        <ul><img src="../assets/Birthday.jpg"/></ul>
        <ul><h2 class="categoriesHeading">Birthday Party</h2></ul>
          </router-link>
        </li>
      </div>
      <div>
        <li>
          <router-link class="router" :to="{ name: 'Categories', query: {category: 'Meeting'}}">
          <ul><img src="../assets/Meeting.jpg"/></ul>
          <ul><h2 class="categoriesHeading">Meeting</h2></ul>
          </router-link>
        </li>
      </div>
      <div>
        <li>
          <router-link class="router" :to="{ name: 'Categories', query: {category: 'Performance'}}">
          <ul><img src="../assets/Performance.jpg"/></ul>
          <ul><h2 class="categoriesHeading">Performance</h2></ul>
          </router-link>
        </li>
      </div>
      <div>
        <li>
          <router-link class="router" :to="{ name: 'Categories', query: {category: 'Wedding'}}">
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
      msg: null,
      category: '',
      location: '',
    }
  },
  methods: {
    getFormValues () {
      console.log(this.$refs.categoryInput.value, this.$refs.cityInput.value);
      this.category = this.$refs.categoryInput.value;
      this.city = this.$refs.cityInput.value;
    }
  },
  mounted () {
    axios.get('http://localhost:8080/api/hello').then(response => (this.msg = response.data));
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
