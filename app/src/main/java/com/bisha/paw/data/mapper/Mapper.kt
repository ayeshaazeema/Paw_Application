package com.bisha.paw.data.mapper

import com.bisha.paw.data.model.*
import com.bisha.paw.data.model_ui.Article
import com.bisha.paw.data.model_ui.Food
import com.bisha.paw.data.model_ui.Vet

fun Int?.orZero(): Int = this ?: 0

fun VetDataResponse.map(): List<Vet> {
    return this.vets?.map { it.map() }.orEmpty()
}

fun FoodDataResponse.map(): List<Food> {
    return this.foods?.map { it.map() }.orEmpty()
}

fun ArticleDataResponse.map(): List<Article> {
    return this.articles?.map { it.map() }.orEmpty()
}

fun VetResponse.map(): Vet {
    return Vet(
        vetLocation = vetLocation.orEmpty(),
        vetInfo = vetInfo.orEmpty(),
        vetPrice = vetPrice.orEmpty(),
        updatedAt = updatedAt.orEmpty(),
        id = id.orZero(),
        createdAt = createdAt.orEmpty(),
        vetName = vetName.orEmpty(),
        vetClinic = vetClinic.orEmpty(),
        urlImage = urlImage.orEmpty()
    )
}

fun FoodResponse.map(): Food {
    return Food(
        foodPrice = foodPrice.orEmpty(),
        foodComposition = foodComposition.orEmpty(),
        urlImage = urlImage.orEmpty(),
        foodDescription = foodDescription.orEmpty(),
        createdAt = createdAt.orEmpty(),
        foodName = foodName.orEmpty(),
        id = id.orZero(),
        updatedAt = updatedAt.orEmpty(),
        foodBrand = foodBrand.orEmpty()
    )
}

fun ArticleResponse.map(): Article {
    return Article(
        createdAt = createdAt.orEmpty(),
        imageUrl = imageUrl.orEmpty(),
        id = id.orZero(),
        updatedAt = updatedAt.orEmpty(),
        articleCategory = articleCategory.orEmpty(),
        articleName = articleName.orEmpty(),
        articleHowTo = articleHowTo.orEmpty(),
        articleDescription = articleDescription.orEmpty()
    )
}