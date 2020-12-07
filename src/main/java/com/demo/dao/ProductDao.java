package com.demo.dao;

import java.util.List;

import com.demo.bean.Product;

public interface ProductDao {

	List<Product> getallproduct();

	Product getProductById(int id);

	int update(Product p);

	int delete(int id);

	int addproduct(Product p);

}
