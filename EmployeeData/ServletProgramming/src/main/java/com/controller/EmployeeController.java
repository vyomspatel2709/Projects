package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Employee;
import com.dao.EmployeeDao;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String action=request.getParameter("action");
   		if(action.equalsIgnoreCase("insert"))
   		{
   			Employee c=new Employee();
   			c.setEname(request.getParameter("ename"));
   			c.setEmail(request.getParameter("email"));
   			c.setAge(Integer.parseInt(request.getParameter("age")));
   			c.setAddress(request.getParameter("address"));
   			EmployeeDao.insertemployee(c);
   		}
   	}

}
