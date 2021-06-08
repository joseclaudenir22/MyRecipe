package com.example.myrecipe.viewmodel

import androidx.lifecycle.*
import com.example.myrecipe.model.database.MyRecipeRepository
import com.example.myrecipe.model.entities.MyRecipe
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MyRecipeViewModel(private val repository: MyRecipeRepository) : ViewModel() {

    fun insert(recipe : MyRecipe) = viewModelScope.launch {
        repository.insertMyRecipe(recipe)
    }

    val allRecipesList: LiveData<List<MyRecipe>> = repository.allRecipesList.asLiveData()
}

class MyRecipeViewModelFactory(private val repository: MyRecipeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MyRecipeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MyRecipeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}