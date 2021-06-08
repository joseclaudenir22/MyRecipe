package com.example.myrecipe.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.GridLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myrecipe.R
import com.example.myrecipe.application.MyRecipeApplication
import com.example.myrecipe.databinding.ActivityMainBinding
import com.example.myrecipe.databinding.FragmentAllRecipesBinding
import com.example.myrecipe.view.activities.AddUpdateDishActivity
import com.example.myrecipe.view.adapters.MyRecipeAdapter
import com.example.myrecipe.viewmodel.HomeViewModel
import com.example.myrecipe.viewmodel.MyRecipeViewModel
import com.example.myrecipe.viewmodel.MyRecipeViewModelFactory

class AllRecipesFragment : Fragment() {

    private lateinit var mBinding: FragmentAllRecipesBinding

    private val mMyRecipeViewModel: MyRecipeViewModel by viewModels {
        MyRecipeViewModelFactory((requireActivity().application as MyRecipeApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAllRecipesBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.rvRecipesList.layoutManager = GridLayoutManager(requireActivity(), 2)
        val myRecipeAdapter = MyRecipeAdapter(this@AllRecipesFragment)

        mBinding.rvRecipesList.adapter = myRecipeAdapter

        mMyRecipeViewModel.allRecipesList.observe(viewLifecycleOwner) {
            recipes ->
                recipes.let {
                    for(item in it)

                }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_all_recipes, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_add_dish -> {
                startActivity(Intent(requireActivity(), AddUpdateDishActivity::class.java))
                return true
            }
        }

        return super.onOptionsItemSelected(item)

    }
}