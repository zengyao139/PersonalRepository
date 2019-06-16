package com.zengyao.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class TimeUtil {

	public static String time(int year,int month,int day1) {
		return ""+year+"-"+oneparam(month)+"-"+oneparam(day1);
		
	}
	
	public static String oneparam(int day) {
		String day1="";
		if(day<10)
			day1="0"+day;
		else
			day1=""+day;
		return day1;
	}
	public static void main(String[] args) {
		System.out.println(getFormatTime());
	}
	public static String getFormatTime() {
		 return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())).toString();
	}
}
