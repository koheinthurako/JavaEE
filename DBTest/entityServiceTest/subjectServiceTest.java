package entityServiceTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entityTest.Subject;

public interface subjectServiceTest {
	
	public List<Subject> getAll(Connection con) throws SQLException;
	public Subject getByID(Connection con, String subjectNumber) throws SQLException;
	public Subject insertSubject(Connection con, String subjectNumber, String subjectName) throws SQLException;
	public boolean deleteSubject(Connection con, String subjectNumber) throws SQLException;

}
