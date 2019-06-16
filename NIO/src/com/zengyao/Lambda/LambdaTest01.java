package com.zengyao.Lambda;


public class LambdaTest01 {
	
	
	public static void main(String[] args) {
		
		ILove love=(int a)->{
			System.out.println("i like lambda --->"+a);
		};
		love.lambda(100);
		
		love=(a)->{
			System.out.println("i like lambda --->"+a);
		};
		
		love.lambda(50);
		
		love=a->{
			System.out.println("i like lambda --->"+a);
		};
		love.lambda(20);
		
		
		love=a->System.out.println("i like lambda --->"+a);
		love.lambda(10);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}


interface ILove{
	
	void lambda(int a);
}

class Love implements ILove{
	
	@Override
	public void lambda(int a) {
		// TODO Auto-generated method stub
		System.out.println("Love.lambda() ,a="+a);
	}
}