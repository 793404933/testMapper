package com.lgh.test;

import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lgh.dao.UserDao;
import com.lgh.pojo.Users;  
   
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringConfig.xml"})
public class UserServiceTest {  
	@Autowired
	UserDao userDao ;
	 @Test
	 public void testQueryById(){ 
	        Users u = userDao.findUserById("6");  
	        if(u != null){  
	            System.out.println(u.getUser_name());  
	        }  
	 }
}
