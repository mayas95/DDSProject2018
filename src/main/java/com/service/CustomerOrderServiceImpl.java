package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.CustomerOrderItemDao;
import com.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerOrderDao;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private CartService cartService;

	@Autowired
	private CustomerOrderDao customerOrderDao;
	@Autowired
	private CustomerOrderItemDao customerOrderItemDao;

	@Override
	public CustomerOrder createCustomerOrder(String cartId) {
		CustomerOrder customerOrder = new CustomerOrder();

		Cart cart = cartService.getCartByCartId(cartId);

		customerOrder.setTotalPrice(totalPrice(cart));

		Customer customer = cart.getCustomer();

		customerOrder.setCustomer(customer);
		// Set customerid
		// Set ShippingAddressId
		customerOrder.setShippingAddress(customer.getShippingAddress());

		customerOrder.setBillingAddress(customer.getBillingAddress());

		customerOrderDao.addCustomerOrder(customerOrder);

		final List<CustomerOrderItem> products = new ArrayList<CustomerOrderItem>();
		cart.getCartItem().forEach((ci)-> {
			CustomerOrderItem itemOrder = new CustomerOrderItem();
			itemOrder.setProduct(ci.getProduct());
			itemOrder.setQuality(ci.getQuality());
			itemOrder.setPrice(ci.getPrice());
			itemOrder.setCustomerOrder(customerOrder);
			products.add(itemOrder);
			customerOrderItemDao.addCustomerOrderItem(itemOrder);

		});
		customerOrder.setOrderState(OrderStateFactoryService.State.CREADA);
		customerOrder.setCustomerOrderItem(products);
		return customerOrder;
	}

	public void addCustomerOrder(CustomerOrder customerOrder) {

	}



	public double getCustomerOrderGrandTotal(String customerOrderId) {
		double grandTotal=0;
		CustomerOrder customerOrder = getCustomerOrderByCustomerOrderId(customerOrderId);
		List<CustomerOrderItem> customerOrderItems = customerOrder.getCustomerOrderItem();
		
		for(CustomerOrderItem item: customerOrderItems){
			grandTotal += item.getPrice();
		}
		return grandTotal;
	}

	public List<CustomerOrder> getAllOrders() {
		return customerOrderDao.getAllCustomerOrders();
	}

	public CustomerOrder getCustomerOrderByCustomerOrderId(String CustomerOrderId) {

		return customerOrderDao.getCustomerOrderByCustomerOrderId(CustomerOrderId);
	}


	public CustomerOrderDao getCustomerOrderDao() {
		return customerOrderDao;
	}

	public void setCustomerOrderDao(CustomerOrderDao customerOrderDao) {
		this.customerOrderDao = customerOrderDao;
	}

	private double totalPrice(Cart cart) {
		double price = cart.getCartItem().stream().mapToDouble(CartItem::getPrice).sum();
		return price;
	}
}
