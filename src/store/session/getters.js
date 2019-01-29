/*
export function someGetter (state) {
}
*/

export const isAuthenticated = (state) => {
  return state.user
}

export const token = (state) => {
  return state.user.token
}
