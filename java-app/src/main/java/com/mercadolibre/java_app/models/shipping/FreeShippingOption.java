package com.mercadolibre.java_app.models.shipping;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.mercadolibre.java_app.R;
import com.mercadolibre.java_app.commons.ShippingOptionView;

public class FreeShippingOption extends AbstractShippingOption {
    public FreeShippingOption(String type) {
        super(0.0, type);
    }

    @Override
    public void showShippingPrices(@NonNull ShippingOptionView view) {
        view.showShippingPrice("Gratis", R.color.green);
        view.showShippingType(type);
    }

    // -- Parcelable
    protected FreeShippingOption(Parcel in) {
        super(in);
    }

    public static final Parcelable.Creator<FreeShippingOption> CREATOR = new Parcelable.Creator<FreeShippingOption>() {
        public FreeShippingOption createFromParcel(Parcel in) {
            return new FreeShippingOption (in);
        }

        public FreeShippingOption [] newArray(int size) {
            return new FreeShippingOption[size];
        }
    };
}
