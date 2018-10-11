package com.verizon.jhd.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.composition.HallTicket;
import com.verizon.jhd.model.composition.Identification;
import com.verizon.jhd.model.isa.ContractEmployee;
import com.verizon.jhd.model.isa.Employee;
import com.verizon.jhd.model.isa.Manager;
import com.verizon.jhd.util.JPAUtil;

public class IsDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HallTicket emp1=new HallTicket("101","Rishabh","50000",new Identification());
		//ContractEmployee c1=new ContractEmployee(102,"Rishabh",5000,45);
		//Manager memp1=new Manager(103,"Ronak",5000,5000);

		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction Txn=em.getTransaction();
		
		Txn.begin();
		em.persist(emp1);
		Txn.commit();
		JPAUtil.shutdown();
	}

}
