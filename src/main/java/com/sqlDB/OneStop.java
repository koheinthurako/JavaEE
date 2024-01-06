package com.sqlDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.sqlDB.Entity.Customer;
import com.sqlDB.Entity.Voucher;
import com.sqlDB.service.Customer_Service;
import com.sqlDB.service.Voucher_Service;
import com.sqlDB.serviceImpl.Customer_Service_Impl;
import com.sqlDB.serviceImpl.Voucher_Service_Impl;

public class OneStop {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = Connector.getConnection();
		Customer_Service service1 = new Customer_Service_Impl();
		List<Customer> customers = service1.get(con);
//		for(Customer c: customers) { 
//		System.out.println(c);
//		}
//		customers.stream().forEach(System.out::println);
		
		Voucher_Service service2 = new Voucher_Service_Impl();
		List<Voucher> vouchers = service2.get(con);
		vouchers.stream().forEach(System.out::println);
		
		
		
	}

}
