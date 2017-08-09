package com.lgh.pojo;

import org.springframework.stereotype.Component;

@Component
public class  Users{
String user_id ;
String user_name;
int user_years;
String password;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public int getUser_years() {
	return user_years;
}
public void setUser_years(int user_years) {
	this.user_years = user_years;
}

}
