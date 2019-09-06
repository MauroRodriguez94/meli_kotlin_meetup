package com.mercadolibre.java_app.models.shipping;

import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mercadolibre.java_app.R;
import com.mercadolibre.java_app.commons.Prices;
import com.mercadolibre.java_app.commons.ShippingOptionView;

public abstract class AbstractShippingOption implements ShippingOption {
    protected Double price;
    protected String type;

    public AbstractShippingOption(Double price, String type) {
        this.price = price;
        this.type = type;
    }

    @Override
    public void showShippingPrices(@NonNull ShippingOptionView view) {
        view.showShippingPrice(Prices.priceFormat(price), R.color.black);
        view.showShippingType(type);
    }

    @Override
    public String calculatePrice(Double productPrices) {
        return Prices.priceFormat(productPrices + price);
    }

    @Override
    public ShippingOption getBestShippingOption(@Nullable ShippingOption otherShippingOption) {
        ShippingOption bestShippingOption = this;
        if (otherShippingOption != null) {
            if (otherShippingOption.isBetterPriceThan(this.price)) {
                bestShippingOption = otherShippingOption;
            }
        }

        return bestShippingOption;
    }

    @Override
    public boolean isBetterPriceThan(Double price) {
        return this.price.compareTo(price) < 0;
    }

    // -- Parcelable
    protected AbstractShippingOption(Parcel in) {
        this.price = in.readDouble();
        this.type = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(price);
        dest.writeString(type);
    }
}
