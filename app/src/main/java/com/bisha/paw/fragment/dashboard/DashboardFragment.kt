package com.bisha.paw.fragment.dashboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.fragment.food.Food
import com.bisha.paw.fragment.food.FoodAdapter
import com.bisha.paw.fragment.vet.VetAdapter
import com.bisha.paw.utils.ArticleClickEvent
import com.bisha.paw.utils.FoodClickEvent
import com.bisha.paw.utils.RxEventBus

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val rvArticleDashboard = view.findViewById<RecyclerView>(R.id.rvArticleDashboard)
        val rvFoodDashboard = view.findViewById<RecyclerView>(R.id.rvFoodDashboard)
        val tvShowAllArticles = view.findViewById<TextView>(R.id.tvShowAllArticlesDashboard)
        val tvShowAllFoods = view.findViewById<TextView>(R.id.tvShowAllFoodDashboard)

        tvShowAllArticles.setOnClickListener {
            Log.d("CLICK", "ArticleClickEvent")
            RxEventBus.post(ArticleClickEvent())
        }

        tvShowAllFoods.setOnClickListener {
            Log.d("CLICK", "FoodClickEvent")
            RxEventBus.post(FoodClickEvent())
        }

        rvArticleDashboard.apply {
            setHasFixedSize(true)
            adapter = FoodAdapter(Food.getFoods())
            layoutManager = LinearLayoutManager(activity).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
        }

        rvFoodDashboard.apply {
            setHasFixedSize(true)
            adapter = FoodAdapter(Food.getFoods())
            layoutManager = LinearLayoutManager(activity).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
        }

        return view
    }
}