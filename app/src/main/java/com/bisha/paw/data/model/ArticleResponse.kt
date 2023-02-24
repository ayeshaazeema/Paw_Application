package com.bisha.paw.data.model

import com.google.gson.annotations.SerializedName

data class ArticleDataResponse(
    @SerializedName("status")
    val status: String?,

    @SerializedName("article")
    val articles: List<ArticleResponse>?
)

data class ArticleResponse(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("updated_at")
    val updatedAt: String?,

    @SerializedName("article_description")
    val articleDescription: String?,

    @SerializedName("image_url")
    val imageUrl: String?,

    @SerializedName("article_category")
    val articleCategory: String?,

    @SerializedName("article_how_to")
    val articleHowTo: String?,

    @SerializedName("created_at")
    val createdAt: String?,

    @SerializedName("article_name")
    val articleName: String?
)