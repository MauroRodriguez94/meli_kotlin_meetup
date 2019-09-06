package com.mercadolibre.melikotlinmeetup.services.shipping

import com.mercadolibre.melikotlinmeetup.commons.ShippingOption
import com.mercadolibre.melikotlinmeetup.models.shipping.FreeShippingOption
import com.mercadolibre.melikotlinmeetup.models.shipping.NormalShippingOption

fun retrieveShippingOptions(): List<ShippingOption> {
    val freeShippingOption = FreeShippingOption("Gratis a domicilio")
    val normalShippingOption = NormalShippingOption(100.0)

    return arrayListOf(freeShippingOption, normalShippingOption)
}