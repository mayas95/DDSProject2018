package com.dao;

import com.model.CustomerOrder;

import java.io.IOException;
import java.util.List;

public interface CustomerOrderDao {

	void addCustomerOrder(CustomerOrder customerOrder);

	List<CustomerOrder> getAllCustomerOrders();

    CustomerOrder getCustomerOrderByCustomerOrderId(String customerOrderId);

	CustomerOrder validate(String customerOrderId) throws IOException;

	void update(CustomerOrder customerOrder)throws IOException;
}
