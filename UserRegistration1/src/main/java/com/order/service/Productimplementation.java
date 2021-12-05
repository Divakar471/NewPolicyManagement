package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.model.AddPolicy;
import com.order.repo.ProductRepository;


@Component
public class Productimplementation {

	@Autowired
	private ProductRepository productRepository;
	
	public List<AddPolicy> getProducts(){
		return productRepository.findAll();
	}
	
	public void saveProducts(AddPolicy products ) {
		float result  = (Float.parseFloat(products.getPolicy_amount())*
				(Float.parseFloat(products.getPolicy_type())/100))*
				Float.parseFloat(products.getPolicy_term());
		products.setPremium(result);
		System.out.println(products.getPremium());
		productRepository.save(products);
	}
	
	public void deleteProductById(Integer id) {
		productRepository.deleteById(id);
	}
	
	public AddPolicy getProduct(Integer id) {
		return productRepository.findById(id).get();
	}
	
	
}
