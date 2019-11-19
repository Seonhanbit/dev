import { USER_REQUEST, USER_ERROR, USER_SUCCESS } from '../actions/user'
import apiCall2 from '../../utils/api2'
import Vue from 'vue'
import { AUTH_LOGOUT } from '../actions/auth'

const state = { status: '', profile: {} }

const getters = {
  getProfile: state => state.profile,
  isProfileLoaded: state => !!state.profile.name
}

const actions = {
  [USER_REQUEST]: ({commit, dispatch},args) => {
    apiCall2( args.usernameOrEmail)
      .then(resp => {
        commit(USER_SUCCESS, resp)
      })
      .catch(() => {
        commit(USER_ERROR) //commit 자기자신의 액션에서만 1개씩
        dispatch(AUTH_LOGOUT)
      })

  },
}

const mutations = {
  [USER_REQUEST]: (state) => {
    state.status = 'loading'
  },
  [USER_SUCCESS]: (state, resp) => {
    state.status = 'success'
    Vue.set(state, 'profile', resp)
  },
  [USER_ERROR]: (state) => {
    state.status = 'error'
  },
  [AUTH_LOGOUT]: (state) => {
    state.profile = {}
  }
}

export default {
  state,
  getters,
  actions,
  mutations,
}
