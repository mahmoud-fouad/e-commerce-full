import { createRouter, createWebHistory } from 'vue-router'
import AddCategory from '../views/category/AddCategory.vue'
import CategoryList from '../views/category/CategoryList.vue'
import CategoryDetails from '../views/category/CategoryDetails.vue'


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
      
    },
    {
      path: '/categories',
      name: 'categories',
      component: CategoryList
      
    },
    {
      path: '/categories/:id',
      name: 'categories-details',
      component: CategoryList,
      children:[
        {
        path: 'details',
        name:'categories-details1',
        component: CategoryDetails,
      }]
      
    }
  ]
})

export default router
