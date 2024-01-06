package com.sqlDB.Entity;

public class Voucher {

	private int v_id;
	private String date;

	public int getV_id() {
		return v_id;
	}

	public void setV_id(int v_id) {
		this.v_id = v_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return String.format("%d\t%s", v_id, date);
	}

}
