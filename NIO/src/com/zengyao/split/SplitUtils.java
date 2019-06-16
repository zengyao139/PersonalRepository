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
		int actualSize=length<blockSize?(length):blockSize;
		for(int i=0;i<size;i++) {
			pos=i*blockSize;
			if(i==size-1) {
				actualSize=length;
			}else {
				actualSize=blockSize;
				length-=actualSize;
			}
			splitToSubFile(i,pos,actualSize);
		}
	}
	private void splitToSubFile(int i, int pos, int actualSize) throws IOException {
	//	System.out.println(this.fromFile.length()+"i: "+i+"  actualSize: "+actualSize);
		RandomAccessFile raf=new RandomAccessFile(this.fromFile,"r");
		RandomAccessFile raf2=new RandomAccessFile(new File(this.destPath.get(i)), "rw");
		//���λ�ö�������λ������λ��
		raf.seek(pos);
		byte[] flush=new byte[1024];
		int len=-1;
		while((len=raf.read(flush))!=-1) {
			if(actualSize>len) {
				raf2.write(flush, 0, len);
				actualSize-=len;
			}else {
				raf2.write(flush, 0,actualSize);
				break;
			}
		}
		raf2.close();
		raf.close();
	}
	
	public static void main(String[] args)throws Exception {
		SplitUtils sp=new SplitUtils("src/com/zengyao/split/SplitUtils.java", "SplitUtils");
		sp.split();
	}
	
	
	
	
	
	
	
	
	
	
	
}
