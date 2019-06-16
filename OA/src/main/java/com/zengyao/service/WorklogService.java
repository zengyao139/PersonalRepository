package com.zengyao.service;

import java.util.List;

import com.zengyao.entity.Worklog;

/**
 * 工作日志业务接口
 * @author 曾尧
 *
 */
public interface WorklogService {

	public List<Worklog> getList();
	
	
	public int save(String year,Worklog worklog);
	
	public Worklog getWorklogById(String uid);
	
	public String deleteById(String uid);
	
	public boolean updateWorklog(String year,Worklog worklog);
	
}
