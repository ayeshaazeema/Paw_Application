package com.bisha.paw.data.model_ui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Vet(
    val vetPrice: String,
    val updatedAt: String,
    val vetName: String,
    val urlImage: String,
    val vetInfo: String,
    val vetClinic: String,
    val createdAt: String,
    val id: Int,
    val vetLocation: String
): Parcelable