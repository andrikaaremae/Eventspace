<template>
  <div id="app">
      <ul>
        <router-link class="imgclick" :to="{ name: 'HelloWorld' }"><img src="./assets/logo.png" height="50" width="160"/></router-link>
        <li><router-link class="router" :to="{ name: 'About' }">About</router-link></li>
        <li><router-link class="router" :to="{ name: 'Places' }">Places</router-link></li>
        <li><router-link class="router" :to="{ name: 'Save' }">Add Place</router-link></li>
        <li><router-link class="router" :to="{ name: 'Register' }">Register</router-link></li>
        <li><router-link class="router" :to="{ name: 'Login' }">Login</router-link></li>
      </ul>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>

<style>
  template {
    height: 100%;
  }

  body {
    margin:0;
  }

  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}

  .router {
    color: whitesmoke;
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
    align-content: center;
    font-size: large;
  }

  ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
  }

  li {
    float: right;
  }

  img {
    float: left;
    margin: 5px 0 0 30px;
  }

  .router {
    display: block;
    color: white;
    text-align: center;
    padding: 18px 16px;
    text-decoration: none;
  }

  /* Change the link color to #111 (black) on hover */
  .router:hover {
    background-color: #111;
  }

</style>
