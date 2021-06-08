package com.example.myrecipe.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myrecipe.databinding.ItemRecipeLayoutBinding
import com.example.myrecipe.model.entities.MyRecipe

class MyRecipeAdapter(private val fragment: Fragment): RecyclerView.Adapter<MyRecipeAdapter.ViewHolder>() {

    private var recipes: List<MyRecipe> = listOf()

    class ViewHolder(view: ItemRecipeLayoutBinding): RecyclerView.ViewHolder(view.root) {
        //Holds the textView that will add each item to
        val ivRecipeImage = view.ivRecipeImage
        val tvTitle = view.tvRecipeTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemRecipeLayoutBinding = ItemRecipeLayoutBinding.inflate(
                LayoutInflater.from(fragment.context), parent, false)
            return ViewHolder(binding)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipes[position]
        Glide.with(fragment)
                .load(recipe.image)
                .into(holder.ivRecipeImage)
        holder.tvTitle.text = recipe.title

    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    fun recipesList(list: List<MyRecipe>) {
        recipes = list
        notifyDataSetChanged()
    }
}