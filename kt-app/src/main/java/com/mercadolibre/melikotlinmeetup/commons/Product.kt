package com.mercadolibre.melikotlinmeetup.commons

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(private val id: String, val price: Double): Parcelable