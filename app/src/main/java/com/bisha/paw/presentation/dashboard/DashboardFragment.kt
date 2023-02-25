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
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.data.model_ui.Article
import com.bisha.paw.data.model_ui.Food
import com.bisha.paw.presentation.main.PawLoadingDialog
import com.bisha.paw.presentation.article.ArticleDetailActivity
import com.bisha.paw.presentation.food.FoodAdapter
import com.bisha.paw.presentation.food.FoodDetailActivity
import com.bisha.paw.presentation.viewmodel.MainViewModel
import com.bisha.paw.utils.ArticleClickEvent
import com.bisha.paw.utils.FoodClickEvent
import com.bisha.paw.utils.RxEventBus
import com.bisha.paw.utils.observeLiveData
import org.greenrobot.eventbus.EventBus

class DashboardFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private val articleAdapter: DashboardArticleAdapter by lazy {
        DashboardArticleAdapter {
            ArticleDetailActivity.start(requireContext(), it)
        }
    }

    private val foodAdapter: FoodAdapter by lazy {
        FoodAdapter {
            FoodDetailActivity.start(requireContext(), it)
        }
    }

    private var articles = arrayListOf<Article>()
    private var foods = arrayListOf<Food>()

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
            EventBus.getDefault().post(ArticleClickEvent())
        }

        tvShowAllFoods.setOnClickListener {
            EventBus.getDefault().post(FoodClickEvent())
        }

        cvDonate.setOnClickListener {
            Toast.makeText(requireContext(), "DONATED", Toast.LENGTH_SHORT).show()
        }

        rvArticleDashboard.apply {
            setHasFixedSize(true)
            adapter = articleAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }

        rvFoodDashboard.apply {
            setHasFixedSize(true)
            adapter = foodAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }

        initProcess()
        initObservers()

        return view
    }

    private fun initProcess() {
        viewModel.getArticles()
        viewModel.getFoods()
    }

    private fun initObservers() {
        viewModel.articlesResult.observeLiveData(
            owner = viewLifecycleOwner,
            context = requireContext(),
            onSuccess = {
                PawLoadingDialog.hideLoading(childFragmentManager)

                articles.addAll(it)
                articleAdapter.setList(articles)
            },
            onLoading = {
                PawLoadingDialog.showLoading(childFragmentManager)
            },
            onFailure = {
                PawLoadingDialog.hideLoading(childFragmentManager)
            }
        )

        viewModel.foodsResult.observeLiveData(
            owner = viewLifecycleOwner,
            context = requireContext(),
            onSuccess = {
                PawLoadingDialog.hideLoading(childFragmentManager)

                foods.addAll(it)
                foodAdapter.setList(foods)
            },
            onLoading = {
                PawLoadingDialog.showLoading(childFragmentManager)
            },
            onFailure = {
                PawLoadingDialog.hideLoading(childFragmentManager)
            }
        )
    }
}