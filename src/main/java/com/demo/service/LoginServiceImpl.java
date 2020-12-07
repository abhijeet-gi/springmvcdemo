package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.User;
import com.demo.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;
	@Override
	public User valid(String name, String pass) {
	
		return loginDao.valid(name,pass);
	}

}
