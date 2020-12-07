package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.Product;
import com.demo.dao.ProductDao;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	@Override
	public List<Product> getallProduct() {
		
		return productDao.getallproduct();
	}
	@Override
	public Product getProductById(int id) {
		
		return productDao.getProductById(id);
	}
	@Override
	public int update(Product p) {
		
		return productDao.update(p);
	}
	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return productDao.delete(id);
	}
	@Override
	public int addProduct(Product p) {
		
		return productDao.addproduct(p);
	}

}
