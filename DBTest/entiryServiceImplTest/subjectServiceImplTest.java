package entiryServiceImplTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entityServiceTest.subjectServiceTest;
import entityTest.Subject;

public class subjectServiceImplTest implements subjectServiceTest{

	@Override
	public List<Subject> getAll(Connection con) throws SQLException {
		String sql = "select * from subject";
		Statement stmt = con.createStatement();
		ResultSet set = stmt.executeQuery(sql);
		List<Subject> subjects = new ArrayList<Subject>();
		while(set.next()) {
			Subject sub = new Subject();
			sub.setSubjectNumber(set.getString(1));
			sub.setSubjectName(set.getString(2));
			subjects.add(sub);
		}
		return subjects;
	}
	
	@Override
	public Subject getByID(Connection con, String subjectNumber) throws SQLException {
		String sql = "select * from subject where subjectNumber = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, subjectNumber);
		ResultSet set = stmt.executeQuery();
		Subject sub = new Subject();
		if(set.isBeforeFirst()) {
			set.next();
			sub.setSubjectNumber(set.getString(1));
			sub.setSubjectName(set.getString(2));
			return sub;
		}
		
		return null;
	}

	@Override
	public Subject insertSubject(Connection con, String subjectNumber, String subjectName) throws SQLException {
		Subject subject = new Subject();
		String sql = "insert into subject values (?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, subjectNumber);
		stmt.setString(2, subjectName);
		boolean checker = stmt.execute();
		if(!checker) {
			String sql2 = "select * from subject where subjectNumber = ?";
			stmt = con.prepareStatement(sql2);
			stmt.setString(1, subjectNumber);
			ResultSet set = stmt.executeQuery();
			set.next();
			subject.setSubjectName(set.getString(1));
			subject.setSubjectNumber(set.getString(2));
			return subject;
		}
		return null;
	}

	@Override
	public boolean deleteSubject(Connection con, String subjectNumber) throws SQLException {
		String sql = "delete from subject where subjectNumber = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, subjectNumber);
		boolean checker = stmt.execute();
		if(!checker) System.err.println("Deleted!");
		else System.err.println("Something wrong!");
		return false;
	}

	
}
