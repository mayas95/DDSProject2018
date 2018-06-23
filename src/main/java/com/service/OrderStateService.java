package com.service;

import com.model.CustomerOrder;
import com.model.OrderState;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;

public interface OrderStateService {


    //void buyOrder(BigDecimal price, PaymentMethod paymentMethod, ShippingMethod  shippingMethod );
    void verificateOrder();
    void cancelOrder();
    void sendOrder();
    static OrderState getOrderStateInCreatedState(CustomerOrder customerOrder) {
        throw new IllegalStateException();
    }


}
