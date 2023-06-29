package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.Employee;
import com.util.EmployeeUtil;

public class EmployeeDao {

		public static void insertemployee(Employee c)
		{
			try {
				Connection conn=EmployeeUtil.createConnection();
				String sql="insert into credentials(ename,email,age,address) values(?,?,?,?)";
				PreparedStatement pst=conn.prepareStatement(sql);
					pst.setString(1, c.getEname());
					pst.setString(2, c.getEmail());
					pst.setInt(3, c.getAge());
					pst.setString(4, c.getAddress());
					pst.executeUpdate(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
