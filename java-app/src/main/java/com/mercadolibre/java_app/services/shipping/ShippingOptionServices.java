package com.mercadolibre.java_app.services.shipping;

import com.mercadolibre.java_app.models.shipping.ShippingOption;

import java.util.List;

public final class ShippingOptionServices implements ShippingOptionsInteractor {

    @Override
    public ShippingOption retrieveBestShippingOption() {
        List<ShippingOption> shippingOptions = ShippingOptionsDataSource.retrieveShippingOptions();
        ShippingOption bestShippingOption = null;

        for (ShippingOption shippingOption : shippingOptions) {
            bestShippingOption = shippingOption.getBestShippingOption(bestShippingOption);
        }

        return bestShippingOption;
    }
}
