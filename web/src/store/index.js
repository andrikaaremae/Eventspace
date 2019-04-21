import Vue from 'vue'
import Vuex from 'vuex'

import { alert } from './modules/alert'
import { authentication } from './modules/authentication'

Vue.use(Vuex);
Vue.use(require('vue-moment'));

export default new Vuex.Store({
  modules: {
    alert,
    authentication
  }
})
