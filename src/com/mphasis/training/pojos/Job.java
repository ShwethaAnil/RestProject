package com.mphasis.training.pojos;

public class Job {
	private String jcode;
	private String jname;

	public Job() {

	}

	public Job(String jcode, String jname) {
		super();
		this.jcode = jcode;
		this.jname = jname;
	}

	@Override
	public String toString() {
		return "Job [jcode=" + jcode + ", jname=" + jname + "]";
	}

	public String getJcode() {
		return jcode;
	}

	public void setJcode(String jcode) {
		this.jcode = jcode;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

}
