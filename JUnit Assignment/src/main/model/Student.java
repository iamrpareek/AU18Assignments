package model;

import java.util.Date;

public class Student {

	private int regNo;
	private String fname;
	private String lName;
	private String address;
	private Date dob;
	private int contactNo;
	private int sem;
	private String branch;

	
	public Student(int regNo, String fname, String lName, String address, Date dob, int contactNo, int sem,
			String branch) {
		super();
		this.regNo = regNo;
		this.fname = fname;
		this.lName = lName;
		this.address = address;
		this.dob = dob;
		this.contactNo = contactNo;
		this.sem = sem;
		this.branch = branch;
	}





		public int getregNo() {
		return regNo;
	}


	public void setregNo(int regNo) {
		this.regNo = regNo;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public int getContactNo() {
		return contactNo;
	}


	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}


	public int getsem() {
		return sem;
	}


	public void setsem(int sem) {
		this.sem = sem;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Student() {	}

}
