<template>
  <div class="save">
    <body>
    <form action="/action_page.php">
      <div class="container">
        <h1>Earn money as a Eventspace host</h1>
        <p>Join thousands of hosts renting their space for meetings, events, and film and photo shoots.</p>
        <hr>
        <div>
          <h1>Address</h1>
          <div><b>Country</b></div>
          <input type="text" placeholder="Enter Country" name="Address" required>
          <br>
          <div><b>State</b></div>
          <input type="text" placeholder="Enter State" name="State" required>
          <br>
          <div><b>City</b></div>
          <input type="text" placeholder="Enter City" name="City" required>
          <br>
          <div><b>Street</b></div>
          <input type="text" placeholder="Enter Street" name="Street" required>
          <br>
          <div><b>House number</b></div>
          <input type="number" placeholder="Enter House number" name="HouseNumber" required>
          <br>
          <div><b>Zipcode</b></div>
          <input type="number" placeholder="Enter Zipcode" name="ZipCode" required>
        </div>
        <hr>
        <p>By adding an Eventspace you agree to our <a href="#">Terms & Privacy</a>.</p>
        <button type="button" class="savebtn">Add Address</button>
      </div>
    </form>
    </body>
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
    mounted () {axios.get('http://localhost:8080/api/save').then(response => (this.msg = response.data))
    }
  }
</script>
<style scoped>
  body {
    font-family: Arial, Helvetica, sans-serif;
    background-color: black;
  }
  h1, p, button {
    text-align: center;
  }
  * {
    box-sizing: border-box;
    text-align: left;
  }


  /*Add padding to containers */
  .container {
    padding: 16px;
    background-color: white;
  }

  /*Full-width input fields */
  input[type=text], input[type=number]{
    width: 50%;
    padding: 15px;
    margin: 0px 0 22px 0;
    /*display: inline-block;*/
    border: none;
    background: #f1f1f1;
  }

  input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
  }

  /* Overwrite default styles of hr */
  hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
  }

  /* Set a style for the submit button */
  .registerbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
  }

  .registerbtn:hover {
    opacity: 1;
  }

  /* Add a blue text color to links */
  a {
    color: dodgerblue;
  }

</style>
