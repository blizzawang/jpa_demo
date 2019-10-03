package com.wwj.jpa.helloworld;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	
	public static void main(String[] args) {
		
		//1������EntityManagerFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_demo");
//		Map<String,Object> properties = new HashMap<String,Object>();
//		properties.put("hibernate.show_sql",false);
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_demo", properties);
		//2������EntityManager
		EntityManager manager = factory.createEntityManager();
		//3����������
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		//4�����г־û�����
		Customer customer = new Customer();
		customer.setAge(20);
		customer.setEmail("zhangsan@163.com");
		customer.setLastName("zhangsan");
		customer.setBirthday(new Date());
		manager.persist(customer);
		//5���ύ����
		transaction.commit();
		//6���ͷ���Դ
		manager.close();
		factory.close();
	}
}
