package com.bisha.paw.fragment.article

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R

class ArticleAdapter(var data: ArrayList<ArticleModel>, var context: Activity?) :
    RecyclerView.Adapter<ArticleAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val articleTitle = view.findViewById<TextView>(R.id.tvNameArticleItem)
        val articleCategory = view.findViewById<TextView>(R.id.tvCategoryArticleItem)
        val articleImage = view.findViewById<ImageView>(R.id.ivArticleItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.articleTitle.text = data[position].articleTitle
        holder.articleCategory.text = data[position].articleCategory
        holder.articleImage.setImageResource(data[position].articleImg)
    }

    override fun getItemCount(): Int = data.size

}