package com.sqlDB.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.sqlDB.Entity.Category;

public interface Category_Service {
	
	public List<Category> get(Connection con) throws SQLException;

}
