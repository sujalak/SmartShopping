package com.niit.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.CategoryDao;
import com.niit.Dao.ProductDao;
import com.niit.Dao.SupplierDao;
import com.niit.Dao.UserDao;
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
	private UserDao userDao;
	@Autowired
	private HttpSession session;

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView onLoad() {

		/**
		 * Category list will load and set to session
		 * 
		 * @param session
		 * @return
		 */

		ModelAndView mv = new ModelAndView("home");
		session.setAttribute("category", category); // domain object names
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);

		session.setAttribute("categoryList", categoryDao.listCategories());

		session.setAttribute("supplierList", supplierDao.listSupplier());

		session.setAttribute("productList", productDao.listProduct());

		return mv;
	}

	

	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="error", required = false)	String error,
			@RequestParam(name="logout", required = false) String logout) {
		ModelAndView mv= new ModelAndView("login");
		mv.addObject("title", "Login");
		if(error!=null) {
			mv.addObject("message", "Username and Password is invalid!");
		}
		if(logout!=null) {
			mv.addObject("logout", "You have logged out successfully!");
		}
		return mv;
	}
	
	
	

	@RequestMapping("/register")
	public ModelAndView showRegister() {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("isUserClickedRegister", "true");
		return mv;
	}

	// Storing supplier data
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String insertUser(@Valid @ModelAttribute("user") User muser, BindingResult result, Model model) {

		user.setRole("ROLE_USER");

		if (userDao.save(muser) == true) {

			model.addAttribute("msg", "Successfully created/updated the User");
			model.addAttribute("msg", "Successfully User created");
		} else {
			model.addAttribute("msg", "not able created/updated the User");
		}

		model.addAttribute("user", muser);
		// model.addAttribute("userist", userDao.listSupplier());

		return "redirect:home";

	}
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");		
		mv.addObject("errorTitle", "Aha! Caught You.");		
		mv.addObject("errorDescription", "You are not authorized to view this page!");		
		mv.addObject("title", "403 Access Denied");		
		return mv;
	}	

}
