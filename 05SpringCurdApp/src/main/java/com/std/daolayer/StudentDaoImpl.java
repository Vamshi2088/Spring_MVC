package com.std.daolayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.std.pojo.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jt;
	


	@Override
	public int save(Student s) {

		String insert="insert into student values(?,?,?)";
		int i = jt.update(insert,
				new Object[] {s.getId(),s.getName(),s.getSalary()});
	
		return i;
	}




	@Override
	public List<Student> getAll() {

		
		String retrive="select * from student";
		
		List<Student> list = jt.query(retrive, new RowMapper<Student>() {
			
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

				Student s=new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setSalary(rs.getDouble(3));
				
				
				return s;
			}
		});
		
		return list;
	}
	

	
}
