package com.bisha.paw.presentation.food


import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.data.model_ui.Food
import com.bisha.paw.presentation.category.CategoryAdapter
import com.bisha.paw.presentation.viewmodel.MainViewModel
import com.bisha.paw.utils.observeLiveData
import com.bisha.paw.utils.showToast

class FoodFragment : Fragment() {
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var foods: ArrayList<Food>

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_food, container, false)
        val rvFoodItem = view.findViewById<RecyclerView>(R.id.rvFoodItem)
        val rvCategory = view.findViewById<RecyclerView>(R.id.rvCategory)

        CategoryAdapter.setupCategoryList(requireContext(), rvCategory) {
            Log.d("kokok", "SELECTED CATEGORY $it")
        }

        foodAdapter = FoodAdapter {
            FoodDetailActivity.start(requireContext(), it)
        }

        rvFoodItem.apply {
            this.setHasFixedSize(true)
            this.layoutManager = GridLayoutManager(requireContext(), 2)
            this.adapter = foodAdapter
        }

        initProcess()
        initObservers()

        return view
    }

    private fun initProcess() {
        viewModel.getFoods()
    }

    private fun initObservers() {
        viewModel.foodsResult.observeLiveData(
            owner = viewLifecycleOwner,
            context = requireContext(),
            onSuccess = {
                foods.addAll(it)
                foodAdapter.setList(foods)
            }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)

        val searchItem = menu.findItem(R.id.svFood)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filter(newText)
                return false
            }
        })
    }

    private fun filter(text: String) {
        val filteredFoods = ArrayList<Food>()
        filteredFoods.addAll(foods.filter { it.foodName.lowercase().contains(text.lowercase()) })

        if (filteredFoods.isEmpty()) {
            Toast.makeText(requireContext(), "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            foodAdapter.setList(filteredFoods)
        }
    }
}




