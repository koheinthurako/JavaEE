package com.sqlDB.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sqlDB.Entity.Customer;
import com.sqlDB.service.Customer_Service;

public class Customer_Service_Impl implements Customer_Service{

	@Override
	public List<Customer> get(Connection con) throws SQLException {
		List<Customer> customers = new ArrayList<Customer>();
		String sql = "select * from customer";
		Statement stmt = con.createStatement();
		ResultSet set = stmt.executeQuery(sql);
		while(set.next()) {
			Customer c = new Customer();
//			"() ထဲက 1 2 3 တို့သည် column count"
			c.setC_id(set.getInt("c_id"));
			c.setC_name(set.getString("c_name"));
			c.setC_ph(set.getString("c_ph"));
			customers.add(c);
		}
		return customers;
	}

	@Override
	public Customer getById(Connection con, int id) throws SQLException {
		String sql = "select * from customer where c_id = " + id;
		Statement stmt = con.createStatement();
		ResultSet set = stmt.executeQuery(sql);
		if(set.isBeforeFirst()) {
			set.next();
			Customer c = new Customer();
			c.setC_id(set.getInt("c_id"));
			c.setC_name(set.getString("c_name"));
			c.setC_ph(set.getString("c_ph"));
			return c;
		}
			return null;
	}
	
	

}
