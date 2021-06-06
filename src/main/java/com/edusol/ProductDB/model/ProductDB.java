package com.edusol.ProductDB.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity

@Table(name = "PRODUCT")
public class ProductDB {

	@Id
	@Column(name = "ID")//database column names
	private int id; // class properties
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PRICE")
	private float price;
	
	@Column(name = "CATEGORY")
	private String category;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "ProductDB [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + "]";
	}
	
	
	
}