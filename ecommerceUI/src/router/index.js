import { createRouter, createWebHistory } from 'vue-router'
import AddCategory from '../views/category/AddCategory.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
     
    },
    {
      path: '/addCategory',
      name: 'AddCategory',
      component: AddCategory
      
    }
  ]
})

export default router
