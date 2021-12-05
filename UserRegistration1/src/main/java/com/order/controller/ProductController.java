package com.order.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.order.model.AddPolicy;
import com.order.model.Agent;
import com.order.repo.AgentRepository;
import com.order.service.Productimplementation;



@Controller
public class ProductController {

	@Autowired
	private Productimplementation productImplementation;
	
	@Autowired
	private AgentRepository arepo;
	
	
	
	
	@GetMapping("/homeproduct")
	public String getHome(Model model) {
		List<AddPolicy> listProducts=productImplementation.getProducts();
		model.addAttribute("listProducts", listProducts);
		return "products";
	}
	
	@GetMapping("/homeproductunderwritter")
	public String getHomeUnderWritter(Model model) {
		List<AddPolicy> listProducts=productImplementation.getProducts();
		model.addAttribute("listProducts", listProducts);
		return "underwritter_products";
	}
	
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		AddPolicy p=new AddPolicy();
		model.addAttribute("policy", p);
		return "new_product";
	}
	
	@RequestMapping("/newunderwritter")
	public String showNewProductFormUnderWritter(Model model) {
		AddPolicy p=new AddPolicy();
		model.addAttribute("policy", p);
		return "productunderwritter";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveNewProduct(@ModelAttribute("product") AddPolicy product,HttpSession session,ModelMap modelMap) {
		
		Integer id = Integer.parseInt(product.getAgency_code());
		Agent auser = arepo.findByToken(id);
		if(auser!=null)
		{
				productImplementation.saveProducts(product);
				session.setAttribute("username",product.getPremium());
				return "dummy";
			
		}
		else
		{
			modelMap.put("error", "Invalid Agency Code");
			return "new_product";
		}
		
		
		
	}
	
	
	@RequestMapping(value="/saveunderwritter",method=RequestMethod.POST)
	public String saveNewProductUnderwritter(@ModelAttribute("product") AddPolicy product,HttpSession session,ModelMap modelMap) {
		
		
		
				productImplementation.saveProducts(product);
				session.setAttribute("username",product.getPremium());
				return "underwritter_policy";
			
		
		
		
	}
	
	
	@RequestMapping("/{id}")
	public ModelAndView EditProduct(@PathVariable(name="id") int id) {
		ModelAndView mav=new ModelAndView("edit_product");
		AddPolicy product= productImplementation.getProduct(id);
		mav.addObject("product",product);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String DeleteProduct(@PathVariable(name="id") int id) {
		productImplementation.deleteProductById(id);
		return "redirect:/homeproduct";
	}
	
	
}
