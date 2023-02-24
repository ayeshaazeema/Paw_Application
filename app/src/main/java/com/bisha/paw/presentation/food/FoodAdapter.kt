package com.bisha.paw.presentation.food


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.data.model_ui.Food
import com.bisha.paw.utils.setImageUrl
import com.bisha.paw.utils.toFormatRupiah

class FoodAdapter(
    private val onClick: (Food) -> Unit
) : RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {

    private var foods = arrayListOf<Food>()

    fun setList(data: ArrayList<Food>) {
        this.foods.addAll(data)
        this.notifyDataSetChanged()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivFood = view.findViewById<ImageView>(R.id.ivFood)
        val tvFoodName = view.findViewById<TextView>(R.id.tvFoodName)
        val tvFoodBrand = view.findViewById<TextView>(R.id.tvFoodBrand)
        val tvFoodPrice = view.findViewById<TextView>(R.id.tvFoodPrice)

        fun bind(model: Food) {
            tvFoodName.text = model.foodName
            tvFoodBrand.text = model.foodBrand
            tvFoodPrice.text = model.foodPrice.toInt().toFormatRupiah()
            ivFood.setImageUrl(itemView.context, model.urlImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(foods[position])
        holder.itemView.setOnClickListener {
            onClick(foods[position])
        }
    }

    override fun getItemCount(): Int = foods.size

}
