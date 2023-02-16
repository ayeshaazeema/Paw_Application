//package com.bisha.paw.presentation.dashboard
//
//import android.view.View
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.bisha.paw.R
//import com.bisha.paw.data.ArticleModel
//import com.bisha.paw.presentation.article.ArticleAdapter
//
//class DashboardAdapter(
//
//    private val dashboardArticles: ArrayList<ArticleModel>,
//    private val onClick: (ArticleModel) -> Unit
//
//) : RecyclerView.Adapter<ArticleAdapter.MyViewHolder>() {
//
//    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val articleTitleDashboard = view.findViewById<TextView>(R.id.tvNameArticleDashboardItem)
//        val articleCategoryDashboard = view.findViewById<TextView>(R.id.tvCategoryArticleDashboardItem)
//        val articleImageDashboard = view.findViewById<ImageView>(R.id.ivArticleDashboardItem)
//    }
//
//}
