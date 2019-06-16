package com.zengyao.URL;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;

public class URLReadResources {
	public static void main(String[] args) throws Exception{
		main3();
		
	}
	public static void main3() {
		File file=new File("src/test-copy-2.txt");
		OutputStream os=null;
		try {
			os=new BufferedOutputStream(new FileOutputStream(file));
			String message="this is test informations to test-copy-2.txt";
			byte[] flush=message.getBytes();
			os.write(flush);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=os) {
					os.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
	}
	
	
	
	public static void main2() {
		File file=new File("src/test.txt");
		InputStream is=null;
		BufferedInputStream bis=null;
		try {
			is=new FileInputStream(file);
			bis=new BufferedInputStream(is);
			byte[] flush=new byte[1024];
			int len=0;
			while((len=bis.read(flush))!=-1) {
				System.out.println(new String(flush,0,len));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(null!=bis) {
					bis.close();
				}
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			try {
				if(null!=is) {
					is.close();
				}
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
	
	
	
	public static void RandomFile()throws Exception {
		URL url=new URL("http://www.runoob.com/");
		URLConnection uRLConnection=url.openConnection();
		InputStreamReader isr=new InputStreamReader(uRLConnection.getInputStream());
		BufferedReader br=new BufferedReader(isr);
		
		
		while(true) {
			String message=br.readLine();
			if(message==null) {
				break;
			}
			System.out.println(message);
		}
		br.close();
	}
	public static void IO2() {
		File src=new File("src/test.txt");
		InputStream is=null;
		try {
			is=new FileInputStream(src);
			int temp=0;
			while((temp=is.read())!=-1) {
				System.out.println((char)temp);
			}
		} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(is!=null) {
					is.close();
				}
			}catch(Exception e) {
					e.printStackTrace();
			}
		}
	}
	
	public static byte[] fileToByteArray(String filepath) {
		File file=new File(filepath);
		byte[] dest=null;
		InputStream is=null;
		ByteArrayOutputStream baos=null;
		try {
			is=new FileInputStream(file);
			baos=new ByteArrayOutputStream();
			byte[] flush=new byte[1024];
			int len=-1;
			while((len=is.read(flush))!=-1) {
				baos.write(flush,0,len);
			}
			baos.flush();
			return baos.toByteArray();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e1) {
			e1.printStackTrace();
		}finally {
			try {
				if(null!=is) {
					is.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void arrayToOutputFile(byte[] out) {
		File dest=new File("src/test-copy.txt");
		InputStream is=null;
		OutputStream os=null;
		try {
			is=new ByteArrayInputStream(out);
			os=new FileOutputStream(dest);
			byte[] flush=new byte[3];
			int len=-1;
			while((len=is.read(flush))!=-1) {
				os.write(flush, 0, len);
			}
			os.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=os) {
					os.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	
	
	
	public static void main1() {
		arrayToOutputFile(fileToByteArray("src/test.txt"));
	}
}
