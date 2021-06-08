package com.example.myrecipe.application

import android.app.Application
import com.example.myrecipe.model.database.MyRecipeDatabase
import com.example.myrecipe.model.database.MyRecipeRepository

class MyRecipeApplication : Application() {
    private val database by lazy { MyRecipeDatabase.getDatabase((this@MyRecipeApplication))}

    val repository by lazy { MyRecipeRepository(database.myRecipeDao())}
}