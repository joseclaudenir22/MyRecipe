package com.example.myrecipe.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myrecipe.model.entities.MyRecipe
import kotlinx.coroutines.flow.Flow

@Dao
interface MyRecipeDao {

    @Insert
    suspend fun insertMyRecipeDetails(myRecipe: MyRecipe)

    @Query("SELECT * FROM MY_RECIPE_TABLE ORDER BY ID")
    fun getAllRecipesList(): Flow<List<MyRecipe>>
}