package com.bisha.paw.data.model

import com.google.gson.annotations.SerializedName

data class VetDataResponse(
    @SerializedName("status")
    val status: String?,

    @SerializedName("vet")
    val vets: List<VetResponse>?
)

data class VetResponse(
    @SerializedName("vet_price")
    val vetPrice: String?,

    @SerializedName("updated_at")
    val updatedAt: String?,

    @SerializedName("vet_name")
    val vetName: String?,

    @SerializedName("url_image")
    val urlImage: String?,

    @SerializedName("vet_info")
    val vetInfo: String?,

    @SerializedName("vet_clinic")
    val vetClinic: String?,

    @SerializedName("created_at")
    val createdAt: String?,

    @SerializedName("id")
    val id: Int?,

    @SerializedName("vet_location")
    val vetLocation: String?
)