package com.sqlDB.Entity;

public class Category {

	private int ca_id;
	private String ca_description;

	public int getCa_id() {
		return ca_id;
	}

	public void setCa_id(int ca_id) {
		this.ca_id = ca_id;
	}

	public String getCa_description() {
		return ca_description;
	}

	public void setCa_description(String ca_description) {
		this.ca_description = ca_description;
	}

	@Override
	public String toString() {
		return String.format("%d\t%s", ca_id, ca_description);
	}

}
