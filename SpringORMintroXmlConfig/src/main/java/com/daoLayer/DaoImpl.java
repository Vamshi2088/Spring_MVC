package com.daoLayer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.pojo.Employee;

public class DaoImpl implements Dao {

	private HibernateTemplate ht;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
 
	@Override 
	public void insert(Employee e) {
		
		ht.save(e);

	}

	@Override
	public List<Employee> getAll() {

		List<Employee> all = ht.loadAll(Employee.class);
		
		return all;
	}

	@Override
	@Transactional
	public void update(Employee e) {
		System.out.println("b------");
		ht.update(e);
		System.out.println("a------");
	}

	@Override
	@Transactional
	public void delete(int id) {
 Employee e=new Employee();
 e.setId(id);
 
		ht.delete(e);
	} 

}
