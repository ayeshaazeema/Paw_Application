package com.bisha.paw.presentation.article

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.data.model_ui.Article
import com.bisha.paw.data.model_ui.Category
import com.bisha.paw.databinding.FragmentArticleBinding
import com.bisha.paw.presentation.category.CategoryAdapter
import com.bisha.paw.presentation.main.PawLoadingDialog
import com.bisha.paw.presentation.viewmodel.MainViewModel
import com.bisha.paw.utils.observeLiveData
import com.bisha.paw.utils.onSearchQueryChanged

class ArticleFragment : Fragment() {

    private var articles = arrayListOf<Article>()
    private var selectedCategory = ""

    private val viewModel: MainViewModel by viewModels()

    private val articleAdapter: ArticleAdapter by lazy {
        ArticleAdapter {
            ArticleDetailActivity.start(requireContext(), it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article, container, false)

        val rvArticle: RecyclerView = view.findViewById(R.id.rvArticle)
        val rvCategory: RecyclerView = view.findViewById(R.id.rvCategory)
        val searchView: SearchView = view.findViewById(R.id.svArticle)
        val ivArticle: ImageView = view.findViewById(R.id.ivArticle)

        val linearLayoutManager = object : LinearLayoutManager(requireContext()) {
            override fun canScrollVertically() = false
        }

        rvArticle.apply {
            this.layoutManager = linearLayoutManager
            this.adapter = articleAdapter
            this.setHasFixedSize(true)
        }

        CategoryAdapter.setupCategoryList(requireContext(), rvCategory) {
            selectedCategory = it.name
            viewModel.getArticles()
        }

        ivArticle.setImageResource(R.drawable.bird)
        viewModel.getArticles()
        initObservers()
        initSearchable(searchView)

        return view
    }

    private fun initObservers() {
        viewModel.articlesResult.observeLiveData(
            owner = viewLifecycleOwner,
            context = requireContext(),
            onSuccess = {
                PawLoadingDialog.hideLoading(childFragmentManager)

                if (it.isNotEmpty() && selectedCategory != Category.ALL.name) {
                    articleAdapter.filter.filter(selectedCategory)
                }

                loadArticles(it)
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
        searchView.queryHint = getString(R.string.search_hint)
        searchView.onSearchQueryChanged {
            if (it.isNotEmpty()) {
                articleAdapter.filter.filter(it)
            } else {
                viewModel.getArticles()
            }
        }
    }

    private fun loadArticles(data: List<Article>) {
        articles.clear()
        articles.addAll(data)
        articleAdapter.setList(articles)
    }
}

fun List<Article>.searchable(query: String): List<Article> {
    val searchQuery = query.lowercase()
    val originalList = this
    return this.filter {
        it.articleName.lowercase().contains(searchQuery) ||
        it.articleCategory.lowercase().contains(searchQuery) ||
        it.articleDescription.lowercase().contains(searchQuery)
    }.ifEmpty { originalList }
}
