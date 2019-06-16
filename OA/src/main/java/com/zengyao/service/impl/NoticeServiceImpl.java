package com.zengyao.service.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zengyao.dao.NoticeDao;
import com.zengyao.entity.Notice;
import com.zengyao.service.NoticeService;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService{

	@Resource
	private NoticeDao noticeDao;

	private   Logger logger=Logger.getLogger(NoticeServiceImpl.class);
	
	@Override
	public List<Notice> getList() {
		// TODO Auto-generated method stub
		return noticeDao.getList();
	}

	@Override
	public int save(Notice notice) {
		// TODO Auto-generated method stub
		notice.setSendtime(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(new Date(System.currentTimeMillis())).toString());
		return noticeDao.save(notice);
	}

	@Override
	public Notice getNoticeById(String uid) {
		// TODO Auto-generated method stub
		return noticeDao.get(Notice.class, Integer.parseInt(uid));
	}

	@Override
	public String deleteById(String uid) {
		// TODO Auto-generated method stub
		Notice notice=noticeDao.get(Notice.class, Integer.parseInt(uid));
		if(notice==null) {
			//记录日志
			logger.info("对应公告不存在");
			return "0";
		}
		if(noticeDao.delete(notice)) {
			logger.info("删除公告成功");
			return "1" ;
		}
		logger.info("删除公告失败");
		return "2";
	}

	@Override
	public boolean updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		notice.setSendtime(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(new Date(System.currentTimeMillis())).toString());
		return noticeDao.update(notice);
	}
	
	
	
	
}
