package com.bisha.paw.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import java.text.NumberFormat
import java.util.*

private val LANGUAGE_INDONESIA = "id"

private val COUNTRY_INDONESIA = "ID"

val localeIndonesia = Locale(LANGUAGE_INDONESIA, COUNTRY_INDONESIA)

fun ImageView.setImageUrl(context: Context, imageUrl: String) {
    Glide.with(context).load(imageUrl).into(this)
}

fun Int.toFormatRupiah(): String {
    val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeIndonesia)
    val stringResult = formatRupiah.format(this)
    return stringResult.replace("Rp", "Rp ").substringBefore(",")
}

fun Context.getColorResource(id: Int) = resources.getColor(id)

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun <U> LiveData<ViewState<U>>.observeLiveData(
    owner: LifecycleOwner,
    context: Context,
    onLoading: (() -> (Unit))? = null,
    onSuccess: (U) -> Unit,
    onFailure: ((Throwable) -> Unit)? = null
) {
//    var apiError: ApiError

    this.observe(owner) {
        when (it) {
            is ViewState.Loading -> {
                onLoading?.invoke()
            }

            is ViewState.Success -> {
                onSuccess.invoke(it.data)
            }

            is ViewState.Failure -> {
                it.throwable?.let { it1 -> onFailure?.invoke(it1) }
                context.showToast(it.throwable?.message.orEmpty())
            }

            else -> {}
        }
    }
}