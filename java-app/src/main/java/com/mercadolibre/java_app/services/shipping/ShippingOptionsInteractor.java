package com.mercadolibre.java_app.services.shipping;

import com.mercadolibre.java_app.models.shipping.ShippingOption;

public interface ShippingOptionsInteractor {
    ShippingOption retrieveBestShippingOption();
}
