package DBTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import entiryServiceImplTest.scoreServiceImplTest;
import entiryServiceImplTest.studentServiceImplTest;
import entiryServiceImplTest.subjectServiceImplTest;
import entityServiceTest.scoreServiceTest;
import entityServiceTest.studentServiceTest;
import entityServiceTest.subjectServiceTest;
import entityTest.Score;
import entityTest.Student;

public class OneStopTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		getConnection() method ကိုခေါ်လိုက်တော့ throws ထားတာတွေရှိလို့ ခေါ်လိုက်တဲ့ main method မှာလည်း ပြန် throw ပေးရတယ်
		Connection con = ConnectorTest.getConnection();
		
		// For Student
		studentServiceTest stuService = new studentServiceImplTest();
		
		// For Subject
		subjectServiceTest subService = new subjectServiceImplTest();
		
		// For Score
		scoreServiceTest scoreService = new scoreServiceImplTest();
		
//		DML for Student
		System.out.println("--- Select * from student ---");
		List<Student> students = stuService.get(con);
		students.stream().forEach(System.out::println);
		
		System.out.println("\n--- select count(*), gender from student group by gender ---");
		List<Student> countGender = stuService.countGender(con);
		countGender.stream().forEach(System.out::println);
		
//		DDL for Student
//		System.out.println("\n--- delete from student where studentNumber = 6726 ---");
//		stuService.deleteByID(con, 6726);
		
//		System.out.println("\n--- insert into student values (6726, 'Thet Zaw Hein', 'Male') ---");
//		System.out.println(stuService.insertStudent(con, 6726, "Thet Zaw Hein", "Male"));
		
//		System.out.println("\n--- create view studentNames as select studentNumber, studentName from student ---");
//		List<Student> studentList = stuService.createView(con);
//		studentList.stream().forEach(System.out::println);
		
		
		
		
//		DML for Subject
		System.out.println("\n--- select * from subject ---");
		List<entityTest.Subject> subjects = subService.getAll(con);
		subjects.stream().forEach(System.out::println);
		
		System.out.println("\n--- select * from subject where subjectNumber = K11 ---");
		System.out.println(subService.getByID(con, "K11"));
		
		
//		DDL for Subject
//		System.out.println("\n--- insert into subject values (K22, Physics) ---");
//		System.out.println(subService.insertSubject(con, "K22", "Physics"));
		
//		System.out.println("\n--- select * from subject where subjectNumber = K22 ---");
//		subService.deleteSubject(con, "K22");
		
		
		
//		DML for Score
		System.out.println("\n--- select * from score ---");
		List<Score> scores = scoreService.getAll(con);
		scores.stream().forEach(System.out::println);
		
		System.out.println("\n--- select st.studentName 'Name', max(score) 'High Score' from score sc, student st\r\n"
				+ "where sc.studentNumber = st.studentNumber\r\n"
				+ "group by sc.studentNumber ---");
		List<Object> highScore = scoreService.getHighScore(con);
		highScore.stream().forEach(System.out::println);
		
		
		
//		DDL for Score
//		System.out.println("\n--- insert into score values (6726, 'K21', 96, '2023-10-21') ---");
//		System.out.println(scoreService.insertScore(con, 6726, "K21", 96, "2023-10-21"));
		
//		System.out.println("\n--- delete from score where studentNumber = 6726 and subjectNumber = 'K21' ---");
//		scoreService.deleteScore(con, 6726, "K21");
		
	}

}
