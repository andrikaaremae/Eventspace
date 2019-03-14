import router from '@/router'
import axios from 'axios'

export const actions = {
  userLogin ({commit}, payload) {
    let data = {
      username: payload.username,
      password: payload.password
    }
    commit('setLoading', true)
    axios.post('http://localhost:8080/login', data)
      .then(res => {
        commit('setAuth', true)
        commit('setLoading', false)
        commit('setError', null)
        router.push('/')
      })
      .catch(error => {
        commit('setError', error.message)
        commit('setLoading', false)
      })
  },
  userSignOut ({commit}) {
    commit('clearAuth')
    router.push('/login')
  }
}
