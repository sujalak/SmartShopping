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

import com.niit.Dao.CategoryDao;
import com.niit.Dao.ProductDao;
import com.niit.Dao.SupplierDao;
import com.niit.Model.Category;
import com.niit.Model.Product;
import com.niit.Model.Supplier;
@Controller
public class ProductController {
	@Autowired
	private ProductDao productDao;
	private CategoryDao categoryDao;
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDAO;
	
	@Autowired
	SupplierDao supplierDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	Product product;
	
	 private static final String UPLOAD_DIRECTORY ="/WEB-INF/images";  

//Storing product data
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public  String insertProduct(@ModelAttribute("product") Product mproduct,BindingResult result,Model model, @RequestParam CommonsMultipartFile file,HttpSession session) {
	
		 category=categoryDao.getCategoryByName(mproduct.getCategory().getCname());
		categoryDao.insertCategory(category);
		
		 supplier=supplierDAO.getSupplierByName(mproduct.getSupplier().getSupplierName());
		supplierDAO.insertSupp(supplier);
		
mproduct.setSupplier_id(supplier.getSid());
mproduct.setCategory_id(category.getCid());

		mproduct.setCategory(category);
		mproduct.setSupplier(supplier);
		
	
	

		if(productDao.insertProduct(mproduct)==true)
		{
			
			System.out.println("product insrted");
			model.addAttribute("msg", "Successfully created/updated the product");
		} else {
					model.addAttribute("msg", "not able created/updated the product");
				}
			
		model.addAttribute("product", mproduct);
		model.addAttribute("isAdminClickedProduct", "true");
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
	     
	    
		
		
		return "redirect:Admin";
		
		
		
		
	}
	
}
