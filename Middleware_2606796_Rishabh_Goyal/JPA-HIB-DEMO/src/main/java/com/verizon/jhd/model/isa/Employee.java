package com.verizon.jhd.model.isa;
import javax.persistence.*;



@Entity
/*@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="etypr",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("emp")
@Table(name="AllEmps")*/

@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="Emps")
public class Employee {

	@Id
	private int empId;
	private String ename;
	private double basic;
	
	public Employee(){
		
	}
	
	public Employee(int empId,String ename,double basic){
		
		this.empId=empId;
		this.ename=ename;
		this.basic=basic;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}
	
	
}
