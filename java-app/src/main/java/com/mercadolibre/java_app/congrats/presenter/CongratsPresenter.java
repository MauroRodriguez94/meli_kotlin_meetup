package com.mercadolibre.java_app.congrats.presenter;

import com.mercadolibre.java_app.R;
import com.mercadolibre.java_app.commons.Purchase;
import com.mercadolibre.java_app.congrats.CongratsContract;

public class CongratsPresenter {
    private final CongratsContract.CongratsView congratsView;
    private final Purchase purchase;

    public CongratsPresenter(CongratsContract.CongratsView congratsView, Purchase purchase) {
        this.congratsView = congratsView;
        this.purchase = purchase;
    }

    public void setCongratsTexts() {
        showCongratsTexts();
        showShipping();
    }

    private void showShipping() {
        purchase.getShippingOption().showShippingPrices(congratsView);
    }

    private void showCongratsTexts() {
        congratsView.showTitle("Excelente compra!", R.color.green);
        congratsView.showFooter("Te avisaremos cuando esté en camino!");
    }
}
