package com.zengyao.Thread;

public class ThreadTest implements Runnable {
	
	
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("listenning  music");
		try {
			Thread.currentThread().sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	
	public static void main(String[] args)throws Exception {
		ThreadTest thread=new ThreadTest();
		new Thread(thread).start();
		
		for(int i=0;i<20;i++) {
			System.out.println("writing code£¡");
		}
	}
	
	
	
	
	
	

}
