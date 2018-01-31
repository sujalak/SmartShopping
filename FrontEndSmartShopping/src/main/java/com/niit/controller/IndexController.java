package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public ModelAndView showHome(){
		ModelAndView mv =new ModelAndView("/home");
		mv.addObject("msg","welcome ");
		return mv;
	}
	@RequestMapping("/Login")
	public ModelAndView showLogin(){
		ModelAndView mv =new ModelAndView("/home");
		mv.addObject("isUserClickedLogin","true");
		return mv;
	}
	
}
