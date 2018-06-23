package com.service;

import com.model.CustomerOrder;
import com.model.OrderState;

import java.util.List;

public interface CustomerOrderService {

	CustomerOrder createCustomerOrder(String cartId);

	void addCustomerOrder(CustomerOrder customerOrder);
	double getCustomerOrderGrandTotal(String cartId);
	public List<CustomerOrder> getAllOrders ();
	public CustomerOrder getCustomerOrderByCustomerOrderId(String CustomerOrderId) ;
}
