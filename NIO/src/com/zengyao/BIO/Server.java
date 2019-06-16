package com.zengyao.BIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Server {
	public static void main(String[] args) {
		int port =getPort(args);
		ServerSocket server=null;
		Executor service =Executors.newFixedThreadPool(30);
		
		try {
			
			server= new ServerSocket(port);
			System.out.println("server started!");
			while(true) {
				Socket socket=server.accept();
				service.execute(new Handler(socket));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(server!=null) {
				try {
					server.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			server=null;
		}
	}
	static class Handler implements Runnable{
		Socket socket=null;
		public Handler(Socket socket) {
			this.socket=socket;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			BufferedReader reader=null;
			PrintWriter writer=null;
			try {
				reader =new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				writer =new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
				String readerMessage=null;
				while(true) {
					System.out.println("server reading.....");
					if((readerMessage=reader.readLine())==null) {
						break;
					}
					System.out.println(readerMessage);
					writer.println("server recive: "+readerMessage);
					writer.flush();
				}
			}catch(Exception e) {
				
				e.printStackTrace();
			}finally {
				if(socket!=null) {
					try {
						socket.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				socket=null;
				if(reader!=null) {
					try {
						reader.close();
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
				if(writer!=null) {
					try {
						writer.close();
					} catch (Exception e3) {
						// TODO: handle exception
					}
				}
			}
		}
	}
	public static int getPort(String[] args) {
		if(args.length>0) {
			try {
				return Integer.parseInt(args[0]);
			}catch(NumberFormatException e) {
				return 9999;
			}
		}
		return 9999;
	}
}
