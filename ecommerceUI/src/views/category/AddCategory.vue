<script setup>
import axios from 'axios'

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

    const baseURL =  "http://localhost:8080/";
    axios.put(baseURL+"categories",JSON.stringify(newCategory))
    .then(() => {}) .catch(err => console.log(err));
      
}
}
}
</script>
<style scoped>

</style>