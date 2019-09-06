package com.mercadolibre.melikotlinmeetup.review.presenter

import com.mercadolibre.melikotlinmeetup.commons.Product
import com.mercadolibre.melikotlinmeetup.commons.Purchase
import com.mercadolibre.melikotlinmeetup.commons.ShippingOption
import com.mercadolibre.melikotlinmeetup.commons.toPriceFormat
import com.mercadolibre.melikotlinmeetup.review.ReviewView
import com.mercadolibre.melikotlinmeetup.services.shipping.ShippingOptionsInteractor

class ReviewPresenter(private var reviewView: ReviewView, private val shippingOptionsInteractor: ShippingOptionsInteractor) {
    private val shippingOption: ShippingOption?
    private val product: Product?

    init {
        this.shippingOption = shippingOptionsInteractor.retrieveBestShippingOption()
        this.product = Product("idProduct", 100.0)
    }

    fun calculatePrices() {
        showProductPrices()
        showShippingPrices()
        showTotal()
    }

    private fun showProductPrices() {
        reviewView.showProductPrice(product?.price!!.toPriceFormat())
    }

    private fun showShippingPrices() {
        shippingOption?.showShippingPrices(reviewView)
    }

    private fun showTotal() {
        reviewView.showTotalPrice(shippingOption!!.calculatePrice(product?.price!!))
    }

    fun validatePurchase() {
        if (product != null && shippingOption != null) {
            val purchase = Purchase(product, shippingOption)
            reviewView.goToCongrats(purchase)
        }
    }
}