package com.lgh.dao;

import org.springframework.stereotype.Component;

import com.lgh.pojo.Users;

@Component("userDao")
public interface UserDao {

	public Users findUserById(String user_id);
	public Users loginJudge(String user_id,String password);
}
