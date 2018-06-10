package com.service;

import com.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {

	void addCustomerOrder(CustomerOrder customerOrder);
	double getCustomerOrderGrandTotal(String cartId);
	public List<CustomerOrder> getAllOrders ();
}
