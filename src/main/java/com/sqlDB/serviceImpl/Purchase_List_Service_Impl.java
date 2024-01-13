package com.sqlDB.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sqlDB.Entity.Customer;
import com.sqlDB.Entity.Purchase_Voucher;
import com.sqlDB.service.Purchase_List_Service;

public class Purchase_List_Service_Impl implements Purchase_List_Service{

	@Override
	public List<Purchase_Voucher> getByCustomer(Connection con, Customer c) throws SQLException {
		String sql = "select i_name, qty, price from purchase_List pl, customer c, item i where pl.cus_id = c.c_id and pl.item_id = i.i_id and c.c_name = ?;";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, c.getC_name());
		ResultSet set= stmt.executeQuery();
		List<Purchase_Voucher> list = new ArrayList<Purchase_Voucher>();
		while(set.next()) {
			Purchase_Voucher v1 = new Purchase_Voucher();
			v1.setName(set.getString("i_name"));
			v1.setQty(set.getInt("qty"));
			v1.setAmount(set.getInt(3) * v1.getQty());
			list.add(v1);
		}
		return list;
	}

}
