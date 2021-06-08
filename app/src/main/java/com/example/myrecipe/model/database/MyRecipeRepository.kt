package com.example.myrecipe.model.database

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import com.example.myrecipe.model.entities.MyRecipe

class MyRecipeRepository(private val myRecipeDao: MyRecipeDao) {

    @WorkerThread
    suspend fun insertMyRecipe(myRecipe: MyRecipe) {
        myRecipeDao.insertMyRecipeDetails(myRecipe)
    }

    val allRecipesList: Flow<List<MyRecipe>> = myRecipeDao.getAllRecipesList()


}