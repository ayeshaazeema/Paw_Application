package com.bisha.paw.data

import android.os.Parcelable
import com.bisha.paw.R
import kotlinx.android.parcel.Parcelize

@Parcelize
class VetModel(
    var vetName: String? = null,
    var vetHospital: String? = null,
    var vetLocation: String? = null,
    var vetPrice: Int = 0,
    var vetImg: Int = 0
) : Parcelable {
    companion object {
        fun getVets(): ArrayList<VetModel> {
            //1
            val vet1 = VetModel()
            vet1.vetName = "Anggi Anggini"
            vet1.vetHospital = "North Animal Clinic"
            vet1.vetLocation = "North Jakarta, Indonesia"
            vet1.vetPrice = 200000
            vet1.vetImg = R.drawable.anggi_anggini

            //2
            val vet2 = VetModel()
            vet2.vetName = "Budi Budiman"
            vet2.vetHospital = "East Animal Clinic"
            vet2.vetLocation = "East Jakarta, Indonesia"
            vet2.vetPrice = 180000
            vet2.vetImg = R.drawable.budi_budiman

            //3
            val vet3 = VetModel()
            vet3.vetName = "Cantik Cantika"
            vet3.vetHospital = "West Animal Clinic"
            vet3.vetLocation = "West Jakarta, Indonesia"
            vet3.vetPrice = 150000
            vet3.vetImg = R.drawable.cantik_cantika

            //4
            val vet4 = VetModel()
            vet4.vetName = "Dani Daniel"
            vet4.vetHospital = "South Animal Clinic"
            vet4.vetLocation = "South Jakarta, Indonesia"
            vet4.vetPrice = 120000
            vet4.vetImg = R.drawable.dani_daniel

            return arrayListOf(vet1, vet2, vet3, vet4)
        }
    }
}