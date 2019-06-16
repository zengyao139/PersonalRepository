package com.zengyao.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.zengyao.service.impl.AddressServiceImpl;




public class ExcelUtil {

	public static HSSFWorkbook mWorkbook = new HSSFWorkbook();
	public static HSSFSheet mSheet=null;
	
	private static  Logger logger=Logger.getLogger(AddressServiceImpl.class);
	
	
	static{
		mSheet=mWorkbook.createSheet(AlipayUser.class.getName());
		setTitle(AlipayUser.class,mSheet.createRow(0));
	}
	
	//设置表头
	public static void setTitle(Class clazz,HSSFRow headRow) {
		Field[] fields=clazz.getDeclaredFields();
		int i=0;
		for (Field field:fields) {
			if(field.toString().contains("static"))
				continue;
			headRow.createCell(i++).setCellValue(field.toString().substring(field.toString().lastIndexOf(".")+1));
		}
		headRow.createCell(i++).setCellValue("登录时间");
	}
	//注入数据
	private static void createCell(Object student, HSSFSheet sheet,HttpServletRequest req) throws  IllegalArgumentException, InvocationTargetException, IllegalAccessException {
		HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
		Field[] fields=student.getClass().getDeclaredFields();
		int i=0;
		for (Field field:fields) {
			if(field.toString().contains("static"))
				continue;
			Method method=getGetMethod(student.getClass(), field.toString().substring(field.toString().lastIndexOf(".")+1));
			String value=(String) method.invoke(student, new Object[0]);
			dataRow.createCell(i++).setCellValue(value);
		}
		dataRow.createCell(i).setCellValue(TimeUtil.getFormatTime());
		File xlsFile=new File(req.getRealPath("file")+"/alipayUser.xls");
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(xlsFile,true);
			
			mWorkbook.write(fout);// 或者以流的形式写入文件 mWorkbook.write(new FileOutputStream(xlsFile));
			fout.flush();
			fout.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件写入错误"+e.getMessage());
		}
	}
	
	public static void writeObject(Object user,HttpServletRequest req) {
		try {
			createCell(user, mSheet, req);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("对象写入到文件中错误");
		}
	}
	//初始化工作表格
	public static HSSFSheet init(String fileName) {
		return new HSSFWorkbook().createSheet(fileName);
		
	}
	

	public static Method getGetMethod(Class objectClass, String fieldName) {  
	       StringBuffer sb = new StringBuffer();  
	       sb.append("get");  
	       sb.append(fieldName.substring(0, 1).toUpperCase());  
	       sb.append(fieldName.substring(1));  
	       try {  
	           return objectClass.getMethod(sb.toString());  
	       } catch (Exception e) {  
	       }  
	       return null;  
	   }  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args)throws Exception {
		File file1=new File("src/main/resources/spring.xml");
		System.out.println(file1.getCanonicalPath());
		File file=new File("alipayUser_.xls");
		System.out.println(file.exists());
		System.out.println(file);
		
	}
	public static void main1()throws Exception{
		HSSFWorkbook mWorkbook = new HSSFWorkbook();
		 
		//	HSSFSheet mSheet = mWorkbook.createSheet(AlipayUser.class.getName());
			HSSFSheet mSheet=mWorkbook.createSheet(AlipayUser.class.getName());
			setTitle(AlipayUser.class,mSheet.createRow(0));
			AlipayUser user=new AlipayUser();
			user.setId();
			user.setAddress("南昌");
			user.setCertNo("12");
			user.setCity("江西");
			user.setEmail("email");
			user.setMobile("mobile");
			user.setNickName("nickname");
			user.setCountryCode("counterCode");
			user.setPhone("phone");
			user.setProvince("province");
			user.setUserName("username");
			createCell(user, mSheet,null);
	 
			File xlsFile = new File("D://alipayUser_xls");
			FileOutputStream fout=new FileOutputStream(xlsFile);
			mWorkbook.write(fout);// 或者以流的形式写入文件 mWorkbook.write(new FileOutputStream(xlsFile));
			fout.flush();
			fout.close();
	}
	
	
	
}
