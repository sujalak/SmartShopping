package com.niit.Dao;

import java.util.List;

import com.niit.Model.Cart;

public interface CartDao {
	public List<Cart>listCart();

	// create cart

	public boolean insertCart(Cart cart);

	

	
	// delete cart by id

	public boolean deleteCart(String id);

	// delete cart by cart

	

	// get cart by id

	public Cart getCartByID(String id);

	// get cart by name
	
	 public List<Cart> userCartList(String uname);
}
