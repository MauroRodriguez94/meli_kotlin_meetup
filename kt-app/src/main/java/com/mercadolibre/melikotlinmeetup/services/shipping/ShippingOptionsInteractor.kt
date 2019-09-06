package com.mercadolibre.melikotlinmeetup.services.shipping

import com.mercadolibre.melikotlinmeetup.commons.ShippingOption

interface ShippingOptionsInteractor {
    fun retrieveBestShippingOption() : ShippingOption?
}