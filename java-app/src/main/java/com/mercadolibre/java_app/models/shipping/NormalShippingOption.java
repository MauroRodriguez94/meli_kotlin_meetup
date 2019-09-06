package com.mercadolibre.java_app.models.shipping;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.mercadolibre.java_app.R;
import com.mercadolibre.java_app.commons.Prices;
import com.mercadolibre.java_app.commons.ShippingOptionView;

public class NormalShippingOption extends AbstractShippingOption {
    public NormalShippingOption(Double price, String type) {
        super(price, type);
    }

    public NormalShippingOption(Double price) {
        this(price, "Normal a domicilio");
    }

    @Override
    public void showShippingPrices(@NonNull ShippingOptionView view) {
        view.showShippingPrice(Prices.priceFormat(price), R.color.black);
        view.showShippingType(type);
    }

    // -- Parcelable
    protected NormalShippingOption(Parcel in) {
        super(in);
    }

    public static final Parcelable.Creator<NormalShippingOption> CREATOR = new Parcelable.Creator<NormalShippingOption>() {
        public NormalShippingOption createFromParcel(Parcel in) {
            return new NormalShippingOption (in);
        }

        public NormalShippingOption [] newArray(int size) {
            return new NormalShippingOption[size];
        }
    };
}