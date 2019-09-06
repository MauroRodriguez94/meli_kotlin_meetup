package com.mercadolibre.melikotlinmeetup.commons

import android.os.Parcelable

interface ShippingOption : Parcelable {
    fun showShippingPrices(view: ShippingOptionView)
    fun calculatePrice(productPrices: Double) : String
    fun getBestShippingOption(otherShippingOption: ShippingOption?): ShippingOption
    fun isBetterPriceThan(price: Double): Boolean
}