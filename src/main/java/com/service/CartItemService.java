package com.service;

import com.model.Cart;
import com.model.CartItem;
import org.springframework.security.core.userdetails.User;

public interface CartItemService {

	void addCartItem(String productId, User user);
	void removeCartItem(String CartItemId);
	void removeAllCartItems(Cart cart);
}
