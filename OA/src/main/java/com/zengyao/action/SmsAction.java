package com.zengyao.action;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.zengyao.entity.Sms;
import com.zengyao.service.SmsService;

@Namespace("/index")
@Action("/sms")
@Results({
	@Result(name="sms",location="/sms/sms.jsp"),
	@Result(name="smsmodify",location="/sms/smsmodify.jsp"),
	@Result(name="smsadd",location="/sms/smsadd.jsp"),
})	
public class SmsAction {
	
	private List<Sms> smsList;
	
	@Resource
	private SmsService smsService;
	
	private String  username;
	
	private String uid;
	
	private Sms sms;
	
	public String sms() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		username=(String)session.getAttribute("user");
		smsList=smsService.getList(username);
		
		return "sms";
	}
	
	public String addOk() {
		int result=smsService.save(sms);
		if(result>0) {
			smsList=smsService.getList(sms.getSender());
			return "sms";
		}
		return "smsadd";
	}
	
	public String modify()throws Exception {
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out =response.getWriter();
		String data=smsService.updateSms(uid);
		out.write(data);
		out.flush();
		out.close();
		return "sms";
	}
	
	public String deleteAdd()throws Exception {
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out =response.getWriter();
		String data=smsService.deleteById(uid);
		out.write(data);
		out.flush();
		out.close();
		return "sms";
		
	}
	
	public String add() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		username=(String)session.getAttribute("user");
		return "smsadd";
	}


	public List<Sms> getSmsList() {
		return smsList;
	}




	public void setSmsList(List<Sms> smsList) {
		this.smsList = smsList;
	}




	public SmsService getSmsService() {
		return smsService;
	}




	public void setSmsService(SmsService smsService) {
		this.smsService = smsService;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}

	public Sms getSms() {
		return sms;
	}

	public void setSms(Sms sms) {
		this.sms = sms;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	

	
	
	
}
