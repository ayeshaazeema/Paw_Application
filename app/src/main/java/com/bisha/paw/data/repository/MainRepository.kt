package com.bisha.paw.data.repository

import com.bisha.paw.data.mapper.map
import com.bisha.paw.data.model_ui.Article
import com.bisha.paw.data.model_ui.Food
import com.bisha.paw.data.model_ui.Vet
import com.bisha.paw.data.source.ApiService
import com.bisha.paw.data.source.ApiSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository {

    private val apiService: ApiService by lazy {
        return@lazy ApiSource.getApiService()
    }

    fun getFoods(): Flow<List<Food>> {
        return flow {
            try {
                emit(apiService.getFoods().map())
            } catch (e: Throwable) {
                throw e
            }
        }
    }

    fun getArticles(): Flow<List<Article>> {
        return flow {
            try {
                emit(apiService.getArticles().map())
            } catch (e: Throwable) {
                throw e
            }
        }
    }

    fun getVets(): Flow<List<Vet>> {
        return flow {
            try {
                emit(apiService.getVets().map())
            } catch (e: Throwable) {
                throw e
            }
        }
    }

}