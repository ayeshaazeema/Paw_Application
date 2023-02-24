package com.bisha.paw.data.model

import com.google.gson.annotations.SerializedName

data class FoodDataResponse(
    @SerializedName("food")
    val foods: List<FoodResponse>?,

    @SerializedName("status")
    val status: String?
)

data class FoodResponse(
    @SerializedName("food_composition")
    val foodComposition: String?,

    @SerializedName("created_at")
    val createdAt: String?,

    @SerializedName("food_name")
    val foodName: String?,

    @SerializedName("id")
    val id: Int?,

    @SerializedName("url_image")
    val urlImage: String?,

    @SerializedName("food_description")
    val foodDescription: String?,

    @SerializedName("updated_at")
    val updatedAt: String?,

    @SerializedName("food_price")
    val foodPrice: String?,

    @SerializedName("food_brand")
    val foodBrand: String?
)