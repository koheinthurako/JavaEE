package entityTest;

public class Student {

//	entity တွေကို database ထဲက table တွေအတိုင်းရေးရပြီး table data တွေကို java ထဲက variable တွေကနေတစ်ဆင့် လက်ခံတယ်
	private int studentNumber;
	private String studentName;
	private String gender;

	public Integer getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		if(this.studentName==null) return String.format("%d\t%s", studentNumber, gender);
		return String.format("%d\t%s\t\t%s", studentNumber, studentName, gender);
	}

}
