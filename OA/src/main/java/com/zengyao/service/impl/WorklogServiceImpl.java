package com.zengyao.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zengyao.dao.WorklogDao;
import com.zengyao.entity.Worklog;
import com.zengyao.service.WorklogService;

@Service
@Transactional
public class WorklogServiceImpl implements WorklogService{

	@Resource
	private WorklogDao worklogDao;
	
	private   Logger logger=Logger.getLogger(WorklogServiceImpl.class);
	
	
	@Override
	public List<Worklog> getList() {
		// TODO Auto-generated method stub
		return worklogDao.getList();
	}

	@Override
	public int save(String year,Worklog worklog) {
		// TODO Auto-generated method stub
		worklog.setYear(Integer.parseInt(year.substring(0, 4)));
		worklog.setMonth(Integer.parseInt(year.substring(5, 7)));
		worklog.setDay(Integer.parseInt(year.substring(8, 10)));
		logger.info("保存工作日志");
		return worklogDao.save(worklog);
	}

	@Override
	public Worklog getWorklogById(String uid) {
		// TODO Auto-generated method stub
		return worklogDao.get(Worklog.class, Integer.parseInt(uid));
	}

	@Override
	public String deleteById(String uid) {
		Worklog worklog=worklogDao.get(Worklog.class, Integer.parseInt(uid));
		if(worklog==null) {
			//记录日志
			logger.info("工作日志不存在");
			return "0";
		}
		if(worklogDao.delete(worklog)) {
			logger.info("删除工作日志成功");
			return "1" ;
		}
		logger.info("删除工作日志失败");	
		return "2";
	}

	@Override
	public boolean updateWorklog(String year,Worklog worklog) {
		// TODO Auto-generated method stub
		worklog.setYear(Integer.parseInt(year.substring(0, 4)));
		worklog.setMonth(Integer.parseInt(year.substring(5, 7)));
		worklog.setDay(Integer.parseInt(year.substring(8, 10)));
		logger.info("更新工作日志");
		return worklogDao.update(worklog);
	}

}
