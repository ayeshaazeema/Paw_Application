package com.bisha.paw.data.model_ui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    val id: Int,
    val updatedAt: String,
    val articleDescription: String,
    val imageUrl: String,
    val articleCategory: String,
    val articleHowTo: String,
    val createdAt: String,
    val articleName: String
) : Parcelable