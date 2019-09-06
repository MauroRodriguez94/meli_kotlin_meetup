package com.mercadolibre.melikotlinmeetup.congrats

import com.mercadolibre.melikotlinmeetup.commons.ShippingOptionView

interface CongratsView : ShippingOptionView {
    fun showTitle(titleText: String, color: Int)
    fun showFooter(footerText: String)
}