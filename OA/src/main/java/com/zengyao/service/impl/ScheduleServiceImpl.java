package com.zengyao.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zengyao.dao.ScheduleDao;
import com.zengyao.entity.Schedule;
import com.zengyao.service.ScheduleService;


@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

	@Resource
	private ScheduleDao scheduleDao;
	
	private   Logger logger=Logger.getLogger(ScheduleServiceImpl.class);

	@Override
	public List<Schedule> getList() {
		// TODO Auto-generated method stub
		return scheduleDao.getList();
	}

	@Override
	public List<Integer> getDay() {
		// TODO Auto-generated method stub
		return scheduleDao.getDay();
	}

	@Override
	public List<Integer> getMonth() {
		// TODO Auto-generated method stub
		return scheduleDao.getMonth();
	}

	@Override
	public List<Schedule> getScheduleModel(String day,String month) {
		// TODO Auto-generated method stub
		if("0".equals(day))
			day=null;
		if("0".equals(month))
			month=null;
		return scheduleDao.getScheduleModel(day, month);
	}

	@Override
	public int save(String year,String plan,String username) {
		// TODO Auto-generated method stub
		Schedule schedule=new Schedule();
		schedule.setYear(Integer.parseInt(year.substring(0, 4)));
		schedule.setMonth(Integer.parseInt(year.substring(5, 7)));
		schedule.setDay(Integer.parseInt(year.substring(8, 10)));
		schedule.setPlan(plan);
		schedule.setUsername(username);
		logger.info("保存日程");
		return scheduleDao.save(schedule);
	}

	@Override
	public Schedule getScheduleById(String uid) {
		// TODO Auto-generated method stub
		return scheduleDao.get(Schedule.class,Integer.parseInt(uid));
	}

	@Override
	public String deleteById(String uid) {
		Schedule schedule = scheduleDao.get(Schedule.class, Integer.parseInt(uid));
		if(schedule==null) {
			//记录日志
			logger.info("对应日程不存在");
			return "0";
		}
		if(scheduleDao.delete(schedule)) {
			logger.info("删除日程成功");
		return "1" ;
		}	
		logger.info("删除日程失败");
		return "2";
	}

	@Override
	public boolean updateSchedule(String username,String year,String plan,String ID) {
		// TODO Auto-generated method stub
		Schedule schedule=new Schedule();
		schedule.setYear(Integer.parseInt(year.substring(0, 4)));
		schedule.setMonth(Integer.parseInt(year.substring(5, 7)));
		schedule.setDay(Integer.parseInt(year.substring(8, 10)));
		schedule.setID(Integer.parseInt(ID));
		schedule.setUsername(username);
		schedule.setPlan(plan);
		logger.info("更新日程");
		return scheduleDao.update(schedule);
	}

}
