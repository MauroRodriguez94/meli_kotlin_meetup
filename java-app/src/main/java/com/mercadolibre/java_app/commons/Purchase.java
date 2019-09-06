package com.mercadolibre.java_app.commons;

import android.os.Parcel;
import android.os.Parcelable;

import com.mercadolibre.java_app.models.shipping.ShippingOption;

public class Purchase implements Parcelable {
    private final Product product;
    private final ShippingOption shippingOption;

    public Purchase(Product product, ShippingOption shippingOption) {
        this.product = product;
        this.shippingOption = shippingOption;
    }

    public ShippingOption getShippingOption() {
        return shippingOption;
    }

    // -- Parcelable
    protected Purchase(Parcel in) {
        product = in.readParcelable(Product.class.getClassLoader());
        shippingOption = in.readParcelable(ShippingOption.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(product, flags);
        dest.writeParcelable(shippingOption, flags);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Purchase> CREATOR = new Parcelable.Creator<Purchase>() {
        @Override
        public Purchase createFromParcel(Parcel in) {
            return new Purchase(in);
        }

        @Override
        public Purchase[] newArray(int size) {
            return new Purchase[size];
        }
    };
}
