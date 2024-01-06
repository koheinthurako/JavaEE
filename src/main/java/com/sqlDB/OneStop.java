package com.sqlDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sqlDB.Entity.Category;
import com.sqlDB.Entity.Customer;
import com.sqlDB.Entity.Item;
import com.sqlDB.Entity.Voucher;
import com.sqlDB.service.Category_Service;
import com.sqlDB.service.Customer_Service;
import com.sqlDB.service.Item_Service;
import com.sqlDB.service.Voucher_Service;
import com.sqlDB.serviceImpl.Category_Service_Impl;
import com.sqlDB.serviceImpl.Customer_Service_Impl;
import com.sqlDB.serviceImpl.Item_Service_Impl;
import com.sqlDB.serviceImpl.Voucher_Service_Impl;

public class OneStop {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = Connector.getConnection();
		Customer_Service service1 = new Customer_Service_Impl();
		List<Customer> customers = service1.get(con);
//		for(Customer c: customers) { 
//		System.out.println(c);
//		}
		System.out.println("--- select * from cusomter ---");
		customers.stream().forEach(System.out::println);
		System.out.println("");
		
		Voucher_Service service2 = new Voucher_Service_Impl();
		List<Voucher> vouchers = service2.get(con);
		System.out.println("--- select * from voucher ---");
		vouchers.stream().forEach(System.out::println);
		System.out.println("");
		
		Category_Service service3 = new Category_Service_Impl();
		List<Category> categories = service3.get(con);
		System.out.println("--- select * from category ---");
		categories.stream().forEach(System.out::println);
		System.out.println("");
		
		Item_Service service4 = new Item_Service_Impl();
		List<Item> items = service4.get(con);
		System.out.println("--- select * from item ---");
		items.stream().forEach(System.out::println);
		
	}

}
