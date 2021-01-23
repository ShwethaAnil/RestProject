package com.mphasis.training.pojos;

public class Location {
	private int lcode;
	private String lname;

	public Location() {

	}

	public Location(int lcode, String lname) {
		super();
		this.lcode = lcode;
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Location [lcode=" + lcode + ", lname=" + lname + "]";
	}

	public int getLcode() {
		return lcode;
	}

	public void setLcode(int lcode) {
		this.lcode = lcode;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}
