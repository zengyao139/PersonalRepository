package com.zengyao.service;

import java.util.List;

import com.zengyao.entity.Address;
/**
 * 联系人管理业务接口
 * @author 曾尧
 *
 */
public interface AddressService {
	
	public List<Address> getAddress();
	
	public List<String> getAddressName();
	
	public List<Address> getAddressModel(String name,String address);
	
	public int save(Address address);
	
	public Address getAddressById(String uid);
	
	public String deleteById(String uid);
	
	public boolean updateAddress(Address address);
	
	
	
}
