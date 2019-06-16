package com.zengyao.service;

import java.util.List;

import com.zengyao.entity.Schedule;

/**
 * 日程管理业务接口
 * @author 曾尧
 *
 */
public interface ScheduleService {

	public List<Schedule> getList();
	
	
	public List<Integer> getDay();
	
	public List<Integer> getMonth();
	
	public List<Schedule> getScheduleModel(String day,String month);
	
	public int save(String year,String plan,String username);
	
	public Schedule getScheduleById(String uid);
	
	public String deleteById(String uid);
	
	public boolean updateSchedule(String username,String year,String plan,String ID);
	
}
