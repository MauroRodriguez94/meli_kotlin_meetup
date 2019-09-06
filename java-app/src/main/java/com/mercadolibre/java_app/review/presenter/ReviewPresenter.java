package com.mercadolibre.java_app.review.presenter;

import com.mercadolibre.java_app.commons.Prices;
import com.mercadolibre.java_app.commons.Product;
import com.mercadolibre.java_app.commons.Purchase;
import com.mercadolibre.java_app.models.shipping.ShippingOption;
import com.mercadolibre.java_app.review.ReviewContract;
import com.mercadolibre.java_app.services.shipping.ShippingOptionsInteractor;

public class ReviewPresenter {
    private final ReviewContract.ReviewView reviewView;
    private final Product product;
    private final ShippingOption shippingOption;

    public ReviewPresenter(ReviewContract.ReviewView reviewView, ShippingOptionsInteractor shippingOptionsInteractor) {
        this.reviewView = reviewView;
        this.product = new Product("idProduct", 100.0);
        this.shippingOption = shippingOptionsInteractor.retrieveBestShippingOption();
    }

    public void calculatePrices() {
        showProductPrices();
        showShippingPrices();
        showTotal();
    }

    private void showProductPrices() {
        reviewView.showProductPrice(Prices.priceFormat(product.getPrice()));
    }

    private void showShippingPrices() {
        shippingOption.showShippingPrices(reviewView);
    }

    private void showTotal() {
        reviewView.showTotalPrice(shippingOption.calculatePrice(product.getPrice()));
    }

    public void validatePurchase() {
        if (product != null && shippingOption != null) {
            Purchase purchase = new Purchase(product, shippingOption);
            reviewView.goToCongrats(purchase);
        }
    }
}
