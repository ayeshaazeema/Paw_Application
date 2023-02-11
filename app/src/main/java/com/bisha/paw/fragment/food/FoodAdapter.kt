package com.bisha.paw.fragment.food


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R

class FoodAdapter(
    private val foods: ArrayList<Food>
): RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {

    fun setList(data: ArrayList<Food>) {
        this.foods.addAll(data)
        this.notifyDataSetChanged()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // TODO: Call the Views
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = foods.size

}
