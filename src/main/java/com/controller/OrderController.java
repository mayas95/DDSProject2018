package com.controller;

import com.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.CartService;
import com.service.CustomerOrderService;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {


	@Autowired
	private CustomerOrderService customerOrderService;

	@RequestMapping("/order/{cartId}")
	public String createOrder(@PathVariable("cartId") String cartId) {
		CustomerOrder customerOrder = customerOrderService.createCustomerOrder(cartId);
		return "redirect:/checkout?customerOrderId=" + customerOrder.getCustomerOrderId();
	}

	//		Normal ProductList view
	@RequestMapping("/ordersManagement") public ModelAndView getAllOrders() {
		List<CustomerOrder> customerOrders = customerOrderService.getAllOrders(); return new
				ModelAndView("customerOrderList", "customerOrders", customerOrders);
	}

}
