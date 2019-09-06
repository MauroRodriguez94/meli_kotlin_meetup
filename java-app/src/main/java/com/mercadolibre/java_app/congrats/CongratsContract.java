package com.mercadolibre.java_app.congrats;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;

import com.mercadolibre.java_app.commons.ShippingOptionView;

public interface CongratsContract {
    public interface CongratsView extends ShippingOptionView {
        void showTitle(@NonNull String titleText, @ColorRes int color);
        void showFooter(@NonNull String footerText);
    }
}
