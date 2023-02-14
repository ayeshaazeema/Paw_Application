package com.bisha.paw.presentation.article

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.SearchView
import com.bisha.paw.R
import com.bisha.paw.data.ArticleModel
import com.bisha.paw.databinding.FragmentArticleBinding

class ArticleFragment : Fragment() {

    private var binding: FragmentArticleBinding? = null
    private lateinit var rvArticle: RecyclerView
    private lateinit var ivArticle: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article, container, false)

        rvArticle = view.findViewById(R.id.rvArticle)
        ivArticle = view.findViewById(R.id.ivArticle)

        val articleAdapter = ArticleAdapter(ArticleModel.getArticles()) {
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

        ivArticle.setImageResource(R.drawable.bird)

        return view
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
