package com.demo.dao;

import com.demo.bean.User;

public interface LoginDao {

	User valid(String name, String pass);

}
