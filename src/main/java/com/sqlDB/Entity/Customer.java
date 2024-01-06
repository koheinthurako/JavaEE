package com.sqlDB.Entity;

public class Customer {

	private int c_id;
	private String c_name;
	private String c_ph;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_ph() {
		return c_ph;
	}

	public void setC_ph(String c_ph) {
		this.c_ph = c_ph;
	}

	@Override
	public String toString() {
		return String.format("%d\t%s\t\t%s", c_id, c_name, c_ph);
//		return "Customer [c_id=" + c_id + ", c_name=" + c_name + ", c_ph=" + c_ph + "]";
	}

}
