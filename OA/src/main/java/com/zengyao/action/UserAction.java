package com.zengyao.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.zengyao.entity.User;
import com.zengyao.service.UserService;
import com.zengyao.util.AliyunSendUtil;

@Namespace("/index")
@Action("/user")
@Results({
	@Result(name="frame",location="/common/frame.jsp"),
	@Result(name="login",location="/index/login.jsp"),
	@Result(name="index",location="/index/login.jsp"),
	@Result(name="person",location="/user/person.jsp"),
	@Result(name="register",location="/user/register.jsp"),
})	
public class UserAction {
	
	//private static final long serialVersionUID = 1L;
	
	@Resource
	private UserService userService;
	
	private User user;
	
	private String username;
	
	private String code;
	
	private String phone;
	
	private String uname;
	
	public String login(){
		if(userService.checkUser(user.getUsername(), user.getPassword())) {
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("user", user.getUsername());
			return "frame";
		}
		else return "login";
	}
	
	public String checkName()throws Exception  {
		String u=userService.getUsernameCount(uname);
		System.out.println("data: "+u);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out =response.getWriter();
		out.write(u);
		out.flush();
		out.close();
		return "register";
	}
	
	
	
	public String code()throws Exception {
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out =response.getWriter();
		//把控短信发送条数，
		String vcode=AliyunSendUtil.Send(phone);
		if(vcode.equals("false"))
			out.write("0");
		else {
			Cookie cookie=new Cookie("code",vcode);
			cookie.setMaxAge(60);
			response.addCookie(cookie);
			out.write("1");
		}
		out.flush();
		out.close();
		return "register";
	
	}
	
	@Action("addOk")
	public String addOk(){
		System.out.println("user: "+user);
		int result=userService.save(user);
		if(result>0)
			return "index";
		else return "register";
	}
	
	
	public String compare()throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out =response.getWriter();
		Cookie[] cookie=request.getCookies();
		String cookCode=null;
		for (Cookie cookie2 : cookie) {
			if(cookie2.getName().equals("code")) {
				cookCode=cookie2.getValue();
				break;
			}
		}
		if(cookCode!=null) {
			if(cookCode.equals(code))	
				out.write("1");
			else  out.write("0");
		}
		else 
			out.write("2");
		out.flush();
		out.close();
		return "register";
		
		
	}
	
	
	
	
	public String person() {
		return "person";
	}
	public String register() {
		return "register";
	}
	
	public String logout() {
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return "index";
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}





	public String getCode() {
		return code;
	}





	public void setCode(String code) {
		this.code = code;
	}





	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
	
	
}
