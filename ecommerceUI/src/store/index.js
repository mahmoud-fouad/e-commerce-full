import { createStore } from 'vuex'

// Create a new store instance.
const store = createStore({
  state () {
    return {
      apiBaseUrl: 'http://127.0.0.1:8080/',
    }
  },
  getters:{
    
  },
  mutations: {
  }
})


export default store

