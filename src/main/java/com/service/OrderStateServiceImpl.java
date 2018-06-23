package com.service;

import com.model.CustomerOrder;
import com.model.OrderState;

import java.math.BigDecimal;
import java.text.MessageFormat;

public abstract class OrderStateServiceImpl implements OrderStateService {

    private CustomerOrder customerOrder;

    public OrderStateServiceImpl(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    CustomerOrderService customerOrderService;

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }




    @Override
    public void verificateOrder() {
        throw new IllegalStateException(MessageFormat.format("La compra en estado {0} no puede verificarse", customerOrder.getOrderState().getClass().getSimpleName()));
    }

    @Override
    public void cancelOrder() {
        throw new IllegalStateException(MessageFormat.format("La compra en estado {0} no puede cancelarse", customerOrder.getOrderState().getClass().getSimpleName()));
    }

    @Override
    public void sendOrder() {
        throw new IllegalStateException(MessageFormat.format("La compra en estado {0} no puede enviarse", customerOrder.getOrderState().getClass().getSimpleName()));
    }
}
