package com.mercadolibre.java_app.review;

import com.mercadolibre.java_app.commons.Purchase;
import com.mercadolibre.java_app.commons.ShippingOptionView;

public interface ReviewContract {
    interface ReviewView extends ShippingOptionView {
        void showProductPrice(String price);
        void showTotalPrice(String price);
        void goToCongrats(Purchase purchase);
    }
}
