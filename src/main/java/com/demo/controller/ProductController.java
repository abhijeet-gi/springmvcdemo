package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.bean.Product;
import com.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/viewproduct")
	public ModelAndView DisplayProduct()
	{
		List<Product> plist=productService.getallProduct();
		return new ModelAndView("displayProduct", "plist",plist);
	}
	
	@RequestMapping("/EditProduct/{id}")
	public ModelAndView editProduct(@PathVariable("id")int id) {
		
		Product p=productService.getProductById(id);
		
		return new ModelAndView ("editProduct","product",p);
	}
	
	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
	public ModelAndView updateProduct(@RequestParam("proid")int id,@RequestParam("pro")String name,@RequestParam("price")double price) {
		Product p=new Product(id,name,price);
		int n=productService.update(p);
		if(n>0) {
			//String s="updated";
			return new ModelAndView("redirect:/viewproduct");
		}
		
		return null;
	}
	
	@RequestMapping("DeleteProduct/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") int id) {
		int n=productService.deleteProduct(id);
		
		if(n>0) {
			
			return new ModelAndView("redirect:/viewproduct");
		}
		
		return null;
		
}
	
	@RequestMapping("/showform")
	public ModelAndView show() {
		
		return new ModelAndView("AddProduct");
	}
	
	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public ModelAndView addProduct(@RequestParam("proid")int id,@RequestParam("pro")String name,@RequestParam("price")double price) {
		
		Product p=new Product(id,name,price);
		int n=productService.addProduct(p);
		return new ModelAndView("redirect:/viewproduct");
	}
}