package com.lgh.mapper;

import java.util.List;

import pojo.Users;

public interface UserMapper {
	//根据Id查询用户信息
	public Users findUserById(String user_id) throws Exception;	
	//添加用户
	public void insertUser(Users user) throws Exception;
	public List<Users> findAll()	throws Exception;
	//修改用户
	public void updateUser(Users user) throws Exception;
		
	//删除用户
	public void deleteUser(String user_id) throws Exception;
}
