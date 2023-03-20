package com.controller;

import java.sql.SQLException;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.daolayer.PrsDaoImpl;
import com.pojo.Person;

@Controller
public class Contrl {

	@Autowired
	private PrsDaoImpl ps;

	@RequestMapping(value = "/a", method = RequestMethod.GET)
	public ModelAndView getall() {
		
//		String error="error";
//		if(error.equalsIgnoreCase("Error")) {
//			throw new NullPointerException("you have null pointer");
//		}

		List<Person> all = ps.getAll();

		return new ModelAndView("welcome", "ref", all);

	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public String nullPointer() {
		return "null-exception";
		
	}
	
	@ExceptionHandler(value = SQLException.class)
	public String SqlExc() {
		return "sql-exception";
		
	}
	
	@GetMapping("/reg") 
	public String REGform() {

		return "REGform";

	}

	@PostMapping("/save")
	public String save(Person p) {
		
//		String error="error";
//		if(error.equalsIgnoreCase("Errors")) {
//			throw new IllegalArgumentException("string custom problem");
//		}

		ps.save(p);

		return "redirect:a";

	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		
		ps.delete(id);
		
		return "redirect:a";
		
	}
	
	@GetMapping("/getbyid")
	public ModelAndView getById(@RequestParam("id") Integer id) {
		
		Person person = ps.getbyID(id);
		
		return new ModelAndView("update-form","p",person);
		
	}
	 
	@PostMapping("/update")
	public String update(Person p) {
		ps.UPDAT(p);
		return "redirect:a";
		
	}
}
