package com.lgh.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.lgh.dao.UserDao;
import com.lgh.pojo.Users;
import com.lgh.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class TestMyBatis {  
    private static Logger logger = Logger.getLogger(TestMyBatis.class);  
//  private ApplicationContext ac = null;  
    @Autowired
    private UserService userService ;  
  @Autowired
  UserDao userDao;
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
  
    @Test  
    public void test1() {  
        Users user = userService.findUserById("1");  
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
        logger.info(JSON.toJSONString(user));  
    }  
    @Test
    public void test2(){
    	if(userDao.loginJudge("1","")==null){
    		System.out.println("f");	
    	}
    	System.out.println("s");
    	
    }
}  
