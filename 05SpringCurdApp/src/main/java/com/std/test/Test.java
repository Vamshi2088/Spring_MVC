package com.std.test;

import java.sql.Connection;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.std.daolayer.StudentDaoImpl;
import com.std.pojo.Student;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext c=new ClassPathXmlApplicationContext("spring.xml");
		 StudentDaoImpl d= (StudentDaoImpl) c.getBean("dao");
		 Student s=new Student(4, "hanuman",36000.00);
//		  System.out.println(d.save(s));
		 System.out.println(d.getAll());
		 
	}
}
