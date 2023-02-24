package com.bisha.paw.data.source

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiSource {
    companion object {
        const val BASE_URL = "https://bakpaw.smkidnakhwat.com/api/"

        fun getApiService(): ApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}