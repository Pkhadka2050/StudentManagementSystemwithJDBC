package com.takeo.query;

public interface QueryConstants {
	
	public String STUDENT_INSERT_QUERY="insert into studentinfo(fname,lname,sadd,email) values(?,?,?,?)";
	
	public String STUDENT_SELECT_QUERY="select *from studentinfo";
	
	public String STUDENT_UPDATE_QUERY="update studentinfo set fname=?, lname=?, sadd=?, email=? where sid=?";
	
	public String STUDENT_DELETE_QUERY="delete from studentinfo where sid=?";
	
	public String STUDENT_VIEWSPECIFIC_QUERY="select * from studentinfo where sid=?";

}
