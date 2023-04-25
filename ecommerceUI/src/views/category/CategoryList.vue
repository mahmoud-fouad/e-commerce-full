<script setup>
import axios from 'axios';
import router from '../../router';
import CategoryDetails  from './CategoryDetails.vue'

</script>

<template>
     <main>  
        <h1>Categories</h1>
        <div class="container">
            <div v-if="$route.params.id">
<CategoryDetails/>
            </div>
            <div v-else>
    <div v-for=" cat in categories" :key="cat">

        <div><span><b>name </b>: <a :href=" viewLink(cat.id)" >{{ cat.name }}</a></span> <span><b> Description</b> {{ cat.desc }}</span></div>
    </div>
    <button  @click="gotToAdd">add</button>
</div>
</div>
    </main>
</template>

<script>
export default {
    name:'categoryList',
    data(){
    return {
        categories:[
  {
    "desc": null,
    "id": 0,
    "imageUrl": null,
    "name": null
  }
]
    }
  
},
methods :{
    gotToAdd(){
        router.push('/addCategory');
    },
    viewLink(id){
        return "/categories/"+id;
    }
},
beforeMount() {
     console.log('before')   
    },
    afterMount(){
        console.log('before')   
    },
    beforeCreate() {
        if(!this.$route.params.id){
        axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
    const baseURL =  this.$store.state.apiBaseUrl+"categories";

 axios.get(baseURL).then(response=>{
    this.categories =response.data;

 });
}
    },
}
</script>
