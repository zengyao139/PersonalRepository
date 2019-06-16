package com.zengyao.Lambda;

public class LambdaTest02 {

	public static void main(String[] args) {
		
		IInterest interest=(int a,int b)->{
			System.out.println(" i like lambda "+(a+b));
			return a+b;
		};
		interest.lambda(100, 200);
		
		interest=(a,b)->{
			System.out.println(" i like lambda "+(a+b));
			return a+b;
		};
		
		interest.lambda(10, 20);
		
		interest=(a,c)->{
			return (a+c);
		};
		
		System.out.println(interest.lambda(20, 20));
		
		interest=(a,c)->100;
		System.out.println(interest.lambda(1, 2));
		
	}
}
interface IInterest{
	int lambda(int a, int b);
}

class Interest implements IInterest{
	
	@Override
	public int lambda(int a, int b) {
		System.out.println("Interest.lambda()");
		return a+b;
	}
}