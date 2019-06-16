package com.zengyao.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zengyao.dao.UserDao;
import com.zengyao.entity.User;
import com.zengyao.service.UserService;
import com.zengyao.util.SafeUtil;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	public UserDao userDao;
	
	private   Logger logger=Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public boolean checkUser(String username, String password) {
		// TODO Auto-generated method stub
		/*Md5Hash md5=new Md5Hash(password,username,2);*/
		if(userDao.getByUsernameAndPassword(username, SafeUtil.encode(password))!=null) {
			logger.info("用户："+username+" 验证成功！！");
			return true;
		}
		logger.info("用户："+username+" 验证失败！！");
		return false;
	}
	
	
	@Override
	public User getByName(String username) {
		// TODO Auto-generated method stub
		return userDao.getByUsername(username);
	}




	@Override
	public int save(User user) {
		/*Md5Hash md5=new Md5Hash(user.getPassword(),user.getUsername(),2);*/
		user.setPassword(SafeUtil.encode(user.getPassword()));
		if(userDao.save(user)>0) {
			logger.info("用户："+user.getUsername()+" 注册成功！！");
			return 1;
		}else {
			logger.info("用户："+user.getUsername()+" 注册失败！！");
			return 0;
		}
	}


	@Override
	public String getUsernameCount(String uname) {
		// TODO Auto-generated method stub
		logger.info("验证用户名："+uname+"是否重复!!");
		long index= userDao.getUsernameCount(uname);
		if(index>0) 
			return "1";
		else return "0";
	}

}
