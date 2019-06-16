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

import com.zengyao.entity.Notice;
import com.zengyao.service.NoticeService;

/**
 * 公告管理
 * @author 曾尧
 *
 */
@Namespace("/index")
@Action("/notice")
@Results({
	@Result(name="notice",location="/notice/notice.jsp"),
	@Result(name="noticemodify",location="/notice/noticemodify.jsp"),
	@Result(name="noticeadd",location="/notice/noticeadd.jsp"),
})	
public class NoticeAction {
	
	@Resource
	private NoticeService noticeService;
	
	private List<Notice> noticeList;
	
	private Notice notice;
	
	private String uid;
	
	private String username;
	
	private String ID;
	
	
	public String notice() {
		noticeList=noticeService.getList();
		HttpSession session=ServletActionContext.getRequest().getSession();
		username=(String)session.getAttribute("user");
		return "notice";
	}
	
	
	
	
	public String add() {
		return "noticeadd";
	}
	
	public String addOk() {
		int result=noticeService.save(notice);
		if(result>0) {
			noticeList=noticeService.getList();
			return "notice";
		}
		return "noticeadd";
	}
	
	
	public String getModifyJsp1() {
		notice=noticeService.getNoticeById(ID);
		return "noticemodify";
	}
	
	public String modify() {
		if(!noticeService.updateNotice(notice))
			return "noticemodify";
		noticeList=noticeService.getList();
	    return "notice";
	}
	
	public String deleteAdd()throws Exception {
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out =response.getWriter();
		String data=noticeService.deleteById(uid);
		out.write(data);
		out.flush();
		out.close();
		return "notice";
		
	}




	public NoticeService getNoticeService() {
		return noticeService;
	}




	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}




	public List<Notice> getNoticeList() {
		return noticeList;
	}




	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}




	public Notice getNotice() {
		return notice;
	}




	public void setNotice(Notice notice) {
		this.notice = notice;
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
