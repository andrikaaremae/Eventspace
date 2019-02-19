<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div class="searchboxes">
      <input id="eventInput" type="text" name="myEvent" placeholder="What are you planning?">
      <input id="countryInput" type="text" name="myCountry" placeholder="Where?">
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
h1, h2 {
  font-weight: bolder;
  font-size: 38px;
  font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
  color: white;
  margin: 0;
  padding-top: 150px;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

  input {
    height: 40px;
    background-color: whitesmoke;
    width: 400px;
    border-radius: 5px;
    padding: 5px 0 5px 20px;
    font-size: large;
  }

  .searchboxes {
    margin-top: 30px;
  }

  .hello {
    height: 500px;
    background-image: url("../assets/background.jpg");
    background-size: cover;
    background-size: 100%;
    background-position: center;
  }

</style>
