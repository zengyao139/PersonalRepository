package com.zengyao.service;

import java.util.List;

import com.zengyao.entity.Notice;

/**
 * 公告管理业务接口
 * @author 曾尧
 *
 */
public interface NoticeService {

	public List<Notice> getList();
	
	public int save(Notice notice);
	
	public Notice getNoticeById(String uid);
	
	public String deleteById(String uid);
	
	public boolean updateNotice(Notice notice);
	
}
