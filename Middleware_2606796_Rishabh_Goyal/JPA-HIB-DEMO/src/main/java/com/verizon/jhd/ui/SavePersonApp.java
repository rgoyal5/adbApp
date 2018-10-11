package com.verizon.jhd.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.verizon.jhd.model.Book;
import com.verizon.jhd.model.Gender;
import com.verizon.jhd.model.Person;
import com.verizon.jhd.util.JPAUtil;

public class SavePersonApp {

	public static void main(String args[])
	{
		Person p1 =  new Person("Srinu","Jha",Gender.Male,true,LocalDate.of(1995,06,11));
		Person p2 =  new Person("Rishabh","Goyal",Gender.Male,true,LocalDate.of(1995,07,10));
		
		
		EntityManager em =  JPAUtil.getEntityManagerFactory().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();
		System.out.println("Data Peristed");
		JPAUtil.shutdown();
	}
}
