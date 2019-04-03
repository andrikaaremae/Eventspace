import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import About from '@/components/About'
import Save from '@/components/Save'
import Categories from '@/components/Categories'
import Places from '@/components/Places'
import CategoryCitySearch from '@/components/CategoryCitySearch'
import RegistrationPage from '@/components/RegistrationPage'
import LoginPage from '../components/LoginPage'
import Edit from '../components/Edit'
import PlaceBox from "../components/PlaceBox";
Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
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
      name: 'Places',
      component: Places
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
