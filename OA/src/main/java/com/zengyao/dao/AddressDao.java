package com.zengyao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zengyao.entity.Address;

@Repository // 注册dao层bean等同于@Component
@SuppressWarnings("unchecked")
public class AddressDao extends BaseDao {
	
	

	
	/**
	 * 获取列表
	 * @param page
	 * @param rows
	 * @return 无记录返回空集合
	 */
	@SuppressWarnings("unchecked")
	public List<Address> getList(){
		return getSession().createQuery("from Address").list();
	}

	public List<String> getAddress(){
		return  getSession().createQuery("select distinct address from Address order by address desc").list();
	}
	
	public List<Address> getAddressModel(String name,String address){
		String hql=" from Address  ";
		if(name!=null && !"".equals(name)) {
			hql+="where name like '%"+name+"%' ";
			if(address!=null && !"".equals(address))
				hql+=" and address like '%"+address+"%'";
		}else {
			if(address!=null && !"".equals(address)) {
				hql+="where address like '%"+address+"%'";
			}
		}
		return getSession().createQuery(hql).list();
		
	}
	

	

}
