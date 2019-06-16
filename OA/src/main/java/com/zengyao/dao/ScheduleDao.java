package com.zengyao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zengyao.entity.Schedule;

@Repository // 注册dao层bean等同于@Component
@SuppressWarnings("unchecked")
public class ScheduleDao extends BaseDao {

	
	
	@SuppressWarnings("unchecked")
	public List<Schedule> getList(){
		return getSession().createQuery("from Schedule").list();
	}
	
	
	public List<Integer> getDay(){
		return  getSession().createQuery("select distinct day from Schedule order by day desc").list();
	}
	
	public List<Integer> getMonth(){
		return  getSession().createQuery("select distinct month from Schedule order by month desc").list();
	}
	
	
	
	public List<Schedule> getScheduleModel(String day,String month){
		String hql=" from Schedule  ";
		if(day!=null && !"".equals(day)) {
			hql+="where day ="+day;
			if(month!=null && !"".equals(month))
				hql+=" and month ="+month;
		}else {
			if(month!=null && !"".equals(month)) {
				hql+="where month  ="+month;
			}
		}
		return getSession().createQuery(hql).list();
		
	}
}
