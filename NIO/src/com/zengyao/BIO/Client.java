package com.zengyao.BIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		String host=null;
		int port=0;
		List<String> list=new ArrayList<String>();
		if(args.length>2) {
			host=args[0];
			port=Integer.parseInt(args[1]);
		}else {
			host="127.0.0.1";
			port=9999;
		}
		Socket socket=null;
		BufferedReader reader=null;
		PrintWriter writer=null;
		Scanner input=new Scanner(System.in);
		try {
			socket=new Socket(host,port);
			String message=null;
			reader =new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			writer=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			while(true) {
				message=input.nextLine();
				if(message.equals("exit")) {
					break;
				}
				writer.println(message);
				writer.flush();
				System.out.println(reader.readLine());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(socket != null){
				try {
					socket.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			socket = null;
			if(reader!=null) {
				try {
					reader.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(writer != null){
				writer.close();
			}
			writer = null;
		}
	}
}
