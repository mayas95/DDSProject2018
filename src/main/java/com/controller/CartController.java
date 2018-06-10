package com.controller;

import com.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.CartService;
import com.service.CustomerService;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartService cartService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}


	//		Normal ProductList view
	@RequestMapping("cart/getCartById") public ModelAndView getAllCartItems() {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String emailId = user.getUsername();
		Customer customer = customerService.getCustomerByemailId(emailId);
		//List<CartItem> carts = customer.getCart().getCartItem();
		Cart carts = customer.getCart();
		return new ModelAndView("cart", "carts", carts);
	}


	@RequestMapping("/cart/getCart/{cartId}")
	public @ResponseBody Cart getCartItems(@PathVariable(value="cartId")String cartId){
		return cartService.getCartByCartId(cartId);
	}




}
