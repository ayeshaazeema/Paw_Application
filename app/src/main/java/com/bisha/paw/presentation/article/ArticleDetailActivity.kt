package com.bisha.paw.presentation.article

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bisha.paw.R
import com.bisha.paw.data.model_ui.Article
import com.bisha.paw.utils.setImageUrl

class ArticleDetailActivity : AppCompatActivity() {

    companion object {
        const val ARTICLE_ITEM = "article_item"

        fun start(context: Context, article: Article) {
            context.startActivity(Intent(context, ArticleDetailActivity::class.java).apply {
                putExtra(ARTICLE_ITEM, article)
            })
        }
    }

    private var article: Article? = null

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

    private fun setDetailData(model: Article) {
        val ivArticleDetail: ImageView = findViewById(R.id.ivArticleDetail)
        val tvArticleTitle: TextView = findViewById(R.id.detailArticleTitle)
        val tvArticleSub: TextView = findViewById(R.id.detailArticleSub)
        val tvArticleDesc: TextView = findViewById(R.id.DescContent)

        ivArticleDetail.setImageUrl(this, model.imageUrl)
        tvArticleTitle.text = model.articleName
        tvArticleSub.text = model.articleCategory
        tvArticleDesc.text = model.articleDescription
    }
}