package com.std.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.std.daolayer.StudentDaoImpl;
import com.std.pojo.Student;

@Controller
public class Control {

	@Autowired
	private StudentDaoImpl dao;
	
	
	@RequestMapping( value = "/getall",method = RequestMethod.GET)
	public ModelAndView getAll() {
	
		List<Student> list = dao.getAll();
		
		return new ModelAndView("login","map",list);
		
	}
	
	@RequestMapping( value = "/insert",method = RequestMethod.POST)
	public String save(Student s) {
		
		dao.save(s);
		return "redirect:getall";
		
	}
	@RequestMapping( value = "/add",method = RequestMethod.GET)
	public String login() {
		
		return "RegFile";
		
	}
	
	
	
}
