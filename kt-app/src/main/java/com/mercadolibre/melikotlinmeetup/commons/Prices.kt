package com.mercadolibre.melikotlinmeetup.commons

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

fun Double.toPriceFormat() : String {
    val decimalFormat = NumberFormat.getNumberInstance(Locale.GERMAN) as DecimalFormat
    val formattedPrice = decimalFormat.format(this)

    return "$ $formattedPrice"
}