package com.zengyao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zengyao.entity.Meeting;

@Repository // 注册dao层bean等同于@Component
@SuppressWarnings("unchecked")
public class MeetingDao extends BaseDao {

	
	
	@SuppressWarnings("unchecked")
	public List<Meeting> getList(){
		return getSession().createQuery("from Meeting").list();
	}
	
}
