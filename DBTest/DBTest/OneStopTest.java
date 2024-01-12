package DBTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entiryServiceImplTest.studentServiceImplTest;
import entityServiceTest.studentServiceTest;
import entityTest.Student;

public class OneStopTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		getConnection() method ကိုခေါ်လိုက်တော့ throws ထားတာတွေရှိလို့ ခေါ်လိုက်တဲ့ main method မှာလည်း ပြန် throw ပေးရတယ်
		Connection con = ConnectorTest.getConnection();
		studentServiceTest stuService = new studentServiceImplTest();
		List<Student> students = stuService.get(con);
		students.stream().forEach(System.out::println);
	}

}
