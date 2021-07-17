package com.edusol.ProductDB.ProductService;

import java.util.List;

import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edusol.ProductDB.model.ProductDB;
import com.edusol.ProductDB.repository.ProductRepository;
import com.google.gson.JsonObject;

@Service
public class ProductService {

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ProductRepository ProductRepository;

	public Object getProducts() {
		// TODO Auto-generated method stub
		List<ProductDB> product = (List<ProductDB>) ProductRepository.findAll();
		logger.info(product.toString());
		return ProductRepository.findAll();
	}

	public Object addProduct(ProductDB product) {

		ProductRepository.save(product);
		logger.info("product save succesfull");
		return new ResponseEntity<>("product save succesfully", HttpStatus.CREATED);

	}

	public Object getProductById(int id) {

		return ProductRepository.findById(id);

	}

	public Object getProductByCategory(String category) {

		return ProductRepository.findByCategory(category);

	}

	public Object updateProductByPrice(ProductDB product) {
		JsonObject response = new JsonObject();
		int id = product.getId();
		try {
			ProductDB prod = ProductRepository.getOne(id);
			prod.setPrice(product.getPrice());
			ProductRepository.save(prod);
		} catch (Exception e) {
			logger.error(e.getMessage());
			 
			response.addProperty("status code", 404);
			response.addProperty("statysMeassage", e.getMessage());
			
			return new ResponseEntity<>(response.toString(), HttpStatus.NOT_FOUND);
		}
		logger.info("product updated");
		return new ResponseEntity<>("produc updated ",HttpStatus.OK);
	}

	public Object deleteProduct(int id) {
		try {
			ProductRepository.deleteById(id);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND) ;
		}
		//return new ResponseEntity<>("productDB deleted ",HttpStatus.NOT_FOUND) ;
		return("product deleted ") ;
 
	}

	public Object getProductByPriceRenge(float price1, float price2) {
		return ProductRepository.findByPriceBetween(price1, price2);
	}

	public Object getProductByPriceRengeCategory(float price1, float price2, String category) {
		return ProductRepository.findByPriceBetweenAndCategory(price1, price2, category);
	}

}
