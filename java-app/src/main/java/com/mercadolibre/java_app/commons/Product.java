package com.mercadolibre.java_app.commons;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private final String id;
    private final Double price;

    public Product(String id, Double price) {
        this.id = id;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }


    // -- Parcelable
    protected Product(Parcel in) {
        id = in.readString();
        price = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeDouble(price);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
