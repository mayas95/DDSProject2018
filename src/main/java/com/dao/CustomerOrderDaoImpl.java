package com.dao;

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

	public void addCustomerOrder(CustomerOrder customerOrder) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(customerOrder);
		session.flush();
		session.close();
	}

	public List<CustomerOrder> getAllCustomerOrders() {
		Session session = sessionFactory.openSession();
		List<CustomerOrder> customerOrderList = session.createQuery("from CustomerOrder").list();

		return customerOrderList;
	}

}
