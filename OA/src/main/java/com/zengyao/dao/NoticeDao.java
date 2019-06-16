package com.zengyao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zengyao.entity.Notice;

@Repository // 注册dao层bean等同于@Component
@SuppressWarnings("unchecked")
public class NoticeDao extends BaseDao {

	
	
	@SuppressWarnings("unchecked")
	public List<Notice> getList(){
		return getSession().createQuery("from Notice").list();
	}
	
	
}
