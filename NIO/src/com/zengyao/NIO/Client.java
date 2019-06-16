package com.zengyao.NIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		InetSocketAddress host=new InetSocketAddress("localhost",9999);
		SocketChannel client=null;
		
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		
		
		try {
			client=SocketChannel.open();
			client.connect(host);
			Scanner input=new Scanner(System.in);
			String message="";
			while(true) {
				System.out.println("send informations to server-->");
				message=input.nextLine();
				if(message.equals("exit"))
					break;
				buffer.put(message.getBytes("utf-8"));
				buffer.flip();
				client.write(buffer);
				buffer.clear();
	
				//读取来自server端数据
				int readLength=client.read(buffer);
				if(readLength==-1) {
					break;
				}
				buffer.flip();
				byte[] datas=new byte[buffer.remaining()];
				buffer.get(datas);
				System.out.println("from server's informations is --->"+new String(datas,"utf-8"));
				buffer.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(null!=client) {
				try {
					client.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}
