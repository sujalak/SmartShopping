package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.CategoryDao;
import com.niit.Dao.ProductDao;
import com.niit.Dao.SupplierDao;
import com.niit.Model.Category;
import com.niit.Model.Product;
import com.niit.Model.Supplier;
import com.niit.Model.User;

@Controller
public class IndexController {
	@Autowired
	User user;

	@Autowired
	private Product product;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Category category;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	@Autowired
	private ProductDao productDao;

	@Autowired
	private HttpSession session;

	
	@RequestMapping("/")
	public ModelAndView onLoad() {
		
		/**
		 * Category list will load and set to session
		 * 
		 * @param session
		 * @return
		 */
		
		ModelAndView mv = new ModelAndView("/home");
		session.setAttribute("category", category); // domain object names
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);
		
		
		session.setAttribute("categoryList", categoryDao.listCategories());
		
		session.setAttribute("supplierList", supplierDao.listSupplier());
		
		session.setAttribute("productList", productDao.listProduct());
	



		
		return mv;
	}
	@RequestMapping("/Login")
	public ModelAndView showLogin(){
		ModelAndView mv =new ModelAndView("/home");
		mv.addObject("isUserClickedLogin","true");
		return mv;
	}
	@RequestMapping("/Admin")
	public ModelAndView showAdmin(){
		ModelAndView mv =new ModelAndView("/Admin");
		mv.addObject("isUserClickedLogin","true");
		return mv;
	}
	
}
