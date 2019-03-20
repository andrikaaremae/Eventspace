import authHeader from './auth-header.js'
import axios from 'axios'

export const userService = {
  login,
  logout,
  getAll
}

function login (username, password) {
  return axios.post(`http://localhost:8080/user/login`, {username: username, password: password})
    .then(handleResponse)
    .then(user => {
      if (user.token) {
        localStorage.setItem('user', JSON.stringify(user))
      }
      return user
    })
}

function logout () {
  localStorage.removeItem('user')
}

function getAll () {
  const requestOptions = {
    method: 'GET',
    headers: authHeader()
  }

  return axios(`http://localhost:8080/user/getAll`, requestOptions).then(handleResponse)
}

function handleResponse (response) {
  return response.text().then(text => {
    const data = text && JSON.parse(text)
    if (!response.ok) {
      if (response.status === 401) {
        logout()
        location.reload(true)
      }
      const error = (data && data.message) || response.statusText
      return Promise.reject(error)
    }
    return data
  })
}
