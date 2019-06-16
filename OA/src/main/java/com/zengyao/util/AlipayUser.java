package com.zengyao.util;

import java.io.Serializable;

public class AlipayUser implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2644136226644308855L;
	public static int count=0;
	private int id;
	private String address;
	private String certNo;
	private String city;
	private String countryCode;
	private String email;
	private String mobile;
	private String phone;
	private String province;
	private String userName;
	private String nickName;
	
	public AlipayUser() {
		
	}
	public AlipayUser( String address, String certNo, String city, String countryCode, String email, String mobile,
		String phone, String province, String userName, String nickName) {
	this.id = AlipayUser.getCount();
	this.address = address;
	this.certNo = certNo;
	this.city = city;
	this.countryCode = countryCode;
	this.email = email;
	this.mobile = mobile;
	this.phone = phone;
	this.province = province;
	this.userName = userName;
	this.nickName = nickName;
}
	public static int getCount() {
		return ++count;
	}
	public String getId() {
		return String.valueOf(id);
	}
	public void setId() {
		this.id = AlipayUser.getCount();
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "AlipayUser [id=" + id + ", address=" + address + ", certNo=" + certNo + ", city=" + city
				+ ", countryCode=" + countryCode + ", email=" + email + ", mobile=" + mobile + ", phone=" + phone
				+ ", province=" + province + ", userName=" + userName + ", nickName=" + nickName + "]";
	}
	
	
	
}
