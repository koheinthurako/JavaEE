package com.sqlDB.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sqlDB.Entity.Category;
import com.sqlDB.Entity.Item;

public interface Item_Service {
	
	public List<Item> get(Connection con) throws SQLException;
	//get item names by specified category
	public List<String> getByCategory(Connection con, Category category) throws SQLException;

}
