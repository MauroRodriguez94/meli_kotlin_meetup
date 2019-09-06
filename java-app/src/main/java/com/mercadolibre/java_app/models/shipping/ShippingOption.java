package com.mercadolibre.java_app.models.shipping;

import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mercadolibre.java_app.commons.ShippingOptionView;

public interface ShippingOption extends Parcelable {
    void showShippingPrices(@NonNull ShippingOptionView view);
    String calculatePrice(Double productPrices);
    ShippingOption getBestShippingOption(@Nullable ShippingOption otherShippingOption);
    boolean isBetterPriceThan(Double price);
}
