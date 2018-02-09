package com.niit.TestCase;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.UserDao;
import com.niit.DaoImpl.UserDaoImpl;
import com.niit.Model.User;
import com.niit.config.HibernateConfig;

import junit.framework.TestCase;

public class UserTestCase {
	@Autowired
	private static User user;
	
	@Autowired
	private static UserDao userDao;

	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
		context.scan("com.niit"); 
		context.refresh();
		
       user=(User)context.getBean("user");
		
		
		userDao = (UserDao)context.getBean("userDao");
		System.out.println("init");
	}
	
	@Test
	public void insertUserTestCase()
	{
	   
		 user.setEmail("xyz@gmail.com");
		 user.setName("xyz");
		 user.setAddress("mumbai");
		 user.setPassword("niit@123");
		 user.setPhone("69865422");
		 user.setRole("ROLE_USER");
		 boolean flag=userDao.save(user);
		
		 System.out.println("db connected");
		 Assert.assertEquals( "insertUserTestCase" ,true, flag);
		
		
	}
	}


