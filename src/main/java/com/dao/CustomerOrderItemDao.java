package com.dao;

import com.model.CustomerOrder;
import com.model.CustomerOrderItem;

public interface CustomerOrderItemDao {

	void addCustomerOrderItem(CustomerOrderItem customerOrderItem);
	void removeCustomerOrderItem(String CustomerOrderItemId);
	void removeAllCustomerOrderItems(CustomerOrder customerOrder);

}
