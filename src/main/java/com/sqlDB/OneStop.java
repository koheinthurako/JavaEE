package com.sqlDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sqlDB.Entity.Customer;
import com.sqlDB.service.Customer_Service;
import com.sqlDB.serviceImpl.Customer_Service_Impl;

public class OneStop {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = Connector.getConnection();
		Customer_Service service1 = new Customer_Service_Impl();
		List<Customer> customers = service1.get(con);
//		customers.stream().forEach(System.out::println);
//		for(Customer c: customers) { 
//			System.out.println(c);
//		}
		System.out.println(service1.getById(con, 1));
	}

}
