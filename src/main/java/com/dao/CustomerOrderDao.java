package com.dao;

import com.model.CustomerOrder;
import java.util.List;

public interface CustomerOrderDao {

	void addCustomerOrder(CustomerOrder customerOrder);

	List<CustomerOrder> getAllCustomerOrders();
}
