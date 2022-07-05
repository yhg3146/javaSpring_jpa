package grade;

public class PassFailEvaluation implements GradeEvaluation {

	@Override
	public String getGrade(int point) {
		String grade;
		if (point >= 70 && point <= 100) {
			return "P";
		} else {
			return "F";
		}
	}
}
