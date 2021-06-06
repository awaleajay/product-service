package com.edusol.ProductDB.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.ProductDB.ProductService.ProductService;
import com.edusol.ProductDB.model.ProductDB;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/product")

public class ProductController {
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ProductService productservice;
	
	@GetMapping("/get-Product")
	public Object getProducts() {
		@SuppressWarnings("Unchecked")
		List<ProductDB> product = (List<ProductDB>) productservice.getProducts();
		
		logger.info(product.toString());
		return product;
	}
	
	
	@PostMapping("/add-product")
	@SuppressWarnings("Unchecked")
	public Object addProduct(@RequestBody ProductDB product) {
		logger.info(product.toString()+"Product added");
		return productservice.addProduct(product);
		
	}
	@GetMapping("/get-product-byid")
	public Object getProductById(@RequestParam int id) {
		List<ProductDB> product = (List<ProductDB>) productservice.getProductById(id);
		logger.info(product.toString());
		return product;
	}
	@GetMapping("/get-product-byprice")
	@SuppressWarnings("Unchecked")
	public Object getProductById(@RequestParam String category) {
		
		List<ProductDB> product = (List<ProductDB>) productservice.getProductByCategory(category);
		logger.info(product.toString());
		return product;
	}
	
	
	
	@PutMapping("/update-product-byprice")
	@SuppressWarnings("Unchecked")
	public Object updateProductByPrice(@RequestBody ProductDB product) {
		
		logger.info("product ton be updated by price");
		return  productservice.updateProductByPrice(product);
	}
	@DeleteMapping("/delete-product")
	public Object deleteProduct(@RequestParam int id) {
		return productservice.deleteProduct(id);
	}
	@GetMapping("/get-product-by-price-renge")
	public Object getProductByPriceRenge(@RequestParam float price1,float price2) {
		return productservice.getProductByPriceRenge(price1,price2);
	}
	
	@GetMapping("/get-product-by-price-renge-category")
	public Object getProductByPriceRenge(@RequestParam float price1,float price2,String category) {
		return productservice.getProductByPriceRengeCategory(price1,price2,category);
	}
	
	

}
