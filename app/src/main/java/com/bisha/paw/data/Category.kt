package com.bisha.paw.data

import kotlin.reflect.KProperty1

data class Category(
    val value: String,
    var isSelected: Boolean = false
) {
    companion object {
        fun getAllCategories(): ArrayList<Category> {
            return arrayListOf(
                Category("All"),
                Category("Cat"),
                Category("Dog"),
                Category("Bird"),
                Category("Fish"),
                Category("Rabbit")
            )
        }

        fun getCategory(value: String): Map<KProperty1<Category, String>, Category> {
            return getAllCategories().associateBy { Category::value }
        }
    }
}

//
//        fun getCategory(value: String): Map<KProperty1<Category, String>, Category> {
//    val map = Category.values().associateBy { Category::value }
//    return map
//}

