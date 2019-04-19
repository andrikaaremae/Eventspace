import Vue from 'vue'
import Router from 'vue-router'
import HomePage from '@/components/HomePage'
import About from '@/components/About'
import Save from '@/components/Changes/Save'
import Categories from '@/components/Categories/Categories'
import AllPlaces from '@/components/Place/AllPlaces'
import CategoryCitySearch from '@/components/Categories/CategoryCitySearch'
import RegistrationPage from '@/components/Authentication/RegistrationPage'
import LoginPage from '../components/Authentication/LoginPage'
import Edit from '../components/Changes/Edit'
import PlaceDetails from '../components/Place/PlaceDetails'
import PlaceBoxes from '../components/Place/PlaceBoxes'
Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/',
      name: 'HomePage',
      component: HomePage
    },
    {
      path: '/about',
      name: 'About',
      component: About
    },
    {
      path: '/save',
      name: 'Save',
      component: Save
    },
    {
      path: '/categories',
      name: 'Categories',
      component: Categories
    },
    {
      path: '/search',
      name: 'CategoryCitySearch',
      component: CategoryCitySearch
    },
    {
      path: '/places',
      name: 'AllPlaces',
      component: AllPlaces
    },
    {
      path: '/register',
      name: 'Register',
      component: RegistrationPage
    },
    {
      path: '/login',
      name: 'Login',
      component: LoginPage
    },
    {
      path: '/edit',
      name: 'Edit',
      component: Edit
    },
    {
      path: '/place',
      name: 'PlaceDetails',
      component: PlaceDetails
    },
    {
      path: '/placeBoxes',
      name: 'PlaceBoxes',
      component: PlaceBoxes
    }
  ]
})

router.beforeEach((to, from, next) => {
  const publicPages = ['/login', '/register', '/', '/about']
  const authRequired = !publicPages.includes(to.path)
  const loggedIn = localStorage.getItem('user')

  if (authRequired && !loggedIn) {
    return next('/login')
  }

  next()
})

export default router
