package com.zengyao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zengyao.entity.Worklog;

@Repository // 注册dao层bean等同于@Component
@SuppressWarnings("unchecked")
public class WorklogDao extends BaseDao {
	
	
	@SuppressWarnings("unchecked")
	public List<Worklog> getList(){
		return getSession().createQuery("from Worklog").list();
	}
	
	
	
}
