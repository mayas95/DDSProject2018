package com.dao;

import com.model.CustomerOrder;
import com.model.CustomerOrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerOrderItemDaoImpl implements CustomerOrderItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addCustomerOrderItem(CustomerOrderItem customerOrderItem){
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(customerOrderItem);
		session.flush();
		session.close();
	}

	public void removeCustomerOrderItem(String CustomerOrderItemId) {
		Session session = sessionFactory.openSession();
		CustomerOrderItem customerOrderItem = (CustomerOrderItem) session.get(CustomerOrderItem.class, CustomerOrderItemId);
		session.delete(customerOrderItem);
		CustomerOrder customerOrder = customerOrderItem.getCustomerOrder();
		List<CustomerOrderItem> customerOrderItems = customerOrder.getCustomerOrderItem();
		customerOrderItems.remove(customerOrderItem);
		session.flush();
		session.close();
	}

	public void removeAllCustomerOrderItems(CustomerOrder customerOrder) {
		List<CustomerOrderItem> CustomerOrderItems = customerOrder.getCustomerOrderItem();
		for (CustomerOrderItem customerOrderItem : CustomerOrderItems) {
			removeCustomerOrderItem(customerOrderItem.getCustomerOrderItemId());
		}
	}

}
