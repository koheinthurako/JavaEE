package com.sqlDB.Entity;

import java.time.LocalDate;

public class Voucher {

	private int v_id;
	private LocalDate date;

	public int getV_id() {
		return v_id;
	}

	public void setV_id(int v_id) {
		this.v_id = v_id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return String.format("%d\t%s", v_id, date);
	}

}
