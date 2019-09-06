package com.mercadolibre.java_app.congrats;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.mercadolibre.java_app.R;
import com.mercadolibre.java_app.commons.Purchase;
import com.mercadolibre.java_app.congrats.presenter.CongratsPresenter;

public class CongratsActivity extends AppCompatActivity implements CongratsContract.CongratsView {
    private CongratsPresenter presenter;
    private TextView congratsTitle;
    private TextView footer;
    private TextView shippingPrice;
    private TextView shippingType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.congrats_layout);

        Purchase purchase = getIntent().getParcelableExtra("purchase");

        presenter = new CongratsPresenter(this, purchase);

        setUpControls();
        presenter.setCongratsTexts();
    }

    private void setUpControls() {
        this.congratsTitle = findViewById(R.id.congrats_title);
        this.footer = findViewById(R.id.footer);
        this.shippingPrice = findViewById(R.id.shipping_price);
        this.shippingType = findViewById(R.id.shipping_type);
    }

    @Override
    public void showTitle(@NonNull String titleText, int color) {
        congratsTitle.setText(titleText);
        //TODO hacer algo con el color
    }

    @Override
    public void showFooter(@NonNull String footerText) {
        footer.setText(footerText);
    }

    @Override
    public void showShippingPrice(@NonNull String price, @ColorRes int color) {
        shippingPrice.setText(price);
        shippingPrice.setTextColor(ContextCompat.getColor(this, color));
    }

    @Override
    public void showShippingType(@NonNull String shippingType) {
        this.shippingType.setText(shippingType);
    }
}
