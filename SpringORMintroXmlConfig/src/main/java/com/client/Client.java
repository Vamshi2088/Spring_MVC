package com.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daoLayer.DaoImpl;
import com.pojo.Employee;

public class Client {
	
	public static void main(String[] args) {
		
		Employee e=new Employee(2, "hanuman", 25000.00);
		
		ApplicationContext ap=new ClassPathXmlApplicationContext("spring.xml");
		
		DaoImpl bean = ap.getBean("x",DaoImpl.class);
		
//		bean.insert(e);
//		
//	System.out.println(bean.getAll());	
		
//		bean.update(e);
		
//		bean.delete(1);
		
		
		
	}

}
