package com.mphasis.training.pojos;

public class Department {
	private int deptno;
	private String dname;
	private int lcode;

	public Department() {

	}

	public Department(int deptno, String dname, int lcode) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.lcode = lcode;
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", dname=" + dname + ", lcode=" + lcode + "]";
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getLcode() {
		return lcode;
	}

	public void setLcode(int lcode) {
		this.lcode = lcode;
	}

}
