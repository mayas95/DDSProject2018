package com.dao;
import java.io.IOException;

import com.service.CustomerOrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.CustomerOrder;

import java.util.List;

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CustomerOrderService customerOrderService;

	public void addCustomerOrder(CustomerOrder customerOrder) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(customerOrder);
		session.flush();
		session.close();
	}
	public CustomerOrder getCustomerOrderByCustomerOrderId(String CustomerOrderId) {
		Session session = sessionFactory.openSession();
		CustomerOrder customerOrder = (CustomerOrder) session.get(CustomerOrder.class, CustomerOrderId);
		// System.out.println(customerOrder.getCustomerOrderId() + " " + CustomerOrder.getCustomerOrderItem());
		System.out.println(customerOrder);
		session.close();
		return customerOrder;
	}
	public List<CustomerOrder> getAllCustomerOrders() {
		Session session = sessionFactory.openSession();
		List<CustomerOrder> customerOrderList = session.createQuery("from CustomerOrder").list();

		return customerOrderList;
	}
	public CustomerOrder validate(String customerOrderId) throws IOException {
		CustomerOrder customerOrder = getCustomerOrderByCustomerOrderId(customerOrderId);
		if (customerOrder == null || customerOrder.getCustomerOrderItem().size() == 0) {
			throw new IOException(customerOrderId + "");
		}
		update(customerOrder);
		return customerOrder;
	}

	public void update(CustomerOrder customerOrder) {

		String customerOrderId = customerOrder.getCustomerOrderId();
		double grandTotal = customerOrderService.getCustomerOrderGrandTotal(customerOrderId);
		customerOrder.setTotalPrice(grandTotal);

		Session session = sessionFactory.openSession();
		session.saveOrUpdate(customerOrder);
		session.flush();
		session.close();
	}



}
