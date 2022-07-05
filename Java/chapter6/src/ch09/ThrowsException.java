package ch09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsException {
	
	public Class loadClass(String fileName, String className) throws FileNotFoundException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		Class c =Class.forName(className);
		return c;
	}
	public static void main(String[] args) {
			ThrowsException test= new ThrowsException();
			
			try {
				test.loadClass("a.txt","java.lang.String");
				
			} catch (FileNotFoundException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			} catch(Exception e) {
				
			}
		System.out.println("end");
	}

}
