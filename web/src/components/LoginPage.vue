<template>
    <div class="modal">
      <form id="loginForm" @submit.prevent="login">
        <label>
          Username
          <input type="text" name="username">
        </label>
        <label>
          Password
          <input type="password" name="password">
        </label>
        <button :disabled='errors.any()' type="submit" class="loginButton">Login</button>
      </form>
    </div>
</template>

<script>
export default {
  name: 'LoginModal',
  data () {
    return {
      username: '',
      password: ''
    }
  }
}
</script>

<style scoped>
  #loginForm {
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
  .loginButton {
    background-color: #4CAF50;
    color: white;
    padding: 16px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
  }
  .loginButton:disabled {
    background-color: gray;
    cursor: not-allowed;
  }
  .loginButton:hover {
    opacity: 1;
  }
  .error {
    font-weight: normal;
    color: #D8000C;
    background-color: #FFD2D2;
  }
</style>
