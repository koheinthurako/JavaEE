package com.sqlDB.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sqlDB.Entity.Customer;
import com.sqlDB.Entity.Purchase_Voucher;

public interface Purchase_List_Service {

	public List<Purchase_Voucher> getByCustomer(Connection con, Customer c)  throws SQLException ;
	
}
