package com.mphasis.training.pojos;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Product {
	private String pid;
	private String pname;
	private int qty;
	private double cost;
	

	private double ratings;
	
	public Product() {
		
	}

	public Product(String pid, String pname, int qty, double cost) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.cost = cost;
	}

	public Product(String pid, String pname, int qty, double cost, double ratings) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.cost = cost;
		this.ratings = ratings;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", cost=" + cost + ", ratings=" + ratings
				+ "]";
	}
	
	
	
	

}
