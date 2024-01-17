package entiryServiceImplTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entityServiceTest.scoreServiceTest;
import entityTest.Score;
import entityTest.Student;

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

	@Override
	public Score insertScore(Connection con, int studentNumber, String subjectNumber, int score, String date) throws SQLException {
		Score sc = new Score();
		String sql = "insert into score values (?,?,?,?);";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, studentNumber);
		stmt.setString(2, subjectNumber);
		stmt.setInt(3, score);
		stmt.setString(4, date);
		boolean checker = stmt.execute();
		if(!checker) {
			String sql2 = "select * from score where studentNumber = ? and subjectNumber = ?";
			stmt = con.prepareStatement(sql2);
			stmt.setInt(1, studentNumber);
			stmt.setString(2, subjectNumber);
			ResultSet set = stmt.executeQuery();
			set.next();
			sc.setStudentNumber(set.getInt(1));
			sc.setSubjectNumber(set.getString(2));
			sc.setScore(score);
			sc.setExaminationDate(date);
			return sc;
		}
		return null;
	}

	@Override
	public boolean deleteScore(Connection con, int studentNumber, String subjectNumber) throws SQLException {
		String sql = "delete from score where studentNumber = ? and subjectNumber = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, studentNumber);
		stmt.setString(2, subjectNumber);
		boolean checker = stmt.execute();
		if(!checker) System.err.println("Deleted!");
		else System.err.println("Something wrong!");
		return false;
	}

	@Override
	public List<Object> getHighScore(Connection con) throws SQLException {
		String sql = "select st.studentName 'Name', max(score) 'High Score' from score sc, student st\r\n"
				+ "where sc.studentNumber = st.studentNumber\r\n"
				+ "group by sc.studentNumber";
		Statement stmt = con.createStatement();
		ResultSet set = stmt.executeQuery(sql);
		List<Object> stringObj = new ArrayList<Object>();
		while(set.next()) {
			Score sc = new Score();
			Student stu = new Student();
			stu.setStudentName(set.getString(1));
			sc.setScore(set.getInt(2));
			stringObj.add(stu.getStudentName()+"\t\t"+sc.getScore());
		}
		return stringObj;
	}
	
	

}
