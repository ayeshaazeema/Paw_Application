package com.bisha.paw.presentation.article

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.SearchView
import androidx.fragment.app.viewModels
import com.bisha.paw.R
import com.bisha.paw.data.model_ui.Article
import com.bisha.paw.databinding.FragmentArticleBinding
import com.bisha.paw.presentation.category.CategoryAdapter
import com.bisha.paw.presentation.viewmodel.MainViewModel
import com.bisha.paw.utils.observeLiveData

class ArticleFragment : Fragment() {

    private var binding: FragmentArticleBinding? = null
    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var ivArticle: ImageView
    private var articles = arrayListOf<Article>()

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article, container, false)

        val rvArticle: RecyclerView = view.findViewById(R.id.rvArticle)
        val rvCategory: RecyclerView = view.findViewById(R.id.rvCategory)
        ivArticle = view.findViewById(R.id.ivArticle)

        articleAdapter = ArticleAdapter {
            ArticleDetailActivity.start(requireContext(), it)
        }

        val linearLayoutManager = object : LinearLayoutManager(requireContext()) {
            override fun canScrollVertically() = false
        }

        rvArticle.apply {
            this.layoutManager = linearLayoutManager
            this.adapter = articleAdapter
            this.setHasFixedSize(true)
        }

        CategoryAdapter.setupCategoryList(requireContext(), rvCategory) {
            Log.d("kokok", "SELECTED CATEGORY $it")
        }

        ivArticle.setImageResource(R.drawable.bird)
        initProcess()
        initObservers()

        return view
    }

    private fun initProcess() {
        viewModel.getArticles()
    }

    private fun initObservers() {
        viewModel.articlesResult.observeLiveData(
            owner = viewLifecycleOwner,
            context = requireContext(),
            onSuccess = {
                articles.addAll(it)
                articleAdapter.setList(articles)
            }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_menu, menu)

        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.svArticle).actionView as SearchView

        searchView.queryHint = getString(R.string.search_hint)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
