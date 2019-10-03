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
		
		//1、创建EntityManagerFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_demo");
//		Map<String,Object> properties = new HashMap<String,Object>();
//		properties.put("hibernate.show_sql",false);
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_demo", properties);
		//2、创建EntityManager
		EntityManager manager = factory.createEntityManager();
		//3、开启事务
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		//4、进行持久化操作
		Customer customer = new Customer();
		customer.setAge(20);
		customer.setEmail("zhangsan@163.com");
		customer.setLastName("zhangsan");
		customer.setBirthday(new Date());
		manager.persist(customer);
		//5、提交事务
		transaction.commit();
		//6、释放资源
		manager.close();
		factory.close();
	}
}
