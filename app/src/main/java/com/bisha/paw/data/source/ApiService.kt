package com.bisha.paw.data.source

import com.bisha.paw.data.model.ArticleDataResponse
import com.bisha.paw.data.model.FoodDataResponse
import com.bisha.paw.data.model.VetDataResponse
import retrofit2.http.GET

interface ApiService {

    @GET("food/get")
    suspend fun getFoods(): FoodDataResponse

    @GET("article/get")
    suspend fun getArticles(): ArticleDataResponse

    @GET("vet/get")
    suspend fun getVets(): VetDataResponse
}