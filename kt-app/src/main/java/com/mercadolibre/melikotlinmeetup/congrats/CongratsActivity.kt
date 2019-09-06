package com.mercadolibre.melikotlinmeetup.congrats

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.mercadolibre.melikotlinmeetup.R
import com.mercadolibre.melikotlinmeetup.commons.Purchase
import com.mercadolibre.melikotlinmeetup.congrats.presenter.CongratsPresenter
import kotlinx.android.synthetic.main.congrats_layout.*

class CongratsActivity: AppCompatActivity(), CongratsView {
    private lateinit var presenter: CongratsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.congrats_layout)

        val purchase: Purchase = intent.getParcelableExtra("purchase") as Purchase

        presenter = CongratsPresenter(this, purchase)
        presenter.setCongratsTexts()
    }

    override fun showTitle(titleText: String, color: Int) {
        congrats_title.text = titleText
        //TODO hacer algo con el color
    }

    override fun showFooter(footerText: String) {
        footer.text  = footerText
    }

    override fun showShippingPrice(price: String, color: Int) {
        shipping_price.text = price
        shipping_price.setTextColor(ContextCompat.getColor(this, color))
    }

    override fun showShippingType(shippingType: String) {
        shipping_type.text = shippingType
    }
}