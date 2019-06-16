package com.zengyao.action;


import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.zengyao.config.AlipayInformation;
import com.zengyao.entity.Address;
import com.zengyao.entity.User;
import com.zengyao.service.AddressService;
import com.zengyao.service.UserService;






/**
 * 
 * @author 曾尧
 *
 */
//localhost:8080/OA/namespace_name/action_name!method_name


@Namespace("/index")
@Results({
	@Result(name="frame",location="/common/frame.jsp"),
	@Result(name="header",location="/common/header.jsp"),
	@Result(name="menu",location="/common/menu.jsp"),
	@Result(name="system",location="/common/system.jsp"),
	@Result(name="communication",location="/address/communication.jsp"),
	@Result(name="addressadd",location="/address/addressadd.jsp"),
	@Result(name="addressmodify",location="/address/addressmodify.jsp"),
	@Result(name="login",location="/index/login.jsp"),
	@Result(name="main",location="/common/main2.jsp"),
})	
public class IndexAction {
	
	
	private List<Address> addressList;
	
	private List<String> addressNameList;
	
	@Resource
	private AddressService addressService;
	
	@Resource
	private UserService userService;
	
	private String name;
	
	private String address2;
	
	private String username;
	
	private String uid;
	
	private Address address;
	
	private String ID;
	
	private User user ;


	
	@Action("frame")
	public String frame(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String authCode=request.getParameter("auth_code");
		AlipayInformation alipayInformation=new AlipayInformation();
		String access_token=alipayInformation.getAccess_Token(authCode);
		String yes_no=alipayInformation.getUserInfoByToken(access_token,request);
		return "frame";
	}
	@Action("frame1")
	public String frame1(){
		return "frame";
	}
	
	@Action("index")
	public String index() {
		return "login";
	}
	@Action("main")
	public String main() {
		return "main";
	}
	@Action("menu")
	public String menu() {
		return "menu";
	}
	@Action("header")
	public String header() {
		return "header";
	}
	@Action("system")
	public String system() {
		return "system";
	}
	@Action("communication")
	public String communication(){
		//HttpServletRequest request=ServletActionContext.getRequest();
		addressList=addressService.getAddress();
		addressNameList=addressService.getAddressName();
	//	request.setAttribute("addressList", addressList);
	//	request.setAttribute("addressNameList", addressNameList);
		return "communication";
	}
	
	
	@Action("search")
	public String search(){
		addressList=addressService.getAddressModel(name, address2);
		addressNameList=addressService.getAddressName();
		HttpSession session=ServletActionContext.getRequest().getSession();
		username=(String)session.getAttribute("user");
		return "communication";
	}

	@Action("add")
	public String add(){
		return "addressadd";
	}
	@Action("addOk")
	public String addOk(){
		address.setUsername(ServletActionContext.getRequest().getSession().getAttribute("user").toString());
		int result=addressService.save(address);
		if(result>0) {
			addressList=addressService.getAddressModel(name, address2);
			addressNameList=addressService.getAddressName();
			return "communication";
		}
		return "addressadd";
	}
	
	@Action("deleteAdd")
	public String deleteAdd()throws Exception {
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out =response.getWriter();
		String data=addressService.deleteById(uid);
		out.write(data);
		out.flush();
		out.close();
		return "communication";
		
	}
	
	@Action("modify")
	public String modify() {
		if(!addressService.updateAddress(address))
		     return "addressmodify";
		addressList=addressService.getAddressModel(name, address2);
		addressNameList=addressService.getAddressName();
		return "communication";
	}
	
	@Action("getModifyJsp")
	public String getModifyJsp() {
		address=addressService.getAddressById(ID);
		return "addressmodify";
	}
	
	
	
	public AddressService getAddressService() {
		return addressService;
	}
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	public List<String> getAddressNameList() {
		return addressNameList;
	}
	public void setAddressNameList(List<String> addressNameList) {
		this.addressNameList = addressNameList;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	
	
	
	
}
