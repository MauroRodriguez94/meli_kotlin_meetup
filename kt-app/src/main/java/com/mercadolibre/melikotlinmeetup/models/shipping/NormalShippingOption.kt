package com.mercadolibre.melikotlinmeetup.models.shipping

import com.mercadolibre.melikotlinmeetup.R
import com.mercadolibre.melikotlinmeetup.commons.ShippingOptionView
import com.mercadolibre.melikotlinmeetup.commons.toPriceFormat
import kotlinx.android.parcel.Parcelize

@Parcelize
class NormalShippingOption(override val price: Double, override val type: String = "Normal a domicilio"): AbstractShippingOption(price, type) {
    override fun showShippingPrices(view: ShippingOptionView) {
        view.run {
            showShippingPrice(price.toPriceFormat(), R.color.black)
            showShippingType(type)
        }
    }
}