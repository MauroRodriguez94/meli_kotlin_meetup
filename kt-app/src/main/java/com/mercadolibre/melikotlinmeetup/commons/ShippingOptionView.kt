package com.mercadolibre.melikotlinmeetup.commons

interface ShippingOptionView {
    fun showShippingPrice(price: String, color: Int)
    fun showShippingType(shippingType: String)
}