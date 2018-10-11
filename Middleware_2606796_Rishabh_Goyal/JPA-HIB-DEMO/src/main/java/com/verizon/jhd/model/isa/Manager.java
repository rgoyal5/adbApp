package com.verizon.jhd.model.isa;
import javax.persistence.*;
@Entity

//@DiscriminatorValue("memp")

@Table(name="Memps")
public class Manager extends Employee {
	
	private double allowance;
	
	public Manager(){
		
	}

	public Manager(int empId, String ename, double basic,double allowance) {
		super(empId, ename, basic);
		this.allowance=allowance;
		// TODO Auto-generated constructor stub
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}
	
	
	

}
