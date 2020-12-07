package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.bean.Product;
@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Product> getallproduct() {
		String sql="select * from product";
		List<Product> plist=(List<Product>) jdbcTemplate.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				
				return p;
			}
			});
		return plist;
	}
	@Override
	public Product getProductById(int id) {
		Product p=null;
		String sql="select * from product where pid=?";
		p=(Product) jdbcTemplate.queryForObject(sql,new Object[]{id}, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product pi=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				return pi;
			}
			
		});
		return p;
	}
	@Override
	public int update(Product p) {
		String sql="update product set pname=?,price=? where pid=?";
		int n=jdbcTemplate.update(sql,new Object[] {p.getPname(),p.getPrice(),p.getPid()});
		
		
		return n;
	}
	@Override
	public int delete(int id) {
		String sql="delete from product where pid=?";
		int n=jdbcTemplate.update(sql,id);
		return n;
	}
	@Override
	public int addproduct(Product p) {
		
		String sql="insert into product (pid,pname,price) values(?,?,?)";
		int n=jdbcTemplate.update(sql,new Object[] {p.getPid(),p.getPname(),p.getPrice()});
		return n;
	}

}
