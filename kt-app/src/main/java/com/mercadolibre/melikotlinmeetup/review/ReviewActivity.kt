package com.mercadolibre.melikotlinmeetup.review

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.mercadolibre.melikotlinmeetup.R
import com.mercadolibre.melikotlinmeetup.commons.Purchase
import com.mercadolibre.melikotlinmeetup.congrats.CongratsActivity
import com.mercadolibre.melikotlinmeetup.review.presenter.ReviewPresenter
import com.mercadolibre.melikotlinmeetup.services.shipping.ShippingOptionServices
import kotlinx.android.synthetic.main.review_layout.*

class ReviewActivity : AppCompatActivity(), ReviewView {
    private lateinit var presenter: ReviewPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.review_layout)

        presenter = ReviewPresenter(this, ShippingOptionServices())
        presenter.calculatePrices()

        setUpControls()
    }

    private fun setUpControls() {
        confirm_button.setOnClickListener { presenter.validatePurchase() }
    }

    override fun showProductPrice(price: String) {
        producto_price.text = price
    }

    override fun showShippingPrice(price: String, color: Int) {
        shipping_price.text = price
        shipping_price.setTextColor(ContextCompat.getColor(this, color))
    }

    override fun showTotalPrice(price: String) {
        total_price.text = price
    }

    override fun showShippingType(shippingType: String) {}

    override fun goToCongrats(purchase: Purchase) {
        val intent = Intent(this, CongratsActivity::class.java)
        intent.putExtra("purchase", purchase)

        startActivity(intent)
    }
}
