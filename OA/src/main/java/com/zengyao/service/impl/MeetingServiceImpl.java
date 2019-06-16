package com.zengyao.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zengyao.dao.MeetingDao;
import com.zengyao.entity.Meeting;
import com.zengyao.service.MeetingService;

@Service
@Transactional
public class MeetingServiceImpl implements MeetingService{

	@Resource
	private MeetingDao meetingDao;

	private   Logger logger=Logger.getLogger(MeetingServiceImpl.class);
	
	@Override
	public List<Meeting> getList() {
		// TODO Auto-generated method stub
		return meetingDao.getList();
	}

	@Override
	public int save(Meeting meeting) {
		// TODO Auto-generated method stub
		return meetingDao.save(meeting);
	}

	@Override
	public Meeting getMeetingById(String uid) {
		// TODO Auto-generated method stub
		return meetingDao.get(Meeting.class, Integer.parseInt(uid));
	}

	@Override
	public String deleteById(String uid) {
		// TODO Auto-generated method stub
		Meeting meeting=meetingDao.get(Meeting.class, Integer.parseInt(uid));
		if(meeting==null) {
			//记录日志
			logger.info("会议记录不存在");
			return "0";
		}
		if(meetingDao.delete(meeting)) {
			logger.info("删除会议记录成功");
			return "1" ;
		}
		logger.info("删除会议记录失败");
		return "2";
	}

	@Override
	public boolean updateMeeting(Meeting meeting) {
		// TODO Auto-generated method stub
		logger.info("更新会议记录");
		return meetingDao.update(meeting);
	}
	
	
	
	
}
