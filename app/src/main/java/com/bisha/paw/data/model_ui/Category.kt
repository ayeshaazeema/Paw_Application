package com.bisha.paw.data.model_ui

import kotlin.reflect.KProperty1

enum class Category(val value: String) {
    ALL("All"),
    CAT("Cat"),
    DOG("Dog"),
    BIRD("Bird"),
    FISH("Fish"),
    RABBIT("Rabbit");

    companion object {
        fun getAllCategories(): ArrayList<Category> {
            return arrayListOf(ALL, CAT, DOG, BIRD, FISH, RABBIT)
        }

        fun getCategory(value: String): Map<KProperty1<Category, String>, Category> {
            return values().associateBy { Category::value }
        }
    }
}

