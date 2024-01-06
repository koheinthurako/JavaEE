package com.sqlDB.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.sqlDB.Entity.Voucher;

public interface Voucher_Service {
	
	public List<Voucher> get(Connection con) throws SQLException;

}
