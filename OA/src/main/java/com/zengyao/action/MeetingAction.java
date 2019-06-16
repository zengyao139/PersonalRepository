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

import com.zengyao.entity.Meeting;
import com.zengyao.service.MeetingService;

@Namespace("/index")
@Action("/meeting")
@Results({
	@Result(name="meeting",location="/meeting/meeting.jsp"),
	@Result(name="meetingmodify",location="/meeting/meetingmodify.jsp"),
	@Result(name="meetingadd",location="/meeting/meetingadd.jsp"),
})	
public class MeetingAction {
	
	@Resource
	private MeetingService meetingService;
	
	private List<Meeting> meetingList;
	
	private Meeting meeting;
	
	private String uid;
	
	private String username;
	
	private String ID;
	
	
	public String meeting() {
		meetingList=meetingService.getList();
		HttpSession session=ServletActionContext.getRequest().getSession();
		username=(String)session.getAttribute("user");
		return "meeting";
	}
	
	
	
	
	public String add() {
		return "meetingadd";
	}
	
	public String addOk() {
		int result=meetingService.save(meeting);
		if(result>0) {
			meetingList=meetingService.getList();
			return "meeting";
		}
		return "meetingadd";
	}
	
	
	public String getModifyJsp() {
		meeting=meetingService.getMeetingById(ID);
		return "meetingmodify";
	}
	
	public String modify() {
		if(!meetingService.updateMeeting(meeting))
			return "meetingmodify";
		meetingList=meetingService.getList();
	    return "meeting";
	}
	
	public String deleteAdd()throws Exception {
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out =response.getWriter();
		String data=meetingService.deleteById(uid);
		out.write(data);
		out.flush();
		out.close();
		return "meeting";
		
	}




	public MeetingService getMeetingService() {
		return meetingService;
	}




	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}




	public List<Meeting> getMeetingList() {
		return meetingList;
	}




	public void setMeetingList(List<Meeting> meetingList) {
		this.meetingList = meetingList;
	}




	public Meeting getMeeting() {
		return meeting;
	}




	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}




	public String getUid() {
		return uid;
	}




	public void setUid(String uid) {
		this.uid = uid;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getID() {
		return ID;
	}




	public void setID(String iD) {
		ID = iD;
	}


	
	
	
	
}
