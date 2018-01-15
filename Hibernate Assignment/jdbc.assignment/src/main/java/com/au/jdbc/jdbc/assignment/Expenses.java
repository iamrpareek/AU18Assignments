package com.au.jdbc.jdbc.assignment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Expenses {
	@Id
	private int eid;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	private int amt;
}
