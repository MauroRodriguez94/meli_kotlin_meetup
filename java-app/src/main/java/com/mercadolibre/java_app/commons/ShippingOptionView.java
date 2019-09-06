package com.mercadolibre.java_app.commons;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;

public interface ShippingOptionView {
    void showShippingPrice(@NonNull String price, @ColorRes int color);
    void showShippingType(@NonNull String shippingType);
}
