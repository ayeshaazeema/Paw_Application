package com.bisha.paw.fragment.article

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import android.widget.SearchView
import com.bisha.paw.R
import com.bisha.paw.databinding.FragmentArticleBinding

class ArticleFragment : Fragment() {

    private var binding: FragmentArticleBinding? = null
    lateinit var rvArticle: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article, container, false)

        // RecyclerView
        rvArticle = view.findViewById(R.id.rvArticle)

        val articleAdapter = ArticleAdapter(ArticleModel.getArticles(), activity)

        rvArticle.apply {
            this.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            this.adapter = articleAdapter
            this.setHasFixedSize(true)
        }

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
