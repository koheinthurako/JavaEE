package com.sqlDB.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.sqlDB.Entity.Voucher;
import com.sqlDB.service.Voucher_Service;

public class Voucher_Service_Impl implements Voucher_Service{

	@Override
	public List<Voucher> get(Connection con) throws SQLException {
		List<Voucher> vouchers = new ArrayList<Voucher>();
		String sql = "select * from voucher";
		Statement stmt = con.createStatement();
		ResultSet set = stmt.executeQuery(sql);
		while(set.next()) {
			Voucher c = new Voucher();
			c.setV_id(set.getInt(1));
			c.setDate(set.getString(2));
			vouchers.add(c);
		}
		return vouchers;
	}

	

}
