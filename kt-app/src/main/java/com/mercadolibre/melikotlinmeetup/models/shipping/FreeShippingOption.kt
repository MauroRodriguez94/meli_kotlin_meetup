package com.mercadolibre.melikotlinmeetup.models.shipping

import com.mercadolibre.melikotlinmeetup.R
import com.mercadolibre.melikotlinmeetup.commons.ShippingOptionView
import kotlinx.android.parcel.Parcelize

@Parcelize
class FreeShippingOption(override val type: String): AbstractShippingOption(0.0, type) {
    override fun showShippingPrices(view: ShippingOptionView) {
        view.run {
            showShippingPrice("Gratis", R.color.green)
            showShippingType(type)
        }
    }

    override fun isBetterPriceThan(price: Double): Boolean {
        return true
    }
}