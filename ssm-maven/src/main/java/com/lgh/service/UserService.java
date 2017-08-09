package com.lgh.service;


import org.springframework.stereotype.Service;

import com.lgh.pojo.Users;
@Service
public interface UserService {
	 public Users findUserById(String user_id); 
	 public Boolean loginJudgeService(String user_id,String password);
	}
