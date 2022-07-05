package ch09;

public class LocalVariableInfo {

	public static void main(String[] args) {
		var i =10;
		var j =10.0;
		var str = "Hello";
		
		System.out.println(str);
		System.out.println(i);
		System.out.println(j);
		
		str ="world";
		System.out.println(str);
		}

}
