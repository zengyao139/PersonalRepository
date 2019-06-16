package com.zengyao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zengyao.dao.AddressDao;
import com.zengyao.entity.Address;
import com.zengyao.service.AddressService;



@Service	// 注解为service层spring管理bean
@Transactional	// 注解此类所有方法加入spring事务, 具体设置默认
public class AddressServiceImpl implements AddressService{

	
	@Resource		//spring注入类对象
	private AddressDao addressDao;
	
	private   Logger logger=Logger.getLogger(AddressServiceImpl.class);
	
	@Override
	public List<Address> getAddress() {
		// TODO Auto-generated method stub
		return addressDao.getList();
	}


	@Override
	public List<String> getAddressName() {
		return addressDao.getAddress();
	}


	@Override
	public List<Address> getAddressModel(String name, String address) {
		// TODO Auto-generated method stub
		if("0".equals(address))
			address=null;
		return addressDao.getAddressModel(name, address);
	}


	@Override
	public int save(Address address) {
		// TODO Auto-generated method stub
		return addressDao.save(address);
	}


	@Override
	public Address getAddressById(String uid) {
		// TODO Auto-generated method stub
		return addressDao.get(Address.class, Integer.parseInt(uid));
	}


	@Override
	public String deleteById(String uid) {
		// TODO Auto-generated method stub
		Address address = addressDao.get(Address.class, Integer.parseInt(uid));
		if(address==null) {
			//记录日志
			logger.info("联系人不存在");
			return "0";
		}
		if(addressDao.delete(address)) {
			logger.info("联系人删除成功");
			return "1" ;
		}
		logger.info("联系人删除失败");
		return "2";
	}


	@Override
	public boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		logger.info("更新联系人信息！！");
		return addressDao.update(address);
	}


	
}
