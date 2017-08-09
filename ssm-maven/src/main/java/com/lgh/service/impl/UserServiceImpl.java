package com.lgh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lgh.dao.UserDao;
import com.lgh.pojo.Users;
import com.lgh.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	    @Resource  
	    private UserDao userDao;

		public Users findUserById(String user_id) {
			// TODO Auto-generated method stub
			return  userDao.findUserById(user_id);
		}  
		public Boolean loginJudgeService(String user_id,String password){
			Users users=userDao.loginJudge(user_id, password);
			System.out.println(users);
			if(users==null){
				return false;
			}else{
				if(users.getUser_id().equals(user_id) &&users.getPassword().equals(password)){
					return true;
				}
				
			}
			System.out.println(users.getUser_id()+" "+user_id);
			return false;
		}

}
