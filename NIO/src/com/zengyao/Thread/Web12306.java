package com.zengyao.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author 曾尧
 *
 */
public class Web12306 implements Runnable {
	private int ticketNums=100;
	
	private Object obj=new Object();
	@Override
	public void run() {
		
		while(true) {
			synchronized (obj) {
				if(ticketNums<=0)
					break;
				try {
					 Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"---->"+(ticketNums--));
			}
		}
	}
	public static void main(String[] args) {
		Web12306 web=new Web12306();
		System.out.println(Thread.currentThread().getName());
		ExecutorService  service =Executors.newFixedThreadPool(4);
		for(int i=1;i<101;i++) {
			service.execute(new Thread(web,"ma"+1));
		}
	}
}
