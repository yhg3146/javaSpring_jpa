package ch15;

public class Customer implements Buy, Sell {

	@Override
	public void sell() {
		
		System.out.println("customer sell");
		
	}

	@Override
	public void buy() {
		System.out.println("customer buy");
		
	}

	@Override
	public void order() {
		// TODO Auto-generated method stub
		Sell.super.order();
	}
	
	public void hello() {
		System.out.println("hello");
	}
	
}
