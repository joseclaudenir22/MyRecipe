package com.example.myrecipe.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myrecipe.model.entities.MyRecipe

@Database(entities = [MyRecipe::class], version = 1)
abstract class MyRecipeDatabase : RoomDatabase() {

    abstract fun myRecipeDao(): MyRecipeDao

    companion object {
        @Volatile
        private var INSTANCE: MyRecipeDatabase? = null

        fun getDatabase(context: Context): MyRecipeDatabase {
            //if the INSTANCE is not null, then return it,
            //if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyRecipeDatabase::class.java,
                    "my_recipe_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                //return instance
                instance
            }
        }
    }
}