package com.bisha.paw.presentation.food


import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.data.model_ui.Category
import com.bisha.paw.data.model_ui.Food
import com.bisha.paw.presentation.category.CategoryAdapter
import com.bisha.paw.presentation.main.PawLoadingDialog
import com.bisha.paw.presentation.viewmodel.MainViewModel
import com.bisha.paw.utils.observeLiveData
import com.bisha.paw.utils.onSearchQueryChanged

class FoodFragment : Fragment() {

    private var foods = arrayListOf<Food>()
    private var selectedCategory = ""

    private val viewModel: MainViewModel by viewModels()

    private val foodAdapter: FoodAdapter by lazy {
        FoodAdapter {
            FoodDetailActivity.start(requireContext(), it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_food, container, false)
        val rvFoodItem = view.findViewById<RecyclerView>(R.id.rvFood)
        val rvCategory = view.findViewById<RecyclerView>(R.id.rvCategory)
        val searchView = view.findViewById<SearchView>(R.id.svFood)

        CategoryAdapter.setupCategoryList(requireContext(), rvCategory) {
            selectedCategory = it.name
            viewModel.getFoods()
        }

        rvFoodItem.apply {
            this.setHasFixedSize(true)
            this.layoutManager = GridLayoutManager(requireContext(), 2)
            this.adapter = foodAdapter
        }

        viewModel.getFoods()
        initObservers()
        initSearchable(searchView)

        return view
    }

    private fun initObservers() {
        viewModel.foodsResult.observeLiveData(
            owner = viewLifecycleOwner,
            context = requireContext(),
            onSuccess = {
                PawLoadingDialog.hideLoading(childFragmentManager)

                if (it.isNotEmpty() && selectedCategory != Category.ALL.name) {
                    foodAdapter.filter.filter(selectedCategory)
                }

                loadFoods(it)
            },
            onLoading = {
                PawLoadingDialog.showLoading(childFragmentManager)
            },
            onFailure = {
                PawLoadingDialog.hideLoading(childFragmentManager)
            }
        )
    }

    private fun initSearchable(searchView: SearchView) {
        searchView.queryHint = getString(R.string.search_food)
        searchView.onSearchQueryChanged {
            if (it.isNotEmpty()) {
                foodAdapter.filter.filter(it)
            } else {
                viewModel.getFoods()
            }
        }
    }

    private fun loadFoods(data: List<Food>) {
        foods.clear()
        foods.addAll(data)
        foodAdapter.setList(foods)
    }
}

fun List<Food>.searchable(query: String): List<Food> {
    val searchQuery = query.lowercase()
    val originalList = this
    return this.filter {
        it.foodName.lowercase().contains(searchQuery) ||
                it.foodBrand.lowercase().contains(searchQuery) ||
                it.foodDescription.lowercase().contains(searchQuery) ||
                it.foodComposition.lowercase().contains(searchQuery)
    }.ifEmpty { originalList }
}




