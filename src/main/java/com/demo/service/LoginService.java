package com.demo.service;

import com.demo.bean.User;

public interface LoginService {

	User valid(String name, String pass);

}

