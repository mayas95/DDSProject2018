package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

public class OrderVerificatedState implements OrderState{

    private static final long serialVersionUID = 8436097833452420298L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String orderCreatedStateId;

    @OneToOne
    @JoinColumn(name = "customerOrderId")
    @JsonIgnore
    private CustomerOrder customerOrder;
}
