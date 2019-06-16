package com.zengyao.split;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class SplitUtils {
	
	private File fromFile;
	
	private String toPath;
	
	private int blockSize;
	
	private List<String> destPath;
	
	private int size;
	
	public SplitUtils(String fromPath,String toPath) {
		this(fromPath,toPath,1024);
	}
	public SplitUtils(String fromPath, String toPath2, int blockSize) {
		fromFile =new File(fromPath);
		this.toPath=toPath2;
		this.blockSize=blockSize;
		this.size=(int) Math.ceil((((int) fromFile.length())*1.0)/blockSize);
		//��ʼ��Ŀ��Ŀ¼�ļ�
		init();
		
	}
	public void init() {
		destPath=new ArrayList<String>();
		for(int i=0;i<size;i++) {
			this.destPath.add(this.toPath+"\\"+i+"---"+this.fromFile.getName());
		}
	}
	
	
	public void split()throws Exception {
		//��ʵλ��
		int pos=0;
		int length=(int)this.fromFile.length();
		//�ֳ�ÿ���ʵ�ʴ�С
		int act