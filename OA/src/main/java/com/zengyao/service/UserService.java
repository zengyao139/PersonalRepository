package com.zengyao.service;

import com.zengyao.entity.User;
/**
 * 登录用户业务接口
 * @author 曾尧
 *
 */
public interface UserService {

	public boolean checkUser(String username,String password);
	
	public User getByName(String username);
	
	public int save(User user);
	
	public String getUsernameCount(String uname);
}
