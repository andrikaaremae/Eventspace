<template>
  <div class="place">

      <img :src="imageURL" />

    <section>
      <div class="name" align="left"><h1>{{ name }}</h1></div>
      <section>
        <span class="address"  style="float:left">{{ address.country }}, {{ address.state}}, {{ address.city}}, {{ address.street}}, {{ address.houseNumber }}</span>
        <span style="float:right"><star-rating :show-rating="false" :star-size="20" :rating="this.ratingToShow" :read-only="true" :increment="1"></star-rating></span>
      </section>

      <section>
        <hr width="120%">
        <div class="description" align="left"><h3>About the Space</h3>{{ description }}</div>
        <div class="category" align="left"><h3>Available for </h3>{{ category }}</div>
        <div class="price" align="left"><h3>Price </h3>{{price}}€ one night</div>
        <div align="left">
        <form method="post" @submit.prevent="addRating"><h4>Rate your stay</h4>
          <star-rating star-size="20" onclick="submit" v-model="rating"></star-rating>
          <button class="placeButton">{{statusText}}</button>
        </form>
        </div>
      </section>
      <section>
        <div v-if="username==owner.username" align="right">
        <button v-on:click="deletePlace"  class="placeButton">Delete</button>
        <router-link  class="placeButton" :to="{ name: 'Edit', query: {id: id}} ">Edit</router-link>
        </div>
      </section>
    </section>
    <aside class="bookingBoxAside">
      <h1>Book your stay</h1>
      <hr>
      <section>
      <div class="bookingBox"><BookingBox v-for="booking in bookings" v-bind="booking" v-bind:key="booking.id">></BookingBox></div>
      <div class="addBookingForm">
        <form method="post" @submit.prevent="addBooking">
          <label>
            Start Date:
            <input type="date" v-model="startDate" required>
          </label>
          <br>
          <label>
            End Date:
            <input type="date" v-model="endDate" required>
          </label>
          <br>
          <button class="placeButton">Add booking</button>
        </form>
      </div>
      </section>
    </aside>
  </div>
</template>
<script>
import StarRating from 'vue-star-rating'
import BookingBox from '../BookingBox'
import axios from 'axios'
import authHeader from '../../services/auth-header'
import moment from 'moment'

export default {
  name: 'App',
  components: {
    BookingBox,
    StarRating},
  data () {
    return {
      owner: null,
      startDate: null,
      endDate: null,
      customer: null,
      rating: null,
      ratingToShow: null,
      place: '',
      ratingList: [0],
      statusText: 'Add rating',
      username: '',

    }
  },
  props: ['id', 'name', 'description', 'address', 'category', 'bookings', 'price', 'imageURL', 'owner', 'username'],
  mounted () {
    axios.get(process.env.API_URL + '/places/get/' + this.id).then(response => {
      this.place = response.data
      this.ratingList = this.place.ratingList
      console.log(this.ratingList)
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
    axios.get(process.env.API_URL + '/user/username').then(response =>
    { this.username = response.data, axios.get(process.env.API_URL + '/user/getUser/'+this.username)
      .then(response => { this.customer = response.data, console.log(this.customer.username)},);});
  },
  methods: {

    addBooking () {
      let startDate = moment(this.startDate, "YYYY-MM-DD");
      let endDate = moment(this.endDate, "YYYY-MM-DD");
      let duration = moment.duration(endDate.diff(startDate));
      let days = duration.asDays();
      let today = new Date();
      let dd = today.getDate();
      let mm = today.getMonth()+1;
      let yyyy = today.getFullYear();
      if(dd<10) {dd='0'+dd;}
      if(mm<10) {mm='0'+mm;}
      let now = yyyy+'-'+mm+'-'+dd;

      if (this.endDate < this.startDate ) {
        return alert('Start date can not be greater than end date!') }
      if (this.startDate < now  ) {
        return alert('Start date must be equal or greater than current date!') }
      else {
        axios.post(process.env.API_URL + '/bookings/save/' + this.id, {
            startDate: this.startDate,
            endDate: this.endDate,
            price: this.price * days,
            customer: this.customer
          },
          {headers: authHeader()}).then(response => response.data).then(response => this.bookings.push(response))
      }
    },
    addRating () {
      this.statusText = 'Voted!';
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
        owner:this.owner,
      },
      {headers: {'Content-type': 'application/json'}})
    },

    deletePlace () {
      axios.delete(process.env.API_URL + '/places/delete/' + this.id,
        {headers: authHeader()}).then(response => window.location = 'http://localhost:8081/#/places')
    }

  }
}
</script>

<style scoped>
  .place {
    border: none;
    display: inline-block;
    width: 70%;
    margin-top: 20px;
    margin-left: 80px;
    margin-right: 80px;
    margin-bottom: 80px;
  }
  img{
    height: 500px;
    width: 1100px;
  }

  .name {
    font-size: 20px;
    align:left;
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
    margin: 10px 0 10px 5px;
  }
  .placeButton:hover {
    background: whitesmoke;
  }

  section {
    float: left;
    margin: 0 1.5%;
    width: 63%;
  }
  aside {
    border: 1px solid;
    border-radius: 5px;
    float: right;
    margin: 0 1.5%;
    width: 30%;
    margin-top: 20px;
  }
  .status {
    float: right;
    color: lightgreen;
  }
  .addBookingForm {
    margin-top: 20px;
  }
  .bookingBoxAside {
    width: auto;
    align-content: center;
  }

</style>
