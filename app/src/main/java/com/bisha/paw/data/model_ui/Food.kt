package com.bisha.paw.data.model_ui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food(
    val foodComposition: String,
    val createdAt: String,
    val foodName: String,
    val id: Int,
    val urlImage: String,
    val foodDescription: String,
    val updatedAt: String,
    val foodPrice: String,
    val foodBrand: String
) : Parcelable