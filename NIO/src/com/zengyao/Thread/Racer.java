package com.zengyao.Thread;

public class Racer implements Runnable{
	
	private String winner=null;

	@Override
	public void run() {
		for(int steps=1;steps<=100;steps++) {
			if(Thread.currentThread().getName().equals("rabbit")&& steps%10==0) {
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"---->"+steps);
			boolean flag=isOver(steps);
		}
	}
	public boolean isOver(int steps) {
		if(winner!=null)
			return true;
		else {
			if(steps==100) {
				winner=Thread.currentThread().getName();
				System.out.println("winner----->"+winner);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Racer racer=new Racer();
		new Thread(racer,"tortoise").start();
		new Thread(racer,"rabbit").start();
	}
}
