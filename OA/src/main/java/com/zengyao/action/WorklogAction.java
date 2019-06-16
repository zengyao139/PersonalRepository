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

import com.zengyao.entity.Worklog;
import com.zengyao.service.WorklogService;
import com.zengyao.util.TimeUtil;

@Namespace("/index")
@Action("/worklog")
@Results({
	@Result(name="worklog",location="/worklog/worklog.jsp"),
	@Result(name="worklogmodify",location="/worklog/worklogmodify.jsp"),
	@Result(name="worklogadd",location="/worklog/worklogadd.jsp"),
})	
public class WorklogAction {
	
	@Resource
	private WorklogService worklogService;
	
	private List<Worklog> worklogList;
	
	private Worklog worklog;
	
	private String uid;
	
	private String username;
	
	private String ID;
	
	private String year;
	
	
	public String worklog() {
		
		worklogList=worklogService.getList();
		HttpSession session=ServletActionContext.getRequest().getSession();
		username=(String)session.getAttribute("user");
		return "worklog";
	}
	
	
	
	
	public String add() {
		return "worklogadd";
	}
	
	public String addOk() {
		int result=worklogService.save(year,worklog);
		if(result>0) {
			worklogList=worklogService.getList();
			return "worklog";
		}
		return "worklogadd";
	}
	
	
	public String getModifyJsp1() {
		worklog=worklogService.getWorklogById(ID);
		year=TimeUtil.time(worklog.getYear(), worklog.getMonth(), worklog.getDay());
		return "worklogmodify";
	}
	
	public String modify() {
		if(!worklogService.updateWorklog(year, worklog))
			return "worklogmodify";
		worklogList=worklogService.getList();
	    return "worklog";
	}
	
	public String deleteAdd()throws Exception {
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out =response.getWriter();
		String data=worklogService.deleteById(uid);
		out.write(data);
		out.flush();
		out.close();
		return "worklog";
		
	}

	public WorklogService getWorklogService() {
		return worklogService;
	}




	public void setWorklogService(WorklogService worklogService) {
		this.worklogService = worklogService;
	}




	public List<Worklog> getWorklogList() {
		return worklogList;
	}




	public void setWorklogList(List<Worklog> worklogList) {
		this.worklogList = worklogList;
	}




	public Worklog getWorklog() {
		return worklog;
	}




	public void setWorklog(Worklog worklog) {
		this.worklog = worklog;
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




	public String getYear() {
		return year;
	}




	public void setYear(String year) {
		this.year = year;
	}
	
	
	

	
	
	
	
	
	
}
