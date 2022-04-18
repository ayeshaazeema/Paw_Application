package com.bisha.paw.category

import androidx.lifecycle.Transformations.map
import kotlin.reflect.KProperty1


enum class Category(val value: String){
    ALL("All"),
    CAT("Cat"),
    DOG("Dog"),
    BIRD("Bird"),
    FISH("Fish"),
    RABBIT("Rabbit")
}
fun getAllCategories(): List<Category>{
    return listOf(Category.ALL,Category.CAT,Category.DOG,Category.BIRD,Category.FISH,Category.RABBIT)
}

fun getCategory(value: String): Map<KProperty1<Category, String>, Category> {
    val map = Category.values().associateBy { Category::value }
    return map
}

