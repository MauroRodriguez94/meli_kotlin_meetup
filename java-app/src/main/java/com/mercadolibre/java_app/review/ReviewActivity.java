package com.mercadolibre.java_app.review;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.mercadolibre.java_app.R;
import com.mercadolibre.java_app.commons.Purchase;
import com.mercadolibre.java_app.congrats.CongratsActivity;
import com.mercadolibre.java_app.review.presenter.ReviewPresenter;
import com.mercadolibre.java_app.services.shipping.ShippingOptionServices;

public class ReviewActivity extends AppCompatActivity implements ReviewContract.ReviewView {
    private ReviewPresenter presenter;
    private Button confirmButton;
    private TextView productPrice;
    private TextView totalPrice;
    private TextView shippingPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_layout);

        presenter = new ReviewPresenter(this, new ShippingOptionServices());

        setUpControls();
        setUpEvents();
        presenter.calculatePrices();
    }

    private void setUpControls() {
        this.confirmButton = findViewById(R.id.confirm_button);
        this.productPrice = findViewById(R.id.producto_price);
        this.totalPrice = findViewById(R.id.total_price);
        this.shippingPrice = findViewById(R.id.shipping_price);
    }

    private void setUpEvents() {
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validatePurchase();
            }
        });
    }

    @Override
    public void showProductPrice(String price) {
        productPrice.setText(price);
    }

    @Override
    public void showTotalPrice(String price) {
        totalPrice.setText(price);
    }

    @Override
    public void showShippingPrice(@NonNull String price, @ColorRes int color) {
        shippingPrice.setText(price);
        shippingPrice.setTextColor(ContextCompat.getColor(this, color));
    }

    @Override
    public void showShippingType(@NonNull String shippingType) {}

    @Override
    public void goToCongrats(Purchase purchase) {
        Intent intent = new Intent(this, CongratsActivity.class);
        intent.putExtra("purchase", purchase);

        startActivity(intent);
    }
}
