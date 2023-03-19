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
		System.out.println(bean.getAll());
		Person p=new Person(20,"name",5600.65);
		System.out.println(bean.save(p));
	}

}
