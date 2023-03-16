package com.std.daolayer;

import java.util.List;

import com.std.pojo.Student;

public interface StudentDao {

	int save(Student s);
	
	List<Student> getAll();
}
