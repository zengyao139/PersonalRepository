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

import com.zengyao.entity.Schedule;
import com.zengyao.service.ScheduleService;
import com.zengyao.util.TimeUtil;

@Namespace("/index")
@Action("/schedule")
@Results({
	@Result(name="schedule",location="/schedule/schedule.jsp"),
	@Result(name="modify",location="/schedule/schedulemodify.jsp"),
	@Result(name="scheduleadd",location="/schedule/scheduleadd.jsp"),
})	
public class ScheduleAction {
	
	
	@Resource
	private ScheduleService scheduleService;
	
	private List<Schedule> scheduleList;
	
	private List<Integer> dayList;
	
	private List<Integer> monthList;
	
	private String month;
	
	private String day;
	
	private String username;
	
	private String year;
	
	private String plan;
	
	private Schedule schedule;
	
	private String ID;
	
	private String uid;
	
	public String schedule() {
		
		scheduleList=scheduleService.getList();
		
		dayList=scheduleService.getDay();

		monthList=scheduleService.getMonth();
		
		return "schedule";
	}
	
	
	public String search() {
		monthList=scheduleService.getMonth();
		dayList=scheduleService.getDay();
		scheduleList=scheduleService.getScheduleModel(day, month);
		HttpSession session=ServletActionContext.getRequest().getSession();
		username=(String)session.getAttribute("user");
		return "schedule";
	}
	
	public String add() {
		return "scheduleadd";
	}
	
	public String addOk() {
		int result=scheduleService.save(year, plan, username);
		if(result>0) {
			scheduleList=scheduleService.getList();
			dayList=scheduleService.getDay();
			monthList=scheduleService.getMonth();
			return "schedule";
		}
		return "scheduleadd";
	}
	
	
	public String getModifyJsp() {
		schedule=scheduleService.getScheduleById(ID);
		year=TimeUtil.time(schedule.getYear(), schedule.getMonth(),schedule.getDay());
		return "modify";
	}
	
	public String modify() {
		if(!scheduleService.updateSchedule(username,year,plan,ID))
		     return "modify";
		scheduleList=scheduleService.getList();
		dayList=scheduleService.getDay();
		monthList=scheduleService.getMonth();
		return "schedule";
	}
	
	public String deleteAdd()throws Exception {
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out =response.getWriter();
		String data=scheduleService.deleteById(uid);
		out.write(data);
		out.flush();
		out.close();
		return "schedule";
		
	}
	
	
	

	public ScheduleService getScheduleService() {
		return scheduleService;
	}

	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	public List<Schedule> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(List<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}

	public List<Integer> getDayList() {
		return dayList;
	}

	public void setDayList(List<Integer> dayList) {
		this.dayList = dayList;
	}


	public List<Integer> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<Integer> monthList) {
		this.monthList = monthList;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getPlan() {
		return plan;
	}


	public void setPlan(String plan) {
		this.plan = plan;
	}


	public Schedule getSchedule() {
		return schedule;
	}


	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
	
	
	
	
	
}
