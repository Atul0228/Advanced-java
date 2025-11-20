package com.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Student;

public class StudentDAoImpl implements StudentDAo{
	
	static Connection con=null;
	static PreparedStatement insertQuery,updateQuery,selectQuery;
	
	static {
		
		try {
			
		con=DBUtil.getConnection();
		insertQuery=con.prepareStatement("insert into student2 values(?,?,?,?)");
		updateQuery=con.prepareStatement("update student2 set rollno=?, name=?, address=?, dob=? where rollno=?");
		selectQuery=con.prepareStatement("select * from student2");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public boolean addStudent(int id, String name, String add, String dob) 
	{
		
		LocalDate d=LocalDate.parse(dob,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Date sqlDate = Date.valueOf(d);
		try {
			
			insertQuery.setInt(1, id);
			insertQuery.setString(2, name);
			insertQuery.setString(3, add);
			insertQuery.setDate(4, sqlDate);
			
			int n=insertQuery.executeUpdate();
			
			return n>0;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateStudent(int rollno, int newRoll, String name, String add, String dob) {
		
		try {
			updateQuery.setInt(5, rollno);
			
			
			updateQuery.setInt(1, newRoll);
			updateQuery.setString(2, name);
			updateQuery.setString(3, add);
			updateQuery.setString(4, dob);
			
			int n=updateQuery.executeUpdate();
			
			return n>0;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public List<Student> show() {
		
		List<Student> s=new ArrayList<>();
		
		try {
			ResultSet rs=selectQuery.executeQuery();
			
			while(rs.next())
			{
				if(rs.getDate(4)!=null)
				{
					s.add(new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4).toLocalDate()));
				}else {
					s.add(new Student(rs.getInt(1),rs.getString(2),rs.getString(3),null));
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return s;
	}

}
