<template>
  <div class="save">
    <form method="post" class="" @submit.prevent="editNow">
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
            <option  v-for="category in categories">{{category}}</option>
          </select>
          <div><b>Description</b></div>
          <input type="text" placeholder="Enter Description" v-model="description" required>
          <div><b>Price</b></div>
          <input type="number" placeholder="Enter Price" v-model="price" required>
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
          <div><b>Image URL</b></div>
          <input type="text" placeholder="Enter image URL" v-model="imageURL" required>
        </div>
        <hr>
        <p>By adding an Eventspace you agree to our <a href="#">Terms & Privacy</a>.</p>
        <button type="submit" class="registerbtn">Edit</button>
      </div>
    </form>
  </div>
</template>

<script>
import authHeader from '../../services/auth-header'
import json from '../../assets/Categories'
import axios from 'axios'
export default {
  name: 'App',
  data () {
    return {
      categories: json,
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
      show: true,
      price: '',
      imageURL: ''
    }
  },
  props: ['ratingList', 'owner'],
  methods: {
    editNow () {
      axios.post(process.env.API_URL + '/places/edit',
        { id: this.$route.query.id,
          name: this.name,
          category: this.category,
          description: this.description,
          address: {country: this.country,
            state: this.state,
            city: this.city,
            street: this.street,
            houseNumber: this.houseNumber,
            zipCode: this.zipCode},
          ratingList: this.ratingList,
          price: this.price,
          imageURL: this.imageURL,
          owner: this.owner},
        { headers: authHeader()
        }).then(response => window.location = '/#/place?id=' + this.$route.query.id)
    }
  },
  mounted () {
    axios.get(process.env.API_URL + '/places/get/' + this.$route.query.id, { headers: authHeader() }).then(response => {
      this.place = response.data,
      this.name = this.place.name,
      this.category = this.place.category,
      this.description = this.place.description,
      this.country = this.place.address.country,
      this.state = this.place.address.state,
      this.city = this.place.address.city,
      this.street = this.place.address.street,
      this.houseNumber = this.place.address.houseNumber,
      this.zipCode = this.place.address.zipCode,
      this.ratingList = this.place.ratingList,
        this.price = this.place.price,
        this.imageURL = this.place.imageURL,
      this.owner = this.place.owner
    })
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
