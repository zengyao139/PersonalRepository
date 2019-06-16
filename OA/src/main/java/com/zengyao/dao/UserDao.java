package com.zengyao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zengyao.entity.User;

@Repository // 注册dao层bean等同于@Component
@SuppressWarnings("unchecked")
public class UserDao extends BaseDao {
	
	
	/**
	 * 通过用户名查找用户
	 * @return 无记录返回null
	 */
	public User getByUsername(String username){
		User user1= (User) getSession().createQuery("from User where username=:username")
				.setString("username", username).uniqueResult();
		System.out.println("user: "+user1);
		return user1;
	}
	
	/**
	 * 通过用户名和密码查找
	 * @param username
	 * @param password
	 * @return 无记录返回null
	 */
	public User getByUsernameAndPassword(String username, String password){
		return (User) getSession().createQuery("from User where username=:username and password=:password")
				.setString("username", username).setString("password", password).uniqueResult();
	}
	
	/**
	 * 获取列表
	 * @param page
	 * @param rows
	 * @return 无记录返回空集合
	 */
	@SuppressWarnings("unchecked")
	public List<User> getList(int page, int rows){
		return getSession().createQuery("from User").setFirstResult(rows*(page-1)).setMaxResults(rows).list();
	}

	/**
	 * 总数
	 * @return
	 */
	public long getTotal() {
		return (Long) getSession().createQuery("select count(*) from User").uniqueResult();
	}
	
	public long getUsernameCount(String uname) {
		return (Long)getSession().createQuery("select count(*) from User where username=:name").setString("name", uname).uniqueResult();
	}

}
