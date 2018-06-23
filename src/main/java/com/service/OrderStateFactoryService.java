package com.service;

import com.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderStateFactoryService {

        @Autowired
        OrderCreatedStateServiceImpl orderCreatedStateService;

        @Autowired
        OrderCancelledStateServiceImpl orderCancelledStateService;

        @Autowired
        OrderVerificatedStateServiceImpl orderVerificatedStateService;

        public enum State {
            CREADA, EN_ESPERA, VERIFICADA, CANCELADA, ENVIADA
        }

        public static OrderState buildState(State state, CustomerOrder customerOrder) {
            OrderState orderState = null;
            OrderStateServiceImpl  orderStateService = null;
            switch (state) {
                case CREADA:
                    orderState = new OrderCreatedState();
                    orderStateService = new OrderCreatedStateServiceImpl(customerOrder);
                    break;
                case EN_ESPERA:
                    orderState = new OrderCreatedState();
                    orderStateService = new OrderCreatedStateServiceImpl(customerOrder);
                    break;
                case VERIFICADA:
                    orderState = new OrderVerificatedState();
                    orderStateService = new OrderVerificatedStateServiceImpl(customerOrder);
                    break;
                case CANCELADA:
                    orderState = new OrderCancelledState();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            return orderState;
        }

    public static OrderStateService buildStateService(State state, CustomerOrder customerOrder) {
        OrderStateServiceImpl  orderStateService = null;
        switch (state) {
            case CREADA:
                orderStateService = new OrderCreatedStateServiceImpl(customerOrder);
                break;
            case EN_ESPERA:
                orderStateService = new OrderCreatedStateServiceImpl(customerOrder);
                break;
            case VERIFICADA:
                orderStateService = new OrderVerificatedStateServiceImpl(customerOrder);
                break;
            case CANCELADA:
                orderStateService = new OrderCancelledStateServiceImpl(customerOrder);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return orderStateService;
    }

}
