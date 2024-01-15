package entityTest;

public class ScoreTest {

	private int studentNumber;
	private String subjectNumber;
	private int score;
	private String examinationDate;

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getSubjectNumber() {
		return subjectNumber;
	}

	public void setSubjectNumber(String subjectNumber) {
		this.subjectNumber = subjectNumber;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getExaminationDate() {
		return examinationDate;
	}

	public void setExaminationDate(String examinationDate) {
		this.examinationDate = examinationDate;
	}

	@Override
	public String toString() {
		return String.format("%d\t%s\t%d\t%s", studentNumber, subjectNumber, score, examinationDate);
	}

}
