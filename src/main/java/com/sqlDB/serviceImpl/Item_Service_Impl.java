package com.sqlDB.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sqlDB.Entity.Category;
import com.sqlDB.Entity.Item;
import com.sqlDB.service.Item_Service;

public class Item_Service_Impl implements Item_Service{

	@Override
	public List<Item> get(Connection con) throws SQLException {
		List<Item> items = new ArrayList<Item>();
		String sql = "select * from item";
		Statement stmt = con.createStatement();
		ResultSet set = stmt.executeQuery(sql);
		while(set.next()) {
			Item i = new Item();
			i.setI_id(set.getInt(1));
			i.setI_name(set.getString(2));
			i.setPrice(set.getInt(3));
			i.setStock(set.getInt(4));
			i.setCategory_id(set.getInt(5));
			items.add(i);
		}
		return items;
	}

	@Override
	public List<String> getByCategory(Connection con, Category category) throws SQLException {
		List<String> items = new ArrayList<String>();
		String sql = "select i_name from item i, category c where i.category_id = c.ca_id and ca_description like ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, category.getCa_description());
		ResultSet set = stmt.executeQuery();
		while(set.next()) {
			items.add(set.getString(1));
		}
		return items;
	}

}
