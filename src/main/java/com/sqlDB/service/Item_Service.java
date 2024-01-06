package com.sqlDB.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sqlDB.Entity.Item;

public interface Item_Service {
	
	public List<Item> get(Connection con) throws SQLException;

}
