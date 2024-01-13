package com.sqlDB.Entity;

public class Purchase_List {

	private int p_id;
	private int v_id;
	private int item_id;
	private int qty;
	private int cus_id;
	
	public Purchase_List(int v_id, int item_id, int qty, int cus_id) {
		super();
		this.v_id = v_id;
		this.item_id = item_id;
		this.qty = qty;
		this.cus_id = cus_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getV_id() {
		return v_id;
	}

	public void setV_id(int v_id) {
		this.v_id = v_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getCus_id() {
		return cus_id;
	}

	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}

	@Override
	public String toString() {
		return "Purchase_List [p_id=" + p_id + ", v_id=" + v_id + ", item_id=" + item_id + ", qty=" + qty + ", cus_id="
				+ cus_id + "]";
	}

}
