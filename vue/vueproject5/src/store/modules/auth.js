
import { AUTH_REQUEST, AUTH_ERROR, AUTH_SUCCESS, AUTH_LOGOUT } from '../actions/auth'
import { USER_REQUEST } from '../actions/user'
import apiCall from '../../utils/api'

const state = { token: localStorage.getItem('user-token') || '', status: '', hasLoadedOnce: false }

const getters = {
  isAuthenticated: state => !!state.token,
  authStatus: state => state.status
}
//   {accessToken: "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0IiwiaWF0IjoxNTcwM…XYOy7KZva2LCwHnDixyQHAIX1E6K3EzmA9WSMNJklkIVthjyQ", tokenType: "Bearer"}
   
const actions = {
  [AUTH_REQUEST]: ({commit, dispatch}, user) => {
    return new Promise((resolve, reject) => {
      commit(AUTH_REQUEST)
      apiCall({url: 'auth', data: user, method: 'POST'})
      .then(resp => {
       // console.log("------------"+resp.accessToken)
        localStorage.setItem('user-token', resp.accessToken)
        if (resp.accessToken!=null || resp.accessToken !='') {
            alert("안녕하세요  "+user.usernameOrEmail);
        }
        commit(AUTH_SUCCESS,resp)
        dispatch(USER_REQUEST,user)
        resolve(resp)
      })
      .catch(err => {
        alert("로그인에 실패하였습니다.");
        commit(AUTH_ERROR, err)
        localStorage.removeItem('user-token')
        reject(err)
      })
    })
  },
  [AUTH_LOGOUT]: ({commit}) => {
    return new Promise((resolve) => {
      commit(AUTH_LOGOUT)
      localStorage.removeItem('user-token')
      resolve()
    })
  }
}

const mutations = {
  [AUTH_REQUEST]: (state) => {
    state.status = 'loading'
  },
  [AUTH_SUCCESS]: (state, resp) => {
    state.status = 'success'
    state.token = resp.accessToken
    state.hasLoadedOnce = true
  },
  [AUTH_ERROR]: (state) => {
    state.status = 'error'
    state.hasLoadedOnce = true
  },
  [AUTH_LOGOUT]: (state) => {
    state.token = ''
  }
}

export default {
  state,
  getters,
  actions,
  mutations,
}
