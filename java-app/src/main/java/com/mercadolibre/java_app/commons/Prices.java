package com.mercadolibre.java_app.commons;

import java.text.NumberFormat;
import java.util.Locale;

public class Prices {
    public static String priceFormat(Double price) {
        NumberFormat decimalFormat = NumberFormat.getNumberInstance(Locale.GERMAN);
        return "$ " + decimalFormat.format(price);
    }
}
