package com.service;

import com.model.CustomerOrder;

import java.math.BigDecimal;

import com.model.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.service.OrderStateFactoryService.State;

public class OrderCreatedStateServiceImpl extends OrderStateServiceImpl {


        public OrderCreatedStateServiceImpl(CustomerOrder customerOrder) {
            super(customerOrder);
        }

    @Override
        public void cancelOrder() {
            getCustomerOrder().setOrderState(State.CANCELADA);
        }

}
