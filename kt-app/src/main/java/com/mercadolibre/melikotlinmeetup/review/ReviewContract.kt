package com.mercadolibre.melikotlinmeetup.review

import com.mercadolibre.melikotlinmeetup.commons.Purchase
import com.mercadolibre.melikotlinmeetup.commons.ShippingOptionView

interface ReviewView: ShippingOptionView {
    fun showProductPrice(price: String)
    fun showTotalPrice(price: String)
    fun goToCongrats(purchase: Purchase)
}