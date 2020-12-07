package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.bean.User;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	private JdbcTemplate jdbcTempalte;
	
	@Override
	public User valid(String name, String pass) {
		String sql="select * from user where uname=? and pass=?";
		User n=(User) jdbcTempalte.queryForObject(sql,new Object[] {name,pass}, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User u=new User(rs.getString(1),rs.getString(2));
				return u;
			}});
		return n;
}
}

