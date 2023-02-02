package com.bisha.paw

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ArticleModel(
    var articleTitle: String? = null,
    var articleCategory: String? = null,
    var articleImg: Int = 0
) : Parcelable