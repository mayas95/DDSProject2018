package com.service;

import com.dao.CustomerOrderItemDao;
import com.model.CustomerOrder;
import com.model.CustomerOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderItemServiceImpl implements CustomerOrderItemService {

	@Autowired
	private CustomerOrderItemDao customerOrderItemDao;

	public CustomerOrderItemDao getCartItemDao() {
		return customerOrderItemDao;
	}

	public void setCustomerOrderItemDao(CustomerOrderItemDao customerOrderItemDao) {
		this.customerOrderItemDao = customerOrderItemDao;
	}

	public void addCustomerOrderItem(CustomerOrderItem customerOrderItem) {
		customerOrderItemDao.addCustomerOrderItem(customerOrderItem);

	}

	public void removeCustomerOrderItem(String customerOrderItemId) {
		customerOrderItemDao.removeCustomerOrderItem(customerOrderItemId);
	}

	public void removeAllCustomerOrderItems(CustomerOrder customerOrder) {
		customerOrderItemDao.removeAllCustomerOrderItems(customerOrder);
	}

}
