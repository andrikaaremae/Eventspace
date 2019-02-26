<template>
  <div class="save">
    <body>
    <form method="post" class="" @submit.prevent="postNow">
      <div class="container">
        <h1>Earn money as a Eventspace host</h1>
        <p>Join thousands of hosts renting their space for meetings, events, and film and photo shoots.</p>
        <hr>
        <div>
          <h1>Place</h1>
          <div><b>Place Name</b></div>
          <input type="text" placeholder="Enter Name" v-model="name" required>
          <div><b>Description</b></div>
          <input type="text" placeholder="Enter Description" v-model="description" required>
          <div><b>Country</b></div>
          <input type="text" placeholder="Enter Country" v-model="country" required>
          <div><b>State</b></div>
          <input type="text" placeholder="Enter State" v-model="state" required>
          <div><b>City</b></div>
          <input type="text" placeholder="Enter City" v-model="city" required>
          <div><b>Street</b></div>
          <input type="text" placeholder="Enter Street" v-model="street" required>
          <div><b>House number</b></div>
          <input type="text" placeholder="Enter House number" v-model="houseNumber" required>
          <div><b>Zip Code</b></div>
          <input type="text" placeholder="Enter Zip Code" v-model="zipCode" required>

          </div>
          <hr>
          <p>By adding an Eventspace you agree to our <a href="#">Terms & Privacy</a>.</p>
        <button type="submit" class="savebtn">Add Address</button>
      </div>
    </form>
    </body>
  </div>
</template>

<script>
  import axios from 'axios'
  export default {
    name: 'App',
    data() {
      return {
        name: '',
        show: true,
      };
    },
    methods: {
      postNow() {
        axios.post('http://localhost:8080/places/add',
          {name: this.name,
          description: this.description,
          address:{country: this.country,
            state: this.state,
            city: this.city,
            street: this.street,
          houseNumber: this.houseNumber,
            zipCode: this.zipCode}},  // the data to post
          { headers: {
              'Content-type': 'application/json',
            }
          })
      }
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
