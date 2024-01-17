package entityServiceTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entityTest.Score;

public interface scoreServiceTest {

	public List<Score> getAll(Connection con) throws SQLException;
	public Score insertScore(Connection con, int studentNumber, String subjectNumber, int score, String date) throws SQLException;
	public boolean deleteScore(Connection con, int studentNumber, String subjectNumber) throws SQLException;
	public List<Object> getHighScore(Connection con) throws SQLException;

}
