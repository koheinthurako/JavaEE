package entityTest;

public class Subject {

	private String SubjectNumber;
	private String SubjectName;

	public String getSubjectNumber() {
		return SubjectNumber;
	}

	public void setSubjectNumber(String subjectNumber) {
		SubjectNumber = subjectNumber;
	}

	public String getSubjectName() {
		return SubjectName;
	}

	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}

	@Override
	public String toString() {
		return String.format("%s\t%s", SubjectNumber, SubjectName);
	}

}
