package com.bisha.paw.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bisha.paw.data.model_ui.Article
import com.bisha.paw.data.model_ui.Food
import com.bisha.paw.data.model_ui.Vet
import com.bisha.paw.data.repository.MainRepository
import com.bisha.paw.utils.ViewState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    // use lazy because we're not using any Dependency Injection whatsoever
    private val repository: MainRepository by lazy {
        return@lazy MainRepository()
    }

    private val _articlesResult: MutableLiveData<ViewState<List<Article>>> = MutableLiveData()
    val articlesResult: LiveData<ViewState<List<Article>>> get() = _articlesResult

    private val _foodsResult: MutableLiveData<ViewState<List<Food>>> = MutableLiveData()
    val foodsResult: LiveData<ViewState<List<Food>>> get() = _foodsResult

    private val _vetsResult: MutableLiveData<ViewState<List<Vet>>> = MutableLiveData()
    val vetsResult: LiveData<ViewState<List<Vet>>> get() = _vetsResult

    init {
        _articlesResult.value = ViewState.default()
        _foodsResult.value = ViewState.default()
        _vetsResult.value = ViewState.default()
    }

    fun getArticles() = viewModelScope.launch {
        _articlesResult.value = ViewState.loading()
        repository.getArticles()
            .catch { _articlesResult.value = ViewState.fail(it.message) }
            .collect { _articlesResult.value = ViewState.success(it) }
    }

    fun getFoods() = viewModelScope.launch {
        _foodsResult.value = ViewState.loading()
        repository.getFoods()
            .catch { _foodsResult.value = ViewState.fail(it.message) }
            .collect { _foodsResult.value = ViewState.success(it) }
    }

    fun getVets() = viewModelScope.launch {
        _vetsResult.value = ViewState.loading()
        repository.getVets()
            .catch { _vetsResult.value = ViewState.fail(it.message) }
            .collect { _vetsResult.value = ViewState.success(it) }
    }
}