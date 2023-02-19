package com.bisha.paw.presentation.dashboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.data.ArticleModel
import com.bisha.paw.data.Food
import com.bisha.paw.presentation.article.ArticleAdapter
import com.bisha.paw.presentation.food.FoodAdapter
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
        val cvDonate = view.findViewById<CardView>(R.id.cvDonate)

        tvShowAllArticles.setOnClickListener {
            Log.d("CLICK", "ArticleClickEvent")
            RxEventBus.post(ArticleClickEvent())
        }

        tvShowAllFoods.setOnClickListener {
            Log.d("CLICK", "FoodClickEvent")
            RxEventBus.post(FoodClickEvent())
        }

        cvDonate.setOnClickListener {
            Toast.makeText(requireContext(), "DONATED", Toast.LENGTH_SHORT).show()
        }

        rvArticleDashboard.apply {
            setHasFixedSize(true)
            adapter = ArticleAdapter(ArticleModel.getArticles()) { _ -> }
            layoutManager = LinearLayoutManager(activity).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
        }

        rvFoodDashboard.apply {
            setHasFixedSize(true)
            adapter = FoodAdapter(Food.getFoods()) { _ -> }
            layoutManager = LinearLayoutManager(activity).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
        }

        return view
    }
}