package com.mercadolibre.melikotlinmeetup.models.shipping

import com.mercadolibre.melikotlinmeetup.R
import com.mercadolibre.melikotlinmeetup.commons.ShippingOption
import com.mercadolibre.melikotlinmeetup.commons.ShippingOptionView
import com.mercadolibre.melikotlinmeetup.commons.toPriceFormat

abstract class AbstractShippingOption(open val price: Double, open val type: String): ShippingOption {
    override fun showShippingPrices(view: ShippingOptionView) {
        view.run {
            showShippingPrice(price.toPriceFormat(), R.color.black)
            showShippingType(type)
        }
    }

    override fun calculatePrice(productPrices: Double): String {
        return (productPrices + price).toPriceFormat()
    }

    override fun getBestShippingOption(otherShippingOption: ShippingOption?): ShippingOption {
        var bestShippingOption: ShippingOption = this
        if (otherShippingOption != null) {
            if (otherShippingOption.isBetterPriceThan(this.price)) {
                bestShippingOption = otherShippingOption
            }
        }

        return bestShippingOption
    }

    override fun isBetterPriceThan(price: Double): Boolean {
        return this.price < price
    }
}