package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.SupplierDao;
import com.niit.Model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	private SupplierDao supplierDao;
	
	/*@RequestMapping(value="/addSupplier", method=RequestMethod.GET)
	public ModelAndView showSupplier(){
		ModelAndView mv =new ModelAndView("/supplier");
		return mv;
		
		}*/
		
//Storing supplier data
	@RequestMapping(value="/supplier", method=RequestMethod.POST)
	public  String insertSupplier(@ModelAttribute("supplier") Supplier msupplier,BindingResult result,Model model) {
		
		
		if(supplierDao.insertSupp(msupplier)==true)
		{
			
			model.addAttribute("msg", "Successfully created/updated the caetgory");
		} else {
					model.addAttribute("msg", "not able created/updated the caetgory");
				}
			
		model.addAttribute("supplier", msupplier);
		model.addAttribute("supplierist", supplierDao.listSupplier());
		model.addAttribute("isAdminClickedSupplier", "true");
		
		return "/supplier";
		
		
		
		
	}
	
}
