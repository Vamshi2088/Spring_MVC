package com.daoLayer;

import java.util.List;

import com.pojo.Employee;

public interface Dao {
	
	void insert(Employee e);
	
	List<Employee> getAll();
	
	void update(Employee e);
	
	void delete(int id);
	

}
