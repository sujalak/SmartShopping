package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Dao.CategoryDao;
import com.niit.Model.Category;

public class CategoryController {
	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private Category category;
	
	
	public String listCategories(Model model) {
		
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDao.listCategories());
		model.addAttribute("isAdminClickedCategories", "true");
	
		return "/home";
	}
	
	

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category, Model model) {
		
		if (categoryDao.insertCategory(category) == true) {
			
			model.addAttribute("msg", "Successfully created/updated the caetgory");
		} else {
			model.addAttribute("msg", "not able created/updated the caetgory");
		}
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDao.listCategories());
		model.addAttribute("isAdminClickedCategories", "true");
		
		return "/category";
	}


}
