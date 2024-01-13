package com.sqlDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sqlDB.Entity.Category;
import com.sqlDB.Entity.Customer;
import com.sqlDB.Entity.Item;
import com.sqlDB.Entity.Purchase_Voucher;
import com.sqlDB.Entity.Voucher;
import com.sqlDB.service.Category_Service;
import com.sqlDB.service.Customer_Service;
import com.sqlDB.service.Item_Service;
import com.sqlDB.service.Purchase_List_Service;
import com.sqlDB.service.Voucher_Service;
import com.sqlDB.serviceImpl.Category_Service_Impl;
import com.sqlDB.serviceImpl.Customer_Service_Impl;
import com.sqlDB.serviceImpl.Item_Service_Impl;
import com.sqlDB.serviceImpl.Purchase_List_Service_Impl;
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
		System.out.print("getByName : ");
		System.out.println(service3.getByName(con, "food"));
		System.out.println("");
		
		Item_Service service4 = new Item_Service_Impl();
//		List<Item> items = service4.get(con);
//		System.out.println("--- select * from item ---");
//		items.stream().forEach(System.out::println);
		
//		System.out.println("--- Add new customer ---");
//		Customer cus = new Customer();
//		cus.setC_name("mg mg");
//		cus.setC_ph("529101");
//		Customer new_cus = service1.add(con, cus);
//		System.out.println(new_cus);
		
//		service1.deleteByName(con, "mg mg");
		
//		Item item=new Item("Egg",250,2);
//		Item new_item=service4.add(con, item);
//		System.out.println(new_item);
		
		List<Item> items = service4.get(con);
		System.out.println("--- select * from item ---");
		items.stream().forEach(System.out::println);
		
//		service4.deleteByID(con, 5);
		System.out.println("\n--- Purchase Voucher ---");
		Purchase_List_Service service5 = new Purchase_List_Service_Impl();
		Customer cus = new Customer();
		cus.setC_name("aye aye");
		List<Purchase_Voucher> list = service5.getByCustomer(con, cus);
		int total = 0;
		for(Purchase_Voucher v : list) {
			System.out.println(v);
			total += v.getAmount();
		}
		System.out.println(total);
		
	}

}
