package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
	public ModelAndView name() {

		List<Person> all = ps.getAll();

		return new ModelAndView("welcome", "ref", all);

	}

	@GetMapping("/reg")
	public String REGform() {

		return "REGform";

	}

	@PostMapping("/save")
	public String save(Person p) {

		ps.save(p);

		return "redirect:a";

	}
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		
		ps.delete(id);
		
		return "redirect:a";
		
	}
	
	@GetMapping("/getbyid")
	public ModelAndView getById(@RequestParam Integer id) {
		
		Person person = ps.getbyID(id);
		
		return new ModelAndView("update-form","p",person);
		
	}
	
	@PostMapping("/update")
	public String update(Person p) {
		ps.UPDAT(p);
		return "redirect:a";
		
	}
}
