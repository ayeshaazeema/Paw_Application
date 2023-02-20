package com.bisha.paw.presentation.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.data.ArticleModel

class DashboardArticleAdapter(
    private val articles: ArrayList<ArticleModel>,
    private val onClick: (ArticleModel) -> Unit
): RecyclerView.Adapter<DashboardArticleAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val articleTitle = view.findViewById<TextView>(R.id.tvNameArticleItem)
        val articleCategory = view.findViewById<TextView>(R.id.tvCategoryArticleItem)
        val articleImage = view.findViewById<ImageView>(R.id.ivArticleItem)

        fun bind(model: ArticleModel) {
            articleTitle.text = model.articleTitle
            articleCategory.text = model.articleCategory
            articleImage.setImageResource(model.articleImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.dashboard_article_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(articles[position])
        holder.itemView.setOnClickListener {
            onClick(articles[position])
        }
    }

    override fun getItemCount(): Int = articles.size

}