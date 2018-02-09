package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.ProductDao;
import com.niit.Model.Product;
@Controller
public class ProductController {
	@Autowired
	private ProductDao productDao;
	 private static final String UPLOAD_DIRECTORY ="/WEB-INF/images";  

//Storing product data
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public  String insertProduct(@ModelAttribute("product") Product mproduct,BindingResult result,Model model, @RequestParam CommonsMultipartFile file,HttpSession session) {
	try{	
		ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(UPLOAD_DIRECTORY);  
	    String filename = file.getOriginalFilename();  
	  
	    System.out.println(path+" "+filename);        
	  
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream( new File(path + File.separator + filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();
	    System.out.println("uploaded");
	          
	     }catch(Exception e)
	       {System.out.println(e);}  
	     
	    
		if(productDao.insertProduct(mproduct)==true)
		{
			
			model.addAttribute("msg", "Successfully created/updated the product");
		} else {
					model.addAttribute("msg", "not able created/updated the product");
				}
			
		model.addAttribute("product", mproduct);
		model.addAttribute("productist", productDao.listProduct());
		model.addAttribute("isAdminClickedProduct", "true");
		
		return "redirect:Admin";
		
		
		
		
	}
	
}
