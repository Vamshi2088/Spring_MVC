package com.mysqlqueries;

public interface MysqlQueries {
	
	String getAll="select * from person";
	
	String insert="insert into person values(?,?,?)";
	
	String delete="delete from person where id=?";
	
	String getByid="select * from person where id=?";
	
	String update="update person set name=?, salary=? where id=?";

}
