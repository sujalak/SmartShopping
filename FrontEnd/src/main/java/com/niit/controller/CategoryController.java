package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Dao.CategoryDao;
import com.niit.Model.Category;
@Controller
public class CategoryController {
	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private Category category;
	
	
	@ModelAttribute("category")
	public Category defaultInstance() {
		Category category = new Category();
	  
	    return  category;
	}
	
	

	@RequestMapping(value = "/categoryAdd", method = RequestMethod.POST)
	public String insertCategory(@ModelAttribute("category") Category mcategory,BindingResult result, Model model) {
		System.out.println("category add");
		if(result.hasErrors()) {
			return"redirect:home";
		}
		if (categoryDao.insertCategory(mcategory) == true) {
			
			model.addAttribute("msg", "Successfully created/updated the caetgory");
		} else {
			model.addAttribute("msg", "not able created/updated the caetgory");
		}
		model.addAttribute("category", mcategory);
		model.addAttribute("categoryList", categoryDao.listCategories());
		model.addAttribute("isAdminClickedCategories", "true");
		
		return "redirect:Admin";
	}
	
	
	@RequestMapping("categoryEdit/{cid}")
	public String editCategory(@PathVariable("cid") String id, Model model) {
		System.out.println("editCategory");
		model.addAttribute("category", this.categoryDao.getCategoryByID(id));
		model.addAttribute("listCategory", this.categoryDao.listCategories());
		return "category";
	}
	
	@RequestMapping("categoryDelete/{cid}")
	public String deleteCategory(@PathVariable("cid") String id, Model model) {
		
		try {
			categoryDao.deleteCategory(id);
			model.addAttribute("message", "Successfully deleted");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		return "category";
	}
	
}



