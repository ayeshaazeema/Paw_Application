package com.bisha.paw.presentation.article

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bisha.paw.R
import com.bisha.paw.data.ArticleModel
import com.bisha.paw.data.Food
import com.bisha.paw.presentation.food.FoodDetailActivity
import com.bisha.paw.utils.toFormatRupiah

class ArticleDetailActivity : AppCompatActivity() {

    companion object {
        const val ARTICLE_ITEM = "article_item"

        fun start(context: Context, article: ArticleModel) {
            context.startActivity(Intent(context, ArticleDetailActivity::class.java).apply {
                putExtra(ARTICLE_ITEM, article)
            })
        }
    }

    private var article: ArticleModel? = null

    private fun initIntent() {
        article = intent.getParcelableExtra(ARTICLE_ITEM)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)
        supportActionBar?.hide()
        initIntent()

        article?.let {
            setDetailData(it)
        }
    }

    private fun setDetailData(model: ArticleModel) {
        val ivArticleDetail: ImageView = findViewById(R.id.ivArticleDetail)
        val tvArticleTitle: TextView = findViewById(R.id.detailArticleTitle)
        val tvArticleSub: TextView = findViewById(R.id.detailArticleSub)
        val tvArticleDesc: TextView = findViewById(R.id.DescContent)

        ivArticleDetail.setImageResource(model.articleImg)
        tvArticleTitle.text = model.articleTitle
        tvArticleSub.text = model.articleCategory
    }
}