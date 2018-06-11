package com.service;

import com.model.CustomerOrder;
import com.model.CustomerOrderItem;

public interface CustomerOrderItemService {

	void addCustomerOrderItem(CustomerOrderItem customerOrderItem);
	void removeCustomerOrderItem(String customerOrderId);
	void removeAllCustomerOrderItems(CustomerOrder CustomerOrder);
}
