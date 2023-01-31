package com.bisha.paw.fragment.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.databinding.ActivityMainBinding
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FoodFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FoodFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var rvFoodFragment: FoodFragment
    private lateinit var adapter: FoodAdapter
    private lateinit var FoodArrayList: ArrayList<Food>
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            binding= ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // below line is to get our inflater
        val inflater = menuInflater

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_menu, menu)

        // below line is to get our menu item.
        val searchItem = menu.findItem(R.id.actionSearch)

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
        FoodArrayList.add(Food("DSA", "DSA Self Paced Course"))
        FoodArrayList.add(Food("JAVA", "JAVA Self Paced Course"))
        FoodArrayList.add(Food("C++", "C++ Self Paced Course"))
        FoodArrayList.add(Food("Python", "Python Self Paced Course"))
        FoodArrayList.add(Food("Fork CPP", "Fork CPP Self Paced Course"))

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

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment FoodFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            FoodFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}