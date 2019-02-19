<template>
  <div id="app">
      <ul>
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
  #app {
    font-family: 'Avenir', Helvetica, Arial;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 0;
}

  .router {
    color: whitesmoke;
    font-family: arial;
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

  .router {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
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
