package com.bisha.paw.fragment.vet

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class VetModel(
    var vetName: String? = null,
    var vetHospital: String? = null,
    var vetLocation: String? = null,
    var vetPrice: String? = null,
    var vetImg: Int = 0
) : Parcelable