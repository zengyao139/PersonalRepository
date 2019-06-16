package com.zengyao.service;

import java.util.List;

import com.zengyao.entity.Sms;

/**
 * 消息管理接口
 * @author 曾尧
 *
 */
public interface SmsService {

	public List<Sms> getList(String username);
	
	public int save(Sms sms);
	
	public Sms getSmsById(String uid);
	
	public String deleteById(String uid);
	
	public String updateSms(String uid);
	
}
