package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.CartDao;
import com.niit.Dao.CategoryDao;
import com.niit.Model.Cart;
import com.niit.Model.Category;
@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartDao cartDao;

	@Autowired
	private Cart cart;
	@RequestMapping("/show")
	public ModelAndView showCart() {
		ModelAndView mv = new ModelAndView("cart");
		mv.addObject("isUserClickedShowCart", "true");
		return mv;
	}
	@RequestMapping("/Add")
	
		public String addCart(@ModelAttribute("cart") Cart mcart,BindingResult result, Model model) {
			System.out.println("cart add");
			if(result.hasErrors()) {
				return"redirect:home";
			}
			if (cartDao.insertCart(mcart) == true) {
				
				model.addAttribute("msg", "Successfully created/updated the caetgory");
			} else {
				model.addAttribute("msg", "not able created/updated the caetgory");
			}
			model.addAttribute("cart", mcart);
			model.addAttribute("cartList", cartDao.listCart());
			
		model.addAttribute("isUserClickedShowCart", "true");
		return "redirect:home";
	}
}
