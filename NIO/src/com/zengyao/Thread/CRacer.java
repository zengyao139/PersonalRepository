package com.zengyao.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CRacer implements Callable<Integer> {
	
	private String winner=null;
	
	@Override
	public Integer call() throws Exception {
		for(int steps=1;steps<=100;steps++) {
			if(Thread.currentThread().getName().equals("pool-1-thread-1") && steps%10==0) {
				Thread.sleep(100);
			}
			System.out.println(Thread.currentThread().getName()+"---->"+steps);
			boolean flag=isOver(steps);
			if(flag)
				return steps;
		}
		return null;
	}
	
	public boolean isOver(int steps) {
		if(winner!=null)
			return true;
		else {
			if(steps==100) {
				winner=Thread.currentThread().getName();
				System.out.println("winner---->"+winner);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CRacer c=new CRacer();
		
		ExecutorService service =Executors.newFixedThreadPool(2);
		
		
		Future<Integer> result1=service.submit(c);
		Future<Integer> result2=service.submit(c);
		
		
		int r1=result1.get();
		int r2=result2.get();
		
		System.out.println(r1+"---"+r2);
		service.shutdownNow();
	}
	
	
	
}
