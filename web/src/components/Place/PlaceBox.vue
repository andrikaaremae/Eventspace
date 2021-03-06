<template>
  <html>
  <head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  </head>
  <body>
  <div class="place">
    <img :src="imageURL" />
    <section class="infoSection">
      <section>
        <div class="name" align="left"><h1>{{ name }}</h1></div>
      </section>
      <aside>
        <span class="rating"><star-rating :show-rating="false" :star-size="20" :rating="this.ratingToShow" :read-only="true" :increment="1"></star-rating></span>
      </aside>
      <section>
        <div class="address" style="float:left">
          <i class="material-icons" style="float:left">place</i>
          {{ address.country }},
          {{ address.state}},
          {{ address.city}} ,
          {{ address.street}},
          {{ address.houseNumber }}
        </div>
      </section>
      <section class="infoSection">
        <hr class="hr">
        <div class="description" align="left"><h3>About the Space</h3>{{ description }}</div>
        <div class="category" align="left"><h3>Available for </h3>{{ category }}</div>
        <div class="price" align="left"><h3>Price </h3>{{price}}€ one night</div>
        <div align="left">
          <form method="post" @submit.prevent="addRating"><h4>Rate your stay</h4>
            <star-rating star-size="20" v-model="rating"></star-rating>
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
        <hr class="hr">
        <div>
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
            <button class="placeButton" style="float:left">Add booking</button>
          </form>
        </div>
      </section>
    </aside>
  </div>
  </body>
  </html>
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
        startDateTest:'',
        endDateTest:'',
        dateListTest:[],
        userRatings: [],
      }
    },
    props: ['id', 'name', 'description', 'address', 'category', 'bookings', 'price', 'imageURL', 'owner', 'username', 'bookingList'],
    mounted () {

      axios.get(process.env.API_URL + '/ratings/getAll').then(response => {
        this.ratingList = response.data
        if (this.ratingList && this.ratingList.length) {
          let total = 0
          for (let i = 0; i < this.ratingList.length; i++) {
            total += this.ratingList[i].rating
          }
          let avg = total / this.ratingList.length
          this.ratingToShow = avg.toFixed(0)
        } else {
          this.ratingToShow = 0
        }})

      axios.get(process.env.API_URL + '/user/username').then(response =>
      { this.username = response.data,
        axios.get(process.env.API_URL + '/user/getUser/'+this.username)
          .then(response => { this.customer = response.data,
            axios.get(process.env.API_URL + '/ratings/getAll/' + this.username, { headers: authHeader() })
              .then(response => { this.userRatings = response.data, console.log(this.userRatings)});},);});

      axios.get(process.env.API_URL + '/bookings/getAll/' + this.$route.query.id , { headers: authHeader() })
        .then(response => { this.bookingList = response.data });

    },
    methods: {

      addBooking () {

        // Calculating date duration as Days
        let startDate = moment(this.startDate, "YYYY-MM-DD");
        let endDate = moment(this.endDate, "YYYY-MM-DD");
        let duration = moment.duration(endDate.diff(startDate));
        let days = duration.asDays() + 1;
        console.log(days)

        // Get current date
        let bookedDays;
        if (days == 0) {
          bookedDays = 1;
        }else {
          bookedDays = days;
        }
        let today = new Date();
        let dd = today.getDate();
        let mm = today.getMonth()+1;
        let yyyy = today.getFullYear();
        if(dd<10) {dd='0'+dd;}
        if(mm<10) {mm='0'+mm;}
        let now = yyyy+'-'+mm+'-'+dd;


        // Get date array from input values
        let getDateArray = function(startDate, endDate) {
          let array = new Array();
          let date = new Date(startDate);
          while (date <= endDate) {
            array.push(new Date(date));
            date.setDate(date.getDate() + 1);
          }
          return array;
        };
        let dateArray = getDateArray(startDate, endDate);
        console.log(dateArray);


        // Get date array from db end- and startDate
        let i;
        for(i=0; i< this.bookingList.length; i++){
          this.startDateTest =  this.bookingList[i].startDate;
          this.endDateTest =  this.bookingList[i].endDate;

          let startDateTest = moment(this.startDateTest, "YYYY-MM-DD");
          let endDateTest = moment(this.endDateTest, "YYYY-MM-DD");
          this.dateListTest = this.dateListTest.concat(getDateArray(startDateTest,endDateTest));

        }


        if (this.endDate < this.startDate ) {
          return alert('Start date can not be greater than end date!') }
        if (this.startDate < now  ) {
          return alert('Start date must be equal or greater than current date!') }
        else {
          axios.post(process.env.API_URL + '/bookings/save/' + this.id, {
              startDate: this.startDate,
              endDate: this.endDate,
              price: this.price * bookedDays,
              customer: this.customer
            },
            {headers: authHeader()}).then(response => response.data).then(response => this.bookings.push(response)).then(response =>location.reload())
        }

      },
      addRating() {
        this.statusText = 'Voted!';
        axios.post(process.env.API_URL + '/ratings/save/' + this.id, {
            rating: this.rating,
            user: this.customer,
          },
          {headers: {'Content-type': 'application/json'}})
      },

      deletePlace () {
        axios.delete(process.env.API_URL + '/places/delete/' + this.id,
          {headers: authHeader()}).then(response => window.location = '/#/places')
      }

    }
  }
</script>

<style scoped>
  .place {
    border: none;
    display: inline-block;
    width: 70%;
    margin: 20px 80px 80px 80px;
  }
  img{
    height: 500px;
    width: 1100px;
  }
  .hr{
    width: 150%
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
    margin-top: 30px;
  }
  .bookingBoxAside {
    width: 400px;
    border: 1px solid;
    border-radius: 5px;
    float: right;
    /*margin: 0 1.5%;*/
    margin-top: 30px;
  }
  .infoSection {
    width: 55%;
  }
  .rating {
    float: left;
    margin-top: 10px;
  }
  .address{
    margin-bottom: 10px;
  }
  label{
    display: inline-block;
    float: left;
    clear: left;
    width: 250px;
    text-align: right;
  }
  input {
    display: inline-block;

  }
</style>
