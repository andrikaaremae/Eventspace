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
Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld,
      meta: {nonRequiresAuth: true}
    },
    {
      path: '/about',
      name: 'About',
      component: About,
      meta: {nonRequiresAuth: true}
    },
    {
      path: '/save',
      name: 'Save',
      component: Save
    },
    {
      path: '/categories',
      name: 'Categories',
      component: Categories,
      meta: {nonRequiresAuth: true}
    },
    {
      path: '/search',
      name: 'CategoryCitySearch',
      component: CategoryCitySearch,
      meta: {nonRequiresAuth: true}
    },
    {
      path: '/places',
      name: 'Places',
      component: Places,
      meta: {nonRequiresAuth: true}
    },
    {
      path: '/register',
      name: 'Register',
      component: RegistrationPage,
      meta: {nonRequiresAuth: true}
    },
    {
      path: '/login',
      name: 'Login',
      component: LoginPage,
      meta: {loginPage: true, nonRequiresAuth: true}
    }
  ]
})

router.beforeEach((to, from, next) => {
  const requiresAuth = !to.matched.some(record => record.meta.nonRequiresAuth)
  const isLoginPage = to.matched.some(record => record.meta.loginPage)
  const isAuthenticated = localStorage.getItem('auth')
  if (requiresAuth && !isAuthenticated) {
    next('/login')
  } else if (isLoginPage && isAuthenticated) {
    router.push('/')
  }
  next()
})

export default router
