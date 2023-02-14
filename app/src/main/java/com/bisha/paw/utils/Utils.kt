package com.bisha.paw.utils

import java.text.NumberFormat
import java.util.*

private val LANGUAGE_INDONESIA = "id"

private val COUNTRY_INDONESIA = "ID"

val localeIndonesia = Locale(LANGUAGE_INDONESIA, COUNTRY_INDONESIA)

fun Int.toFormatRupiah(): String {
    val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeIndonesia)
    val stringResult = formatRupiah.format(this)
    return stringResult.replace("Rp", "Rp ").substringBefore(",")
}
