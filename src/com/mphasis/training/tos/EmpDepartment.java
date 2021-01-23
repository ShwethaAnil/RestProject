package com.mphasis.training.tos;

public class EmpDepartment {
	int empid;
	String ename;
	String dname;
	String lname;
	
	public EmpDepartment() {
		
	}
	
	
	
	public EmpDepartment(int empid, String ename, String dname, String lname) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.dname = dname;
		this.lname = lname;
	}



	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	

}
