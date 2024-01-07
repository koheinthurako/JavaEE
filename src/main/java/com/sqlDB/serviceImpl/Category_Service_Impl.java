package com.sqlDB.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sqlDB.Entity.Category;
import com.sqlDB.service.Category_Service;

public class Category_Service_Impl implements Category_Service{

	@Override
	public List<Category> get(Connection con) throws SQLException {
		List<Category> categories = new ArrayList<Category>();
		String sql = "select * from category";
		Statement stmt = con.createStatement();
		ResultSet set = stmt.executeQuery(sql);
		while(set.next()) {
			Category c = new Category();
			c.setCa_id(set.getInt(1));
			c.setCa_description(set.getString(2));
			categories.add(c);
		}
		return categories;
	}
	
	@Override
	public Category getByName(Connection con, String s) throws SQLException {
		String sql = "select * from category where ca_description = ?";
//		Statement stmt = con.createStatement();
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, s);
		ResultSet set = stmt.executeQuery();
		Category c = new Category();
		if(set.isBeforeFirst()) {
			set.next();
			c.setCa_id(set.getInt(1));
			c.setCa_description(set.getString(2));
		}
		return c;
	}
	

}
