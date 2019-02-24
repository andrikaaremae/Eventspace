<template>
  <div id="app">
      <ul>
        <img src="./assets/logo.png" height="50" width="160"/>
        <li class="home"><router-link class="router" to="/about">About</router-link></li>
        <li><router-link class="router" :to="{ name: 'HelloWorld' }">Home</router-link></li>
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
    font-family: 'Avenir', Helvetica, Arial;
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
    margin: 0px;
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

  .home {
    margin-right: 30px;
  }

  /* Change the link color to #111 (black) on hover */
  .router:hover {
    background-color: #111;
  }

</style>
