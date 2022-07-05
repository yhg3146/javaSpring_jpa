package ch09;

public class SubjectTest {

	public static void main(String[] args) {
		
		Student studentLee = new Student(100,"Lee");
		studentLee.setKoreaSubject("국어", 100);
		studentLee.setMathSubject("수학", 100);
		studentLee.showScoreInfo();
		
		
		Student studentKim = new Student(100,"Kim");
		studentKim.setKoreaSubject("국어", 55);
		studentKim.setMathSubject("수학", 65);
		studentKim.showScoreInfo();
	}

}
