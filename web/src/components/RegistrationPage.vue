<template>
    <div class="registrationBox">
    <form id="registrationForm" @submit.prevent="register">
      <label>
        First name
        <span class="error">{{ errors.first('firstName') }}</span>
        <input v-validate="'required|alpha'" data-vv-as="first name" type="text" name="firstName" v-model="firstName">
      </label>
      <label>
        Last name
        <span class="error">{{ errors.first('lastName') }}</span>
        <input v-validate="'required|alpha'" data-vv-as="last name" type="text" name="lastName" v-model="lastName">
      </label>
      <label>
        Username
        <span class="error">{{ errors.first('username') }}</span>
        <input v-validate="'required|alpha_dash|min:4|max:18'" type="text" name="username" v-model="username">
      </label>
      <label>
        Password
        <span class="error">{{ errors.first('password') }}</span>
        <input v-validate="'required|min:6'" type="password" name="password" v-model="password">
      </label>
      <label>
        Email
        <span class="error">{{ errors.first('email') }}</span>
        <input v-validate="'required|email'" type="email" name="email" v-model="email">
      </label>
      <label>
        Phone number
        <span class="error">{{ errors.first('phoneNumber') }}</span>
        <input v-validate="'required|numeric'" data-vv-as="phone number" type="tel" name="phoneNumber" v-model="phoneNumber">
      </label>
      <button :disabled='isFormInvalid' type="submit" class="registerButton">Register</button>
    </form>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Registration',
  computed: {
    isFormInvalid () {
      return Object.keys(this.fields).some(key => this.fields[key].invalid)
    }
  },
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
      }).then(response => {
        alert('User successfully registered!')
        console.log(response)
        this.$router.push('/')
      }).catch(error => {
        alert('There has been a problem.')
        console.log(error)
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
    border: none;
    background: #f1f1f1;
  }
  input:focus {
    background-color: #ddd;
    outline: none;
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
