package com.bisha.paw.category

import kotlin.reflect.KProperty1

enum class Category(val value: String) {
    ALL("All"),
    CAT("Cat"),
    DOG("Dog"),
    BIRD("Bird"),
    FISH("Fish"),
    RABBIT("Rabbit");

    companion object {
        fun getAllCategories(): List<Category> {
            return listOf(ALL, Category.CAT, Category.DOG, Category.BIRD, Category.FISH, Category.RABBIT)
        }

        fun getCategory(value: String): Map<KProperty1<Category, String>, Category> {
            return values().associateBy { Category::value }
        }
    }
}

//
//        fun getCategory(value: String): Map<KProperty1<Category, String>, Category> {
//    val map = Category.values().associateBy { Category::value }
//    return map
//}

