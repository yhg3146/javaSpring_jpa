package ch19;

public class WhippingCream extends Decorator {

	public WhippingCream(Coffee coffee) {
		super(coffee);
	
	}
	
	public void brewing() {
		super.brewing();
		System.out.print("Adding whipping cream");
	}

}
