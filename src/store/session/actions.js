import axios from 'axios'

import setAxiosHeaders from './helpers'

export function init ({state}) {
  setAxiosHeaders(state)
}

export function register({commit, state} , user) {
  return axios.post('user/register', user)
    .then(response=> {
      commit('LOGIN', response.data.user)
      setAxiosHeaders(state)
    })
}

export function login({commit,dispatch,getters} , user) {
  if(getters.isAuthenticated) return dispatch('validate')

  return axios.post('user/login', user)
    .then(response => {
      const user = response.data.user
      commit('LOGIN', user)
      return user
    })
}

export function validate({commit, state}) {
  if(!state.user) return Promise.resolve(null)

}