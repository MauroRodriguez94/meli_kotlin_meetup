package com.mercadolibre.java_app.services.shipping;

import com.mercadolibre.java_app.models.shipping.FreeShippingOption;
import com.mercadolibre.java_app.models.shipping.NormalShippingOption;
import com.mercadolibre.java_app.models.shipping.ShippingOption;

import java.util.Arrays;
import java.util.List;

public final class ShippingOptionsDataSource {
    private ShippingOptionsDataSource() {}

    public static List<ShippingOption> retrieveShippingOptions()  {
        ShippingOption freeShippingOption = new FreeShippingOption("Gratis a domicilio");
        ShippingOption normalShippingOption = new NormalShippingOption(100.0);

        return Arrays.asList(freeShippingOption, normalShippingOption);
    }
}
