package com.mphasis.training.pojos;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mphasis.training.serializers.LocalDateDeserializer;
import com.mphasis.training.serializers.LocalDateSerializer;
//import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

public class Employee {
	
	private int empid;
	private String ename;
	private int salary;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd" )
	@JsonDeserialize(using=LocalDateDeserializer.class)
	@JsonSerialize(using=LocalDateSerializer.class)
	private LocalDate doj;
	private int bonus;
	private String jcode;
	private int deptno;
	private int mgrno;
	
	public Employee() {
		
	}
	
	public Employee(int empid, String ename, int salary, LocalDate doj, int bonus, String jcode, int deptno, int mgrno) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.salary = salary;
		this.doj = doj;
		this.bonus = bonus;
		this.jcode = jcode;
		this.deptno = deptno;
		this.mgrno = mgrno;
	}
	
	

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", salary=" + salary + ", doj=" + doj + ", bonus="
				+ bonus + ", jcode=" + jcode + ", deptno=" + deptno + ", mgrno=" + mgrno + "]";
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public String getJcode() {
		return jcode;
	}

	public void setJcode(String jcode) {
		this.jcode = jcode;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getMgrno() {
		return mgrno;
	}

	public void setMgrno(int mgrno) {
		this.mgrno = mgrno;
	}
	
	
	
	
}
