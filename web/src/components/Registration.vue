<template>
    <div class="registrationBox">
    <form id="registrationForm" @submit.prevent="register">
      <label>
        First name
        <input type="text" name="firstName" v-model="firstName" required>
      </label>
      <label>
        Last name
        <input type="text" name="lastName" v-model="lastName" required>
      </label>
      <label>
        Username
        <input type="text" name="username" v-model="username" required>
      </label>
      <label>
        Password
        <input type="password" name="password" v-model="password" required>
      </label>
      <label>
        Email
        <input type="email" name="email" v-model="email" required>
      </label>
      <label>
        Phone number
        <input type="tel" name="phoneNumber" v-model="phoneNumber" required>
      </label>
      <button type="submit" class="registerbtn">Register</button>
    </form>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Registration',
  data () {
    return {
      firstName: '',
      lastName: '',
      username: '',
      password: '',
      email: '',
      phoneNumber: ''
    }
  },
  methods: {
    register () {
      axios.post('http://localhost:8080/user/register', {
        firstName: this.firstName,
        lastName: this.lastName,
        username: this.username,
        password: this.password,
        email: this.email,
        phoneNumber: this.phoneNumber
      })
    }
  }
}
</script>

<style scoped>
  .registrationBox {
    display: block;
    text-align: center;
  }
  #registrationForm {
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
    /*display: inline-block;*/
    border: none;
    background: #f1f1f1;
  }
  input:focus {
    background-color: #ddd;
    outline: none;
  }
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
</style>
