package com.mercadolibre.melikotlinmeetup.commons

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Purchase(val product: Product, val shippingOption: ShippingOption): Parcelable