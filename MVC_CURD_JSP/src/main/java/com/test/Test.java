package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daolayer.PrsDaoImpl;
import com.pojo.Person;

public class Test {
	
	public static void main(String[] args) {
		
		ApplicationContext ap=new ClassPathXmlApplicationContext("spring.xml");
		PrsDaoImpl bean = ap.getBean(PrsDaoImpl.class);
//		bean.getAll();
//		System.out.println(bean.getAll());
		Person p=new Person(30,"eshwar",260.00);
//		System.out.println(bean.save(p));
//		System.out.println(bean.delete(20));
//		System.out.println(bean.getbyID(30));
		System.out.println(bean.UPDAT(p));
		
		
	}

}
