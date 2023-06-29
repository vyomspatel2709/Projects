package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Student;
import com.util.StudentUtil;

public class StudentDao {

	public static void insertStudent(Student s)
	{
	     try {
            Connection conn=StudentUtil.createconnection();
            String sql="insert into student(fname,lname,email,mobile,address) values(?,?,?,?,?)";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, s.getFname());
            pst.setString(2, s.getLname());
            pst.setString(3, s.getEmail());
            pst.setLong(4, s.getMobile());
            pst.setString(5, s.getAddress());
            pst.executeUpdate();
	     } catch (Exception e) {

           e.printStackTrace();
		}	
	}
	public static List<Student> getAllStudent()
	{
		List<Student> list=new ArrayList<Student>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mwf_5","root","");
			String sql="Select * from student";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Student s=new Student();
				s.setId(rs.getInt("id"));
				s.setFname(rs.getString("fname"));
				s.setLname(rs.getString("lname"));
				s.setEmail(rs.getString("email"));
				s.setMobile(rs.getLong("mobile"));
				s.setAddress(rs.getString("address"));
				list.add(s);
			}
			conn.close(); 
			
		} catch (Exception e) {
           e.printStackTrace();
		}
		return  list;
	}
}
