package com.bisha.paw.presentation.food


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.data.Food
import com.google.android.material.bottomsheet.BottomSheetDialog

class FoodFragment : Fragment() {
    private lateinit var rvFoodFragment: FoodFragment
    private lateinit var adapter: FoodAdapter
    private lateinit var foods: ArrayList<Food>
    private lateinit var bottomSheetDialog: BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_food, container, false)
        val rvFoodItem = view.findViewById<RecyclerView>(R.id.rvFoodItem)
        rvFoodItem.apply {
            this.setHasFixedSize(true)
            this.layoutManager = GridLayoutManager(requireContext(), 2)
            this.adapter = FoodAdapter(Food.getFoods())
        }

        return view
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
            adapter.setList(filteredFoods)
        }
    }
}




