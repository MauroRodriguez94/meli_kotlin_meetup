package com.mercadolibre.melikotlinmeetup.services.shipping

import com.mercadolibre.melikotlinmeetup.commons.ShippingOption

class ShippingOptionServices: ShippingOptionsInteractor {
    override fun retrieveBestShippingOption(): ShippingOption? {
        val shippingOptions = retrieveShippingOptions()
        var bestShippingOption: ShippingOption? = null

        for (shippingOption in shippingOptions) {
            bestShippingOption = shippingOption.getBestShippingOption(bestShippingOption)
        }

        return bestShippingOption
    }
}