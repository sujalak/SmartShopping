package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.CategoryDao;
import com.niit.Dao.ProductDao;
import com.niit.Dao.SupplierDao;
import com.niit.Model.Category;
import com.niit.Model.Product;
import com.niit.Model.Supplier;

@Controller
@RequestMapping("/Admin")
public class AdminController {
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

	
	
	@RequestMapping("/Manage")
	public ModelAndView showAdmin() {
		
		ModelAndView mv = new ModelAndView("Admin");
		
		System.out.println("in admin");
		mv.addObject("product", product);
		mv.addObject("productList", productDao.listProduct());
		mv.addObject("category", category);
		mv.addObject("categoryList", categoryDao.listCategories());
		mv.addObject("supplier", supplier);
		mv.addObject("supplierList", supplierDao.listSupplier());
	
		return mv;
	}

		
	
	
	
}
