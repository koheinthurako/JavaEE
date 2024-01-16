package entiryServiceImplTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entityServiceTest.scoreServiceTest;
import entityTest.Score;

public class scoreServiceImplTest implements scoreServiceTest{

	@Override
	public List<Score> getAll(Connection con) throws SQLException {
		String sql = "select * from score";
		Statement stmt = con.createStatement();
		ResultSet set = stmt.executeQuery(sql);
		List<Score> scores = new ArrayList<Score>();
		while(set.next()) {
			Score score = new Score();
			score.setStudentNumber(set.getInt(1));
			score.setSubjectNumber(set.getString(2));
			score.setScore(set.getInt(3));
			score.setExaminationDate(set.getString(4));
			scores.add(score);
		}
		return scores;
	}
	
	

}
