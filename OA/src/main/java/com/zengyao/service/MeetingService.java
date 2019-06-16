package com.zengyao.service;

import java.util.List;

import com.zengyao.entity.Meeting;

/**
 * 会议管理业务接口
 * @author 曾尧
 *
 */
public interface MeetingService {

	public List<Meeting> getList();
	
	public int save(Meeting meeting);
	
	public Meeting getMeetingById(String uid);
	
	public String deleteById(String uid);
	
	public boolean updateMeeting(Meeting meeting);
	
}
