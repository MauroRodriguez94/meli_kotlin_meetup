package com.mercadolibre.melikotlinmeetup.congrats.presenter

import com.mercadolibre.melikotlinmeetup.R
import com.mercadolibre.melikotlinmeetup.commons.Purchase
import com.mercadolibre.melikotlinmeetup.congrats.CongratsView

class CongratsPresenter(private val congratsView: CongratsView, private val purchase: Purchase) {
    fun setCongratsTexts() {
        showCongratsTexts()
        showShipping()
    }

    private fun showShipping() {
        purchase.shippingOption.showShippingPrices(congratsView)
    }

    private fun showCongratsTexts() {
        congratsView.showTitle("Excelente compra!", R.color.green)
        congratsView.showFooter("Te avisaremos cuando esté en camino!")
    }
}