package com.lgh.mapper.MybatisMapper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pojo.Users;


public class mybatisfirst {

	public static void main(String[] args) throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Users user = sqlSession.selectOne("test.findUserById", "1");
		System.out.println(user.getUser_id() + " " + user.getUser_name() + " " + user.getUser_years());
		Users user_insert =new Users();
		user_insert.setUser_id("2");
		user_insert.setUser_name("liguohui");
		user_insert.setUser_years(23);
		sqlSession.delete("test.deleteUser",2);
		//sqlSession.update("test.updateUser","user_insert"); //插入也是一样的。
		sqlSession.commit() ;
		sqlSession.close();
	}
	

}
