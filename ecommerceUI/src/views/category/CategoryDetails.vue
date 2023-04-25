<script setup>
import axios from 'axios';
import router from '../../router';

</script>

<template>
    <main>  
       <h1>Categories</h1>
       <div class="container">
           
   <div><img :src="category.imageUrl" alt="alternatetext"></div>

       <div><span><b>{{ category.name }}</b></span></div>
       <div> <span><b> Description</b> {{ category.desc }}</span></div>
   
</div>
   </main>
</template>

<script>
export default {
    name:'CategoryDetails',
    data(){
    return {
        category:  {
    "desc": null,
    "imageUrl": null,
    "name": null
  }

    }
  
},
beforeCreate(){
    console.log(this.$route.params.id);
    axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
    const baseURL =  this.$store.state.apiBaseUrl+"categories/"+this.$route.params.id;
    

 axios.get(baseURL).then(response=>{
    this.category =response.data;

 });
}
}
</script>
