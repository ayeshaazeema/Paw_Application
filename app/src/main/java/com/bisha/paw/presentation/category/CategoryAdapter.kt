package com.bisha.paw.presentation.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.data.Category
import com.bisha.paw.data.Food
import com.bisha.paw.utils.getColorResource
import com.bisha.paw.utils.toFormatRupiah

class CategoryAdapter(
    private val categories: ArrayList<Category>,
    private val onClick: (Category) -> Unit
): RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    var selectedItemPos = -1
    var lastItemSelectedPos = -1

    companion object {
        fun setupCategoryList(context: Context, recyclerView: RecyclerView, onClick: (Category) -> Unit) {
            recyclerView.apply {
                setHasFixedSize(true)
                adapter = CategoryAdapter(Category.getAllCategories(), onClick)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }

    fun setList(data: List<Category>) {
        this.categories.addAll(data)
        this.notifyDataSetChanged()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCategory = view.findViewById<TextView>(R.id.tv_category)
        val cvCategory = view.findViewById<CardView>(R.id.cv_category)

        fun bind(model: Category) {
            tvCategory.text = model.value
        }

        fun updateOnClick(isSelected: Boolean) {
            val white = itemView.context.getColorResource(R.color.white)
            val black = itemView.context.getColorResource(R.color.black)
            val yellow = itemView.context.getColorResource(R.color.yellow)

            tvCategory.setTextColor(if (isSelected) white else black)
            cvCategory.setCardBackgroundColor(if (isSelected) yellow else white)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            selectedItemPos = position
            lastItemSelectedPos = if (lastItemSelectedPos == -1) selectedItemPos else {
                notifyItemChanged(lastItemSelectedPos)
                selectedItemPos
            }
            notifyItemChanged(selectedItemPos)
            onClick(categories[position])
        }

        holder.updateOnClick(position == selectedItemPos)
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size

}