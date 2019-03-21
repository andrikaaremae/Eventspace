<template>
  <div class="save">
    <form method="post" class="" @submit.prevent="postNow">
      <div class="container">
        <h1>Earn money as a Eventspace host</h1>
        <p>Join thousands of hosts renting their space for meetings, events, and film and photo shoots.</p>
        <hr>
        <div>
          <h1>Rent your place</h1>
          <div><b>Place Name</b></div>
          <input placeholder="Enter Name" type="text" v-model="name" required>
          <div><b>Category</b></div>
          <select v-model="category">
            <option  v-for="category in categories" :value="category" :key="category.text">{{category.text}}</option>
          </select>
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
        <button type="submit" class="registerbtn">Add Address</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from 'axios'
import authHeader from '../services/auth-header.js'

export default {
  name: 'App',
  data () {
    return {
      categories: [
        {value: 1, text: 'Birthday Party'},
        {value: 2, text: 'Meeting'},
        {value: 2, text: 'Performance'},
        {value: 2, text: 'Wedding'}
      ],
      place: '',
      category: '',
      name: '',
      description: '',
      country: '',
      state: '',
      city: '',
      street: '',
      houseNumber: '',
      zipCode: '',
      show: true
    }
  },
  methods: {
    postNow () {
      console.log(authHeader())
      axios.post('http://localhost:8080/places/edit',
        { name: this.name,
          category: this.category.text,
          description: this.description,
          address: {country: this.country,
            state: this.state,
            city: this.city,
            street: this.street,
            houseNumber: this.houseNumber,
            zipCode: this.zipCode}},
        { headers: authHeader()
        }).then(response => window.location = 'http://localhost:8081/#/places')
    }
  },
  mounted () {

  }
}
</script>
<style scoped>
  body {
    font-family: Arial, Helvetica, sans-serif;
    background-color: black;
  }
  h1, p, button {
    text-align: left;
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
  select, input[type=text], input[type=number]{
    width: 50%;
    padding: 15px;
    margin: 0 0 22px 0;
    /*display: inline-block;*/
    border: none;
    background: #f1f1f1;
  }

  select, input[type=text]:focus, input[type=password]:focus {
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
    width: 125px;
  }

  .registerbtn:hover {
    opacity: 1;
  }

  /* Add a blue text color to links */
  a {
    color: dodgerblue;
  }

</style>
