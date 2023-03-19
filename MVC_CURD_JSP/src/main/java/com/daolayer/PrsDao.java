package com.daolayer;

import java.util.List;

import com.pojo.Person;

public interface PrsDao {
	
	List<Person> getAll();
	
	int save(Person p);

}
