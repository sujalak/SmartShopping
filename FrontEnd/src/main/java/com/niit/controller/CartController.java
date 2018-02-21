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
import com.niit.Dao.OrderDao;
import com.niit.Dao.ProductDao;
import com.niit.Dao.SupplierDao;
import com.niit.Model.Cart;
import com.niit.Model.Category;
import com.niit.Model.Order;
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
	private OrderDao orderDao;

	@Autowired
	private Order order;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;

	@Autowired
	private Product product;

	@RequestMapping("/checkout")
	public ModelAndView showCart() {
		ModelAndView mv = new ModelAndView("checkout");
		mv.addObject("isUserClickedCheckOut", "true");
		return mv;
	}

	@RequestMapping(value = "/Add/{pid}", method = RequestMethod.GET)
	public String addToCart(@PathVariable("pid") String id, HttpServletRequest request, Principal principal) {
		try {

			Product product = productDao.getProductByID(id);

			Cart cart = new Cart();
			cart.setPrice(product.getPrice());
			cart.setP_id(product.getPid());
			cart.setP_name(product.getPname());
			cart.setQuantity(1);
			cart.setU_id(principal.getName());
			cart.setStatus("N");

			cartDao.insertCart(cart);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/";

	}

	@RequestMapping(value = "/Delete/{pid}", method = RequestMethod.GET)
	public String deleteCart(@PathVariable("pid") String id, HttpServletRequest request, Principal principal) {
		try {

			cartDao.deleteCart(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/";

	}

	@RequestMapping(value = "/myCart", method = RequestMethod.GET)
	public String myCart(Model model, Principal principal) {
		try {
			model.addAttribute("cart", new Cart());
			model.addAttribute("cartList", this.cartDao.userCartList(principal.getName()));
			model.addAttribute("category", new Category());
			model.addAttribute("categoryList", this.categoryDao.listCategories());
			model.addAttribute("displayCart", "true");

			int i, j = 0;
			float s = 0;
			int n = cartDao.userCartList(principal.getName()).size();
			System.out.println(n);
			for (i = 0; i < n; i++) {
				s = s + cartDao.userCartList(principal.getName()).get(i).getPrice();
			}
			System.out.print(s);
			model.addAttribute("sum", s);

		} catch (Exception ex) {
			System.out.println("ex.getMessage");
		}
		return "cart";

	}

	@RequestMapping(value = "/invoice/{sum}", method = RequestMethod.GET)
	public String addtoOrder(@PathVariable("sum") float total, @ModelAttribute("order") Order norder,
			HttpServletRequest request, Principal principal, Model model) {

		norder.setTotalBill(total);
		norder.setU_id(principal.getName());
		if (orderDao.insertOrder(norder) == true) {

			model.addAttribute("msg", "Successfully created/updated the caetgory");
		} else {
			model.addAttribute("msg", "not able created/updated the caetgory");
		}

		model.addAttribute("order", norder);

		return "redirect:invoice";

	}

}


