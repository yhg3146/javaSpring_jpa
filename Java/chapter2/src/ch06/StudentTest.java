package ch06;

public class StudentTest {
	
	public static void main(String[] args) {
		Student studentLee = new Student();
		
		System.out.println(studentLee.showStudentInfo());
		
		Student studentkim = new Student(123456,"Kim",3);
		System.out.println(studentkim.showStudentInfo());
	}
}
