<script setup>
import axios from 'axios'
import router from '../../router';

</script>

<template>
    <div class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h4 class="pt-3">Add new Category</h4>
        </div>
      </div>
 
      <div class="row">
        <div class="col-3"></div>
        <div class="col-md-6 px-5 px-md-0">
         <form>
           <div class="form-group">
             <label>Category Name</label>
             <input type="text" class="form-control" v-model="catName" required>
           </div>
           <div class="form-group">
             <label>Description</label>
             <input type="text" class="form-control" v-model="catDesc" required>
           </div>
           <div class="form-group">
             <label>ImageURL</label>
             <input type="url" class="form-control" v-model="catImageUrl" required>
           </div>
           <button type="button" class="btn btn-primary" @click="addCategory">Submit</button>
         </form>
        </div>
        <div class="col-3"></div>
      </div>
   </div>
 </template>

<script>
export default {
    name:'AddCategory',
    data(){
    return {
      catName : null,
      catDesc : null,
      catImageUrl : null,
    }
  
},
methods :{
addCategory(){
    const newCategory = {
        name : this.catName,
        desc : this.catDesc,
        imageUrl : this.catImageUrl,
      };

    axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
    const baseURL =  this.$store.state.apiBaseUrl+"categories";
    const customConfig = {
  headers: {
  'Content-Type': 'application/json'
  }
};
    console.log(baseURL);
    console.log(JSON.stringify(newCategory))
    axios.put(baseURL,JSON.stringify(newCategory),customConfig)
    
    .then(() => {router.push('/categories');}) .catch(err => console.log(err));
      
}
}
}
</script>
<style scoped>

</style>