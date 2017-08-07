package com.lgh.mapper.MybatisMapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lgh.mapper.UserMapper;

import junit.framework.TestCase;
import pojo.Users;

public class UserMapperTest extends TestCase {
	private SqlSessionFactory sqlSessionFactory;
	
	String resource = "SqlMapConfig.xml";
	
	//任何测试方法都要执行的方法
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		//通过输入流读取配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//获取SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public Users testFindUserById() throws Exception {
		//获取SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//指定 mapper 接口的类型，MyBatis通过动态代理的方式实现mapper接口
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		Users user = userMapper.findUserById("1");
		
		sqlSession.commit();
		sqlSession.close();
		
		System.out.println("user---" + user);
		
		return user;
	}
	public void testFindAll() throws Exception {
		//获取SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//指定 mapper 接口的类型，MyBatis通过动态代理的方式实现mapper接口
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<Users> list = userMapper.findAll();
		System.out.println(list);

			System.out.println(list.get(2).getUser_id()+" ");
		sqlSession.commit();
		sqlSession.close();
	}	
	public void testInsertUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//指定 mapper 接口的类型，MyBatis通过动态代理的方式实现mapper接口
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		Users user = new Users();
		user.setUser_id("20");
		user.setUser_name("liguohui");
		user.setUser_years(30);
		
		userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
	}

	public void testUpdateUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//指定 mapper 接口的类型，MyBatis通过动态代理的方式实现mapper接口
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Users user = new Users();
		user.setUser_id("20");
		user.setUser_name("xiaoming");
		user.setUser_years(30);		

		
		userMapper.updateUser(user);
		sqlSession.commit();
		sqlSession.close();
	}

	public void testDeleteUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUser("20");
		sqlSession.commit();
		sqlSession.close();
	}

}