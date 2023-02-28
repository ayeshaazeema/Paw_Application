package com.bisha.paw.presentation.article

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.data.model_ui.Article
import com.bisha.paw.data.model_ui.Vet
import com.bisha.paw.utils.setImageUrl
import com.bumptech.glide.Glide

class ArticleAdapter(
    private val onClick: (Article) -> Unit
) : RecyclerView.Adapter<ArticleAdapter.MyViewHolder>(), Filterable {

    private var articles = arrayListOf<Article>()

    fun setList(data: ArrayList<Article>) {
        this.articles.clear()
        this.articles.addAll(data)
        this.notifyDataSetChanged()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val articleTitle = view.findViewById<TextView>(R.id.tvNameArticleItem)
        val articleCategory = view.findViewById<TextView>(R.id.tvCategoryArticleItem)
        val articleImage = view.findViewById<ImageView>(R.id.ivArticleItem)

        fun bind(model: Article) {
            articleTitle.text = model.articleName
            articleCategory.text = model.articleCategory
            articleImage.setImageUrl(itemView.context, model.imageUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(articles[position])
        holder.itemView.setOnClickListener {
            onClick(articles[position])
        }
    }

    override fun getItemCount(): Int = articles.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredArticles = articles.searchable(constraint.toString())
                Log.d("FILTERED", filteredArticles.toString())
                return FilterResults().apply {
                    values = filteredArticles
                }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                articles = results?.values as ArrayList<Article>
                notifyDataSetChanged()
            }

        }
    }

}