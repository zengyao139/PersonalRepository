package com.zengyao.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zengyao.dao.SmsDao;
import com.zengyao.entity.Sms;
import com.zengyao.service.SmsService;
import com.zengyao.util.TimeUtil;


@Service
@Transactional
public class SmsServiceImpl implements SmsService {

	@Resource
	private SmsDao smsDao;

	private   Logger logger=Logger.getLogger(SmsServiceImpl.class);
	
	
	@Override
	public List<Sms> getList(String username) {
		// TODO Auto-generated method stub
		return smsDao.getList(username);
	}

	@Override
	public int save(Sms sms) {
		// TODO Auto-generated method stub
		sms.setSendtime(TimeUtil.getFormatTime());
		sms.setIsRead("0");
		logger.info("向"+sms.getUsername()+" 发送消息成功");
		return smsDao.save(sms);
	}

	@Override
	public Sms getSmsById(String uid) {
		// TODO Auto-generated method stub
		return smsDao.get(Sms.class, Integer.parseInt(uid));
	}

	@Override
	public String deleteById(String uid) {
		// TODO Auto-generated method stub
		Sms sms=smsDao.get(Sms.class, Integer.parseInt(uid));
		if(sms==null) {
			//记录日志
			logger.info("对应消息不存在");
			return "0";
		}
		if(smsDao.delete(sms)) {
			logger.info("删除消息失败");
			return "1" ;
		}
		logger.info("删除消息成功");
		return "2";
	}

	@Override
	public String updateSms(String uid) {
		// TODO Auto-generated method stub
		Sms sms=smsDao.get(Sms.class, Integer.parseInt(uid));
		if(sms==null) {
			//记录日志
			logger.info("对应消息不存在");
			return "0";
		}
		int index=smsDao.updateByUid(Integer.parseInt(uid));
		if(index>0) {
			logger.info("更新消息失败");
			return "1" ;
		}
		logger.info("删除消息失败");
		return "2";
		
	}

	

}
