package com.lgh.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class UserController {

	@RequestMapping("/getIt")
	String getIt(){
		
		System.out.println("123123");
		return "error";
	}


	
}
