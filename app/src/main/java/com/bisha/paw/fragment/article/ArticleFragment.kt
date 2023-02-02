package com.bisha.paw.fragment.article

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import android.widget.SearchView
import com.bisha.paw.ArticleAdapter
import com.bisha.paw.ArticleModel
import com.bisha.paw.R
import com.bisha.paw.databinding.FragmentArticleBinding

class ArticleFragment : Fragment() {

    private var binding: FragmentArticleBinding? = null
    lateinit var vpSlider: ViewPager
    lateinit var rvArticle: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_article, container, false)

        //<-- RecyclerView Apparel -->
        val lm = LinearLayoutManager(activity)
        lm.orientation = LinearLayoutManager.VERTICAL
        rvArticle = view.findViewById(R.id.rvArticle)

        val articleAdapter = ArticleAdapter(ArticleArray, activity)
        rvArticle.setHasFixedSize(true)
        rvArticle.layoutManager = lm
        rvArticle.adapter = articleAdapter

        return view

    }

    val ArticleArray: ArrayList<ArticleModel>
        get() {

            val articleArray = ArrayList<ArticleModel>()

            //1
            val article1 = ArticleModel()
            article1.articleTitle = "How to Take Care of Bird"
            article1.articleCategory = "Bird"
            article1.articleImg = R.drawable.bird

            //2
            val article2 = ArticleModel()
            article2.articleTitle = "How to Take Care of Cat"
            article2.articleCategory = "Cat"
            article2.articleImg = R.drawable.cat

            //3
            val article3 = ArticleModel()
            article3.articleTitle = "How to Take Care of Dog"
            article3.articleCategory = "Dog"
            article3.articleImg = R.drawable.dog

            //4
            val article4 = ArticleModel()
            article4.articleTitle = "How to Take Care of Fish"
            article4.articleCategory = "Fish"
            article4.articleImg = R.drawable.fish

            articleArray.add(article1)
            articleArray.add(article2)
            articleArray.add(article3)
            articleArray.add(article4)

            return articleArray
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}