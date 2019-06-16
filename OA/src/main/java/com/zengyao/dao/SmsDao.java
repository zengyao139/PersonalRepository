package com.zengyao.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.zengyao.entity.Sms;

@Repository // 注册dao层bean等同于@Component
@SuppressWarnings("unchecked")
public class SmsDao extends BaseDao {

	
	
	@SuppressWarnings("unchecked")
	public List<Sms> getList(String username){
		return getSession().createQuery("from Sms where username=:userName  or sender=:send").setString("userName", username).setString("send", username).list();
	}

	public int updateByUid(int uid) {
		
		String hql="update Sms  set isRead=1 where ID=:ID";
		Query query=getSession().createQuery(hql);
		query.setInteger("ID", uid);
		return query.executeUpdate(); 
	}
	
	
}
