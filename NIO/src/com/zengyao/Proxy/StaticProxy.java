package com.zengyao.Proxy;

public class StaticProxy {

	public static void main(String[] args) {
		You you =new You();
		WeddingCompary wed=new WeddingCompary(you);
		wed.marry();

	}

}



interface Marry{
	
	public void marry();
}


class You implements Marry{

	@Override
	public void marry() {
		System.out.println("���ں�  mode��s host marryied");
	}
}

class WeddingCompary implements Marry{
	
	private Marry marryObject;
	
	
	public WeddingCompary(Marry object) {
		marryObject=object;
	}
	@Override
	public void marry() {
		ready();
		marryObject.marry();
		after();
	}
	public void ready() {
		System.out.println("��������");
	}
	public void  after() {
		System.out.println("��ʰ����");
	}
}