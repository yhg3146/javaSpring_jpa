package ch02;

public class Customertest {

	public static void main(String[] args) {

		Customer customerLee=new Customer();
		customerLee.setCustomerName("이순신");
		customerLee.setCustomerID(10010);
		customerLee.bonusPoint = 1000;
		int price = customerLee.calcPrice(1000);
		System.out.println(price);

		System.out.println(customerLee.showCustomerInfo());
		
		VIPCustomer customerKim = new VIPCustomer();
		customerKim.setCustomerName("김유신");
		customerKim.setCustomerID(10020);
		customerKim.bonusPoint = 10000;
		price = customerKim.calcPrice(1000);
		System.out.println(price);
		System.out.println(customerKim.showCustomerInfo());
	}

}
