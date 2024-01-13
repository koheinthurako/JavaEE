package com.sqlDB.serviceImpl;

import java.sql.CallableStatement;
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
	
	@Override
	public Item add(Connection con, Item item) throws SQLException {
		String sql="{call add_item(?,?,?)}";
		CallableStatement ss=con.prepareCall(sql);
		ss.setString(1, item.getI_name());
		ss.setInt(2, item.getPrice());
		ss.setInt(3, item.getCategory_id());
		boolean result=ss.execute();
		Item new_item=new Item();
		if(!result) {
			String sql1="select * from item where i_id in (select max(i_id) from item)";
			PreparedStatement stmt1=con.prepareStatement(sql1);
			ResultSet set=stmt1.executeQuery();
			set.next();
			new_item.setI_id(set.getInt(1));
			new_item.setI_name(set.getString(2));
			new_item.setPrice(set.getInt(3));
			new_item.setStock(set.getInt(4));
			new_item.setCategory_id(set.getInt(5));
		}				
		return new_item;
	}
	
	@Override
	public boolean deleteByID(Connection con, int id) throws SQLException {
		String sql = "delete from item where i_id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
//		အောက်က stmt.execute() က DDL, DML  အကုန်လုံးကို run ပေးနိုင်တယ် DML ဖြစ်တဲ့ select တို့ပါလာရင်
//		DB ထဲမှာက return type က row လိုက်ကြီးထွက်လာလို့ execute() ကို run လိုက်ချိန် ပထမဆုံး output က row ကြီးဖြစ်နေရင်
//		ResultSet ထဲထည့်ရမှာမို့ return true ပြန်ပေးတယ် အဲ့လိုမှမဟုတ်ပဲ တခြား DDL (update, insert, delete) တို့ဆိုရင်
//		execute() ကို run လိုက်လို့ ResultSet ထဲထည့်စရာမလိုရင်တော့ return false ပြန်ပေးတယ်
		stmt.execute();
		System.out.println("Deleted");
		return true;
	}
	
}
