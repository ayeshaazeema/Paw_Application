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

class VetAdapter(var data: ArrayList<VetModel>, var context: Activity?) :
    RecyclerView.Adapter<VetAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val vetName = view.findViewById<TextView>(R.id.tvVetName)
        val vetHospital = view.findViewById<TextView>(R.id.tvVetHospital)
        val vetLocation = view.findViewById<TextView>(R.id.tvVetLocation)
        val vetPrice = view.findViewById<TextView>(R.id.tvVetPrice)
        val vetImage = view.findViewById<ImageView>(R.id.ivVet)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.vet_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.vetName.text = data[position].vetName
        holder.vetHospital.text = data[position].vetHospital
        holder.vetLocation.text = data[position].vetLocation
        holder.vetPrice.text = data[position].vetPrice
        holder.vetImage.setImageResource(data[position].vetImg)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}