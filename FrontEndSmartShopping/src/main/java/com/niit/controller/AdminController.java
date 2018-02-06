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

	
	//http://localhost:8080/ShoppingCart/manageCategories
	//<a href="/manageCategories">  </a>
	//id, name, description
	@RequestMapping("manageCategories")
	public ModelAndView categories() {
		
		ModelAndView mv = new ModelAndView("Admin");
		mv.addObject("category", category);
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("categoryList", categoryDao.listCategories());
		
		return mv;
	}

	//id, name price, category_id, supplier_id
	@RequestMapping("/manageProducts")
	public ModelAndView products() {
		
		ModelAndView mv = new ModelAndView("Admin");
		
		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("product", product);
		mv.addObject("productList", productDao.listProduct());
		mv.addObject("category", category);
		mv.addObject("categoryList", categoryDao.listCategories());
		mv.addObject("supplier", supplier);
		mv.addObject("supplierList", supplierDao.listSupplier());
	
		return mv;
	}

	//id, name, address
	@RequestMapping("/manageSuppliers")
	public ModelAndView suppliers() {
		
		ModelAndView mv = new ModelAndView("Admin");
		mv.addObject("supplier", supplier);
		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("supplierList", supplierDao.listSupplier());
		
		return mv;
	}
	
	
	
	
}
