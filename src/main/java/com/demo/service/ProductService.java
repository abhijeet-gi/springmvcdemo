package com.demo.service;

import java.util.List;

import com.demo.bean.Product;

public interface ProductService {

	List<Product> getallProduct();

	Product getProductById(int id);

	int update(Product p);

	int deleteProduct(int id);

	int addProduct(Product p);

}
