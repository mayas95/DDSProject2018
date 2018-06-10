package com.controller;

import com.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Cart;
import com.model.Customer;
import com.model.CustomerOrder;
import com.service.CartService;
import com.service.CustomerOrderService;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

	@Autowired
	private CartService cartService;

	@Autowired
	private CustomerOrderService customerOrderService;

	@RequestMapping("/order/{cartId}")
	public String createOrder(@PathVariable("cartId") String cartId) {

		CustomerOrder customerOrder = new CustomerOrder();

		Cart cart = cartService.getCartByCartId(cartId);
		final List<Product> products = new ArrayList<Product>();
		cart.getCartItem().forEach((ci)-> {
			products.add(ci.getProduct());
		});

		// Update CartId for customerOrder - set CartId
		customerOrder.setProduct(products);

		customerOrder.setTotalPrice(cart.getTotalPrice());

		Customer customer = cart.getCustomer();

		customerOrder.setCustomer(customer);
		// Set customerid
		// Set ShippingAddressId
		customerOrder.setShippingAddress(customer.getShippingAddress());

		customerOrder.setBillingAddress(customer.getBillingAddress());

		customerOrderService.addCustomerOrder(customerOrder);

		return "redirect:/checkout?cartId=" + cartId;
	}

	//		Normal ProductList view
	@RequestMapping("/ordersManagement") public ModelAndView getAllOrders() {
		List<CustomerOrder> customerOrders = customerOrderService.getAllOrders(); return new
				ModelAndView("customerOrderList", "customerOrders", customerOrders);
	}

}
