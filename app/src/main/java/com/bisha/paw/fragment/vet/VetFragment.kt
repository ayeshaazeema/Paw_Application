package com.bisha.paw.fragment.vet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.databinding.FragmentVetBinding


class VetFragment : Fragment() {

    private var binding: FragmentVetBinding? = null
    lateinit var rvVet: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vet, container, false)

        //<-- RecyclerView -->
        val lm = LinearLayoutManager(activity)
        lm.orientation = LinearLayoutManager.VERTICAL
        rvVet = view.findViewById(R.id.rvVet)

        val vetAdapter = VetAdapter(VetArray, activity)
        rvVet.setHasFixedSize(true)
        rvVet.layoutManager = lm
        rvVet.adapter = vetAdapter

        return view
    }

    val VetArray: ArrayList<VetModel>
        get() {

            val vetArray = ArrayList<VetModel>()

            //1
            val vet1 = VetModel()
            vet1.vetName = "Anggi Anggini"
            vet1.vetHospital = "North Animal Clinic"
            vet1.vetLocation = "North Jakarta, Indonesia"
            vet1.vetPrice = "Rp 200.000,00"
            vet1.vetImg = R.drawable.anggi_anggini

            //2
            val vet2 = VetModel()
            vet2.vetName = "Budi Budiman"
            vet2.vetHospital = "East Animal Clinic"
            vet2.vetLocation = "East Jakarta, Indonesia"
            vet2.vetPrice = "Rp 180.000,00"
            vet2.vetImg = R.drawable.budi_budiman

            //3
            val vet3 = VetModel()
            vet3.vetName = "Cantik Cantika"
            vet3.vetHospital = "West Animal Clinic"
            vet3.vetLocation = "West Jakarta, Indonesia"
            vet3.vetPrice = "Rp 150.000,00"
            vet3.vetImg = R.drawable.cantik_cantika

            //4
            val vet4 = VetModel()
            vet4.vetName = "Dani Daniel"
            vet4.vetHospital = "South Animal Clinic"
            vet4.vetLocation = "South Jakarta, Indonesia"
            vet4.vetPrice = "Rp 120.000,00"
            vet4.vetImg = R.drawable.dani_daniel

            vetArray.add(vet1)
            vetArray.add(vet2)
            vetArray.add(vet3)
            vetArray.add(vet4)

            return vetArray
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}