package ch06;

public class GenericPrinterTest {

	public static void main(String[] args) {
		
		Powder powder = new Powder();
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();
		powderPrinter.setMaterial(powder);

		System.out.println(powderPrinter.toString());
		
		
		Plastic plastic = new Plastic();
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<>();
		plasticPrinter.setMaterial(plastic);
		System.out.println(plasticPrinter.toString());
	}
	

}
