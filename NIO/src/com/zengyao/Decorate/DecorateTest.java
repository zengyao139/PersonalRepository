package com.zengyao.Decorate;

public class DecorateTest {
	public static void main(String[] args) {
		Drink drink=new Coffer();
		Drink milk =new Milk(drink);
		System.out.println(milk.infor()+"  cost:  "+milk.cost());
		Drink suger =new Super(milk);
		System.out.println(suger.infor()+"  cost:  "+suger.cost());
		
	}
}
interface  Drink{
	
	public double cost();
	
	public String  infor();
}

class Coffer implements Drink{
	
	private double cost=10;
	
	private String name="Coffer";

	@Override
	public double cost() {
		
		return cost;
	}
	
	@Override
	public String infor() {
		return name;
	}
}

/*
abstract class Decorate implements Drink{
	private Drink drink;
	
	
	public Decorate(Drink drink) {
		this.drink=drink;
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return drink.cost();
	}
	
	@Override
	public String infor() {
		// TODO Auto-generated method stub
		return drink.infor();
	}
}*/
abstract class Decorate implements Drink{
	private Drink drink;
	
	public Decorate(Drink drink) {
		this.drink=drink;
	}
	@Override
	public double cost() {
		return this.drink.cost();
	}
	
	@Override
	public String infor() {
		return this.drink.infor();
	}
}



class Milk implements Drink{
	
	private Drink drink;
	
	public Milk(Drink drink) {
		this.drink = drink;
	}

	@Override
	public double cost() {
		return this.drink.cost()*4;
	}

	@Override
	public String infor() {
		return this.drink.infor()+"加入了牛奶  ";
	}
}
class Super implements Drink{
	private Drink drink;
	public Super(Drink drink) {
		this.drink=drink;
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return this.drink.cost()*2;
	}
	@Override
	public String infor() {
		// TODO Auto-generated method stub
		return this.drink.infor()+"加入了蔗糖 ";
	}
}





