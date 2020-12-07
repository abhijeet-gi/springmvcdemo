package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.bean.User;
import com.demo.service.LoginService;


@Controller
public class LoginController {
	
	@Autowired
	 LoginService loginService;
	
	
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public ModelAndView validateUser(@RequestParam("uname")String name,@RequestParam("pass")String pass) {
		
		User n=loginService.valid(name,pass);
		
		String msg=null;
		if(n!=null) {
			 msg="valid User";
		 }else {
			 msg="Invalid User";
		 }
		
		
		return new ModelAndView("displayMessage","msg",msg);
	}

}
