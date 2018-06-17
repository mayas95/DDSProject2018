package com.model;

import java.math.BigDecimal;

public interface State {

    void buyOrder(BigDecimal price, PaymentMethod paymentMethod, ShippingMethod  shippingMethod );
    void verificateOrder();
    void cancelOrder();
    void sendOrder();
}