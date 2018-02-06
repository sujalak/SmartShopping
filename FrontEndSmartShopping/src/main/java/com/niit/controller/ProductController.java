package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Dao.ProductDao;
import com.niit.Model.Product;

public class ProductController {
	@Autowired
	private ProductDao productDao;
	

//Storing product data
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public  String insertProduct(@ModelAttribute("product") Product mproduct,BindingResult result,Model model) {
		
		
		if(productDao.insertProduct(mproduct)==true)
		{
			
			model.addAttribute("msg", "Successfully created/updated the caetgory");
		} else {
					model.addAttribute("msg", "not able created/updated the caetgory");
				}
			
		model.addAttribute("product", mproduct);
		model.addAttribute("productist", productDao.listProduct());
		model.addAttribute("isAdminClickedProduct", "true");
		
		return "/product";
		
		
		
		
	}
	
}
