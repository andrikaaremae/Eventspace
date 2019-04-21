<template>
  <div class="place">
    <div class="photo"><img :src="imageURL"></div>
    <div class="name"><h1>{{ name }}</h1></div>
    <div class="category"> <h4>{{ category }}</h4></div>
    <div class="price"> <h4>Price: {{price}}€</h4></div>
    <div class="address"> <h4>{{ address.country }}, {{ address.state}}, {{ address.city}}</h4></div>
    <router-link class="placeButton" :to="{ name: 'PlaceDetails', query: {id: id}} ">Details</router-link>
  </div>
</template>

<script>
import BookingBox from '../BookingBox'
import axios from 'axios'
import authHeader from '../../services/auth-header'

export default {
  name: 'App',
  components: {BookingBox},
  data () {
    return {
      owner: null,
      date: null,
      customer: null,
      rating: null,
      ratingToShow: null,
      ratingList: [],
      place: '',
      imageURL: '',
    }
  },
  props: ['id', 'name', 'description', 'address', 'category', 'bookings', 'price'],
  mounted () {
    axios.get(process.env.API_URL + '/places/get/' + this.id, { headers: authHeader() }).then(response => {
      this.place = response.data,
      this.ratingList = this.place.ratingList

      if (this.ratingList && this.ratingList.length) {
        let total = 0
        for (let i = 0; i < this.ratingList.length; i++) {
          total += this.ratingList[i]
        }
        let avg = total / this.ratingList.length

        this.ratingToShow = avg.toFixed(0)
      } else {
        this.ratingToShow = 0
      }
    })
  },
  methods: {
    addBooking () {
      axios.post(process.env.API_URL + '/bookings/save/' + this.id, {
        date: this.date,
      },
      {headers: authHeader()}).then(response => response.data).then(response => this.bookings.push(response))
    },
    addRating () {
      this.ratingList.push(this.rating),
      axios.post(process.env.API_URL + '/places/edit', {
        id: this.id,
        name: this.name,
        category: this.category,
        description: this.description,
        address: {country: this.address.country,
          state: this.address.state,
          city: this.address.city,
          street: this.address.street,
          houseNumber: this.address.houseNumber,
          zipCode: this.address.zipCode},
        ratingList: this.ratingList,
        price: this.price,
        imageURL: this.imageURL,
      },
      {headers: authHeader()}).then(response => window.location.reload())
    },

    deletePlace () {
      axios.delete(process.env.API_URL + '/places/delete/' + this.id,
        {headers: authHeader()}).then(response => window.location.reload())
    }

  }
}
</script>

<style scoped>
  .place {
    border: 1px solid;
    display: inline-block;
    width: 60%;
    margin: 10px 0 10px 0;
    border-radius: 10px;
    background-image: url('../../assets/AsfaltBackground.png');

  }

  .name {
    font-size: 20px;
  }

  .placeButton {
    display: inline-block;
    outline: none;
    cursor: pointer;
    border: solid 1px #000000;
    background: lightgray;
    text-align: center;
    color: black;
    text-decoration: none;
    font: 14px/100% Arial, Helvetica, sans-serif;
    padding: .5em 2em .55em;
    text-shadow: 0 1px 1px rgba(0,0,0,.3);
    -webkit-border-radius: .5em;
    -moz-border-radius: .5em;
    border-radius: .3em;
    -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.2);
    -moz-box-shadow: 0 1px 2px rgba(0,0,0,.2);
    box-shadow: 0 1px 2px rgba(0,0,0,.2);
    margin: 10px 0 10px 275px;
  }
  .placeButton:hover {
    background: whitesmoke;
  }
  router-link {
    background-color: darkred;
  }
  h1{
    color: black;
  }
  img {
    border-radius: 20px;
    margin: 40px 0 0 50px;
    height: 175px;
    width: 250px;
  }

</style>
