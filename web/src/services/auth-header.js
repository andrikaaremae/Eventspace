export default function authHeader () {
  let token = localStorage.getItem('user')
  let user = token.replace(/"/g, '') // it has quote marks for some reason
  if (user) {
    return { 'Authorization': 'Bearer ' + user }
  } else {
    return {}
  }
}
