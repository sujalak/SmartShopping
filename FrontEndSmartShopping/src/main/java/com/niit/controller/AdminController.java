package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AdminController {
	@RequestMapping("/Admin")
	public ModelAndView showHome(){
		ModelAndView mv =new ModelAndView("/Admin");
		mv.addObject("msg","welcome ");
		return mv;
	}

}
