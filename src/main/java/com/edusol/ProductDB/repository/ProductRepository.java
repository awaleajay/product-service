package com.edusol.ProductDB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.edusol.ProductDB.model.ProductDB;
       
public interface ProductRepository extends JpaRepository<ProductDB, Integer> {


List<ProductDB> findByCategory(String category);
List<ProductDB> findByPriceBetween(float price1,float price2);
List<ProductDB> findByPriceBetweenAndCategory(float price1, float price2,String category);


}
	

