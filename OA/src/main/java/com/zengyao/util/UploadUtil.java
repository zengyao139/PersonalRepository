package com.zengyao.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.struts2.ServletActionContext;

/**
 * 
 * 上传工具类
 */
public class UploadUtil {
	
	/**
	 * 图片上传
	 * @return 返回相对路径
	 * @param photo 图片文件
	 * @param photoFileName 文件名
	 * @param savePath 文件保存路径(相对于web根目录)
	 * @return
	 */
	public static String fileUpload(File photo, String photoFileName, String savePath){
		if (photo == null) {
			return null;
		} 
		String path = ServletActionContext.getServletContext().getRealPath("/")+savePath;			
		String type = photoFileName.substring(photoFileName.lastIndexOf(".")+1, photoFileName.length());
		String time = new SimpleDateFormat("yyMMddssSSS").format(new Date());
		String newFileName = time+"."+type;
		File savefile = new File(path,newFileName);
		if(!savefile.getParentFile().exists()){
			savefile.getParentFile().mkdirs();
		}
		System.err.println("上传文件绝对路径: "+savefile.getPath());
		try {
			//FileUtils.copyFile(photo, savefile);
			FileInputStream fis=new FileInputStream(photo);
			FileOutputStream fos=new FileOutputStream(savefile);
			byte[] bytes=new byte[1024];
			int len=-1;
			while((len=fis.read(bytes))!=-1) {
				fos.write(bytes, 0, len);
			}
			fos.flush();
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return savePath+"/"+newFileName;
	}

}
