package com.verizon.bsa.model;

public class Employee {

	private int eid;
	private String name;
	private double basic;
	private int hra;
	private String dept;
	
public Employee(){
		
	}
	public Employee(int eid, String name, double basic, int hra, String dept) {
		super();
		this.eid=eid;
		this.name=name;
		this.basic=basic;
		this.hra=hra;
		this.dept=dept;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public int getHra() {
		return hra;
	}
	public void setHra(int hra) {
		this.hra = hra;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
}
