package com.niit.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.CartDao;
import com.niit.Dao.CategoryDao;
import com.niit.Dao.ProductDao;
import com.niit.Dao.SupplierDao;
import com.niit.Model.Cart;
import com.niit.Model.Category;
import com.niit.Model.Product;
import com.niit.Model.Supplier;
@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartDao cartDao;

	@Autowired
	private Cart cart;
	
	@Autowired
	private ProductDao productDao;

	
	@Autowired
private	Product product;
	
	@RequestMapping("/show")
	public ModelAndView showCart() {
		ModelAndView mv = new ModelAndView("cart");
		mv.addObject("isUserClickedShowCart", "true");
		return mv;
	}
	@RequestMapping(value = "/Add/{pid}", method = RequestMethod.GET)
	public String addToCart(@PathVariable("pid") String id, HttpServletRequest request ,Principal principal)
	{
		try
		{
		
		Product product=productDao.getProductByID(id);
		
		Cart cart=new Cart();   		
		cart.setPrice(product.getPrice());
		cart.setP_id(product.getPid());
		cart.setP_name(product.getPname());
		cart.setQuantity(1);
		cart.setU_id(principal.getName());
		cart.setStatus("N");
		
		cartDao.insertCart(cart);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return "redirect:/";
		
		
		
	}
	
}
