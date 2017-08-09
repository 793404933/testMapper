package com.lgh.controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgh.pojo.Users;
import com.lgh.service.UserService;
@Controller

public class FirstController {
	@Autowired
	UserService userService;
	@Autowired
	Users user;
	@RequestMapping(value="/")
	public String show(){
		return "showUser";
	}
	@RequestMapping(value="/showUser" )
	public String showUser(String user_id,String password,HttpSession httpSession){
		if(userService.loginJudgeService(user_id, password)){
			user.setUser_id(user_id);
			user.setPassword(password);
			httpSession.setAttribute("userSession",user);
		return "success";
		}
		else 
		return "showUser";
	}
}
