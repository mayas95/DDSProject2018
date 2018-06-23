package com.service;

import com.model.CustomerOrder;
import com.model.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.service.OrderStateFactoryService.State;

public class OrderVerificatedStateServiceImpl extends OrderStateServiceImpl{

    public OrderVerificatedStateServiceImpl(CustomerOrder customerOrder) {
        super(customerOrder);
    }

    @Override
    public void sendOrder() {
        getCustomerOrder().setOrderState(State.ENVIADA);
    }
}
