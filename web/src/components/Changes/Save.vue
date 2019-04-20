<template>
  <div class="save">
    <form method="post" class="" @submit.prevent="postNow">
      <div class="container">
        <h1>Earn money as a Eventspace host!</h1>
        <p>Join thousands of hosts renting their space for meetings, events, and film and photo shoots.</p>
        <hr>
        <div>
          <h1>Rent your place</h1>
          <label>Place name
            <input placeholder="Enter name" type="text" v-model="name" required>
          </label>
          <label>Category
            <select v-model="category" required>
              <option v-for="category in categories" :key="category">{{ category }}</option>
            </select>
          </label>
          <label>Description
            <input type="text" placeholder="Enter description" v-model="description" required>
          </label>
          <label>Price
            <input type="number" placeholder="Enter price" v-model="price" required>
          </label>
          <label>Country
            <country-select v-model="country" :country="country" country-name placeholder="Select country" top-country="Afghanistan" required/>
          </label>
          <label>State
            <region-select v-model="region" :country="country" :region="region" country-name region-name placeholder="Select state" required/>
          </label>
          <label>City
            <input type="text" placeholder="Enter city" v-model="city" required>
          </label>
          <label>Street
            <input type="text" placeholder="Enter street" v-model="street" required>
          </label>
          <label>House number
            <input type="text" placeholder="Enter house number" v-model="houseNumber" required>
          </label>
          <label>Postal code
            <input type="text" placeholder="Enter zip code" v-model="zipCode" required>
          </label>
        </div>
        <hr>
        <p>By adding an Eventspace you agree to our <a href="#">Terms & Privacy</a>.</p>
        <button type="submit" class="registerButton">Add your event space</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from 'axios'
import authHeader from '../../services/auth-header.js'
import categoriesJson from '../../assets/Categories'

export default {
  name: 'App',
  data () {
    return {
      categories: categoriesJson,
      place: '',
      category: '',
      name: '',
      description: '',
      country: '',
      region: '',
      city: '',
      street: '',
      houseNumber: '',
      zipCode: '',
      show: true,
      ratingList: [],
      price: ''
    }
  },
  methods: {
    postNow () {
      axios.post(process.env.API_URL + '/places/edit',
        { name: this.name,
          category: this.category,
          description: this.description,
          address: {country: this.country,
            state: this.region,
            city: this.city,
            street: this.street,
            houseNumber: this.houseNumber,
            zipCode: this.zipCode},
          ratingList: this.ratingList,
          price: this.price},
        { headers: authHeader()
        }).then(response => window.location = '/#/places')
    }
  }
}
</script>
<style scoped>
  .save {
    display: block;
    text-align: center;
  }
  .container {
    width: 50%;
    display: inline-block;
    box-sizing: border-box;
    text-align: left;
  }
  label {
    font-weight: bold;
  }
  input {
    width: 100%;
    padding: 15px;
    margin: 0 0 22px 0;
    border: none;
    background: #f1f1f1;
  }
  input:focus {
    background-color: #ddd;
    outline: none;
  }
  select {
    width: 100%;
    padding: 15px;
    margin: 0 0 22px 0;
    border: none;
    background: #f1f1f1;
  }
  .registerButton {
    background-color: #4CAF50;
    color: white;
    padding: 16px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
  }
  .registerButton:disabled {
    background-color: gray;
    cursor: not-allowed;
  }
  .registerButton:hover {
    opacity: 1;
  }
  .error {
    font-weight: normal;
    color: #D8000C;
    background-color: #FFD2D2;
  }
</style>
