package com.daolayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mysqlqueries.MysqlQueries;
import com.pojo.Person;

@Repository
public class PrsDaoImpl implements PrsDao {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<Person> getAll() {

		List<Person> list = jt.query(MysqlQueries.getAll, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {

				Person p = new Person();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setSalary(rs.getDouble(3));
				return p;
			}
		});

		return list;
	}

	@Override
	public int save(Person p) {

		int i = jt.update(MysqlQueries.insert, new Object[] { p.getId(), p.getName(), p.getSalary() });

		return i;
	}

	@Override
	public int delete(int id) {

		int i = jt.update(MysqlQueries.delete, new Object[] { id });

		return i;
	}

	@Override
	public Person getbyID(int i) {

		Person person = jt.queryForObject(MysqlQueries.getByid, new BeanPropertyRowMapper<>(Person.class),
				new Object[] { i });

		return person;
	}

	@Override
	public int UPDAT(Person p) {
		System.out.println("//////////");
		String up="update person set name=?,salary=? where id=?";
		
		int i = jt.update(up, new Object[] { p.getName(), p.getSalary(), p.getId() });
		
		System.out.println("--------");
		
		
		
		return i;
	}

}
