import axios from 'axios'

export function login({commit,dispatch},user) {
  return axios.post('user/login', user).then(response => {
    const user = response.data.user
    commit('Login',user)
    return user
  })
}