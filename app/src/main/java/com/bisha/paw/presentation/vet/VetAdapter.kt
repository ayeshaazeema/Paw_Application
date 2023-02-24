package com.bisha.paw.presentation.vet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.data.model_ui.Food
import com.bisha.paw.data.model_ui.Vet
import com.bisha.paw.utils.setImageUrl
import com.bisha.paw.utils.toFormatRupiah

class VetAdapter(
    private val onClick: (Vet) -> Unit
): RecyclerView.Adapter<VetAdapter.MyViewHolder>() {

    private var vets = arrayListOf<Vet>()

    fun setList(data: ArrayList<Vet>) {
        this.vets.addAll(data)
        this.notifyDataSetChanged()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val vetName = view.findViewById<TextView>(R.id.tvVetName)
        val vetHospital = view.findViewById<TextView>(R.id.tvVetHospital)
        val vetLocation = view.findViewById<TextView>(R.id.tvVetLocation)
        val vetPrice = view.findViewById<TextView>(R.id.tvVetPrice)
        val vetImage = view.findViewById<ImageView>(R.id.ivVet)

        fun bind(model: Vet) {
            vetName.text = model.vetName
            vetHospital.text = model.vetClinic
            vetLocation.text = model.vetLocation
            vetPrice.text = model.vetPrice.toInt().toFormatRupiah()
            vetImage.setImageUrl(itemView.context, model.urlImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.vet_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(vets[position])
        holder.itemView.setOnClickListener {
            onClick(vets[position])
        }
    }

    override fun getItemCount(): Int = vets.size

}