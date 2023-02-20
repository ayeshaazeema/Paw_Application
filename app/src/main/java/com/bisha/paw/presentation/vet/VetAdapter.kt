package com.bisha.paw.presentation.vet

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.data.VetModel
import com.bisha.paw.utils.toFormatRupiah
import com.bumptech.glide.Glide

class VetAdapter(
    private val data: ArrayList<VetModel>,
    private val onClick: (VetModel) -> Unit
): RecyclerView.Adapter<VetAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val vetName = view.findViewById<TextView>(R.id.tvVetName)
        val vetHospital = view.findViewById<TextView>(R.id.tvVetHospital)
        val vetLocation = view.findViewById<TextView>(R.id.tvVetLocation)
        val vetPrice = view.findViewById<TextView>(R.id.tvVetPrice)
        val vetImage = view.findViewById<ImageView>(R.id.ivVet)

        fun bind(model: VetModel) {
            vetName.text = model.vetName
            vetHospital.text = model.vetHospital
            vetLocation.text = model.vetLocation
            vetPrice.text = model.vetPrice.toFormatRupiah()
            Glide.with(itemView).load(model.vetImg).into(vetImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.vet_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            onClick(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}