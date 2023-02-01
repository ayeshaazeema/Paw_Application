package com.bisha.paw.fragment.food

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*

class FoodFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var rvFoodFragment: FoodFragment
    private lateinit var adapter: FoodAdapter
    private lateinit var FoodArrayList: ArrayList<Food>
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomSheetDialog: BottomSheetDialog




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            binding= ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater): Boolean {
        // below line is to get our inflater
        val inflater = menuInflater

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.main_menu, menu)

        // below line is to get our menu item.
        val searchItem = menu.findItem(R.id.svFood)

        // getting search view of our item.
        val searchView = searchItem.actionView as SearchView

        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText)
                return false
            }
        })
        return true
    }

    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist = ArrayList<Food>()

        // running a for loop to compare elements.
        for (item in FoodArrayList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getFoodName().lowercase(Locale.ROOT)
                    .contains(text.lowercase(Locale.getDefault()))
            ) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist)
        }
    }

    private fun buildRecyclerView(recyclerView: RecyclerView) {

        // below line we are creating a new array list
        FoodArrayList = ArrayList<Food>()

        // below line is to add data to our array list.
        FoodArrayList.add(Food("Whiskas® Dry Adult 1+ Indoor", "Whiskas", 48000))
        FoodArrayList.add(Food("WHISKAS® Wet Food Pouch Junior 80gr", "Whiskas", 28000))
        FoodArrayList.add(Food("Royal Canin Kitten Dry 400gr", "Royal Canin", 158620))
        FoodArrayList.add(Food("Royal Canin Indoor Long Hair (2kg)", "Royal Canin",314500))
        FoodArrayList.add(Food("Korean Collagen 150gr Biotin Zinc Vitamin ", "PetGlow", 128325))

        // initializing our adapter class.
        adapter = FoodAdapter(this, FoodArrayList, this)

        // adding layout manager to our recycler view.
        val manager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        // setting layout manager
        // to our recycler view.
        recyclerView.layoutManager = manager

        // setting adapter to
        // our recycler view.
        recyclerView.adapter = adapter


    }

    override fun selectFood(food: Food) {

        binding.FoodName.text= food.getFoodName()
        bottomSheetDialog.dismiss()
        // bottomSheetDialog.cancel()

    }

}