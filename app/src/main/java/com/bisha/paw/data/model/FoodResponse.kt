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

//@Parcelize
//data class Food(
//    val foodName: String,
//    val foodBrand: String,
//    val foodPrice: Int
//): Parcelable {
//    companion object {
//        fun getFoods(): ArrayList<Food> {
//            return arrayListOf(
//                Food("Whiskas® Dry Adult 1+ Indoor", "Whiskas", 48000),
//                Food("WHISKAS® Wet Food Pouch Junior 80gr", "Whiskas", 28000),
//                Food("Royal Canin Kitten Dry 400gr", "Royal Canin", 158620),
//                Food("Royal Canin Indoor Long Hair (2kg)", "Royal Canin", 314500),
//                Food("Korean Collagen 150gr Biotin Zinc Vitamin ", "PetGlow", 128325)
//            )
//        }
//    }
//}