package com.niit.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.niit.Model.Order;

public interface OrderDao {
	public List<Order>listOrder();

	// create cart

	public boolean insertOrder(Order cart);

	

	
	// delete cart by id

	public boolean deleteOrder(String id);

	// delete cart by cart

	

	// get cart by id

	public Order getOrderByID(String id);

	// get cart by name
	
	 public List<Order> userOrderList(String uname);

}
