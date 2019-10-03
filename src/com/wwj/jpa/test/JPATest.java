package com.wwj.jpa.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wwj.jpa.helloworld.Customer;

public class JPATest {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;
	
	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("jpa_demo");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
	}
	
	@After
	public void destory() {
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	@Test
	public void testFind() {
		Customer customer = entityManager.find(Customer.class,1);
		System.out.println(customer);
	}
	
	@Test
	public void testGetReference() {
		Customer customer = entityManager.getReference(Customer.class,1);
		System.out.println(customer);
	}
	
	@Test
	public void testPersist() {
		Customer customer = new Customer();
		customer.setAge(20);
		customer.setBirthday(new Date());
		customer.setEmail("lisi@163.com");
		customer.setLastName("lisi");
		entityManager.persist(customer);
	}
	
	@Test
	public void testRemove() {
//		Customer customer = new Customer();
//		customer.setId(2);
		
		Customer customer = entityManager.find(Customer.class, 2);
		entityManager.remove(customer);
	}
	
	@Test
	public void testMerge() {
		Customer customer = new Customer();
		customer.setAge(20);
		customer.setBirthday(new Date());
		customer.setEmail("wangwu@163.com");
		customer.setLastName("wangwu");
		Customer cst = entityManager.merge(customer);
		System.out.println(customer);
		System.out.println(cst);
	}
	
	@Test
	public void testMerge2() {
		Customer customer = new Customer();
		customer.setAge(20);
		customer.setBirthday(new Date());
		customer.setEmail("zhaoliu@163.com");
		customer.setLastName("zhaoliu");
		//…Ë÷√id Ù–‘
		customer.setId(1024);
		Customer cst = entityManager.merge(customer);
		System.out.println(customer);
		System.out.println(cst);
	}
}
