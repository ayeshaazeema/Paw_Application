package com.bisha.paw.fragment.vet

class Vet (private var VetName: String, private var HospitalName: String,
           private var LocationVet: String, private var VetPrice:Int) {

    fun getVetName(): String {
        return VetName
    }

    fun setVetName(VetName: String) {
        this.VetName = VetName
    }

    fun getHospitalName(): String {
        return HospitalName
    }

    fun setHospitalName(HospitalName: String) {
        this.HospitalName = HospitalName
    }

    fun getLocationVet(): String {
        return LocationVet
    }

    fun setLocationVet(LocationVet: String) {
        this.LocationVet = LocationVet
    }

    fun getVetPrice(): Int {
        return VetPrice
    }

    fun setVetPrice(VetPrice: Int) {
        this.VetPrice = VetPrice
    }

}