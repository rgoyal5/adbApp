package com.verizon.jhd.model.isa;
import javax.persistence.*;
@Entity

//@DiscriminatorValue("cemp")
@Table(name="Cemp")
public class ContractEmployee extends Employee {
	@Column(name="cdur")
	private int contractDuration;
	
	public ContractEmployee(){
		
	}

	public ContractEmployee(int empId, String ename, double basic, int cduration) {
		super(empId, ename, basic);
		this.contractDuration=cduration;
		// TODO Auto-generated constructor stub
	}

	public int getContractDuration() {
		return contractDuration;
	}

	public void setContractDuration(int contractDuration) {
		this.contractDuration = contractDuration;
	}
	
	

	
}
