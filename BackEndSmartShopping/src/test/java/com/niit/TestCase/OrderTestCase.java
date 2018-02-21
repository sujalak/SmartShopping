package com.niit.TestCase;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.OrderDao;
import com.niit.Model.Order;

public class OrderTestCase {

	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Order order;

	@Autowired
	private static OrderDao orderDao;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		order = (Order) context.getBean("order");
		orderDao = (OrderDao) context.getBean("orderDao");

	}

	@Test
	public void insertCartTestCase() {
		order.setAddress("mysore");
		order.setCity("mysore");
		order.setPin("98756");
		order.setState("KAR");
		order.setTotalBill(800.0f);
		order.setU_id("hh@gmail.com");
		System.out.println("ordertestcase");
		boolean flag = orderDao.insertOrder(order);

		Assert.assertEquals("insertCartTestCase", true, flag);

	}

}

