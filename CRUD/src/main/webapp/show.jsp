<%@page import="com.dao.StudentDao"%>
<%@page import="com.bean.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
     List<Student> list=StudentDao.getAllStudent();   
%>
<table border="5" width="100%" cellpadding="10px" cellspacing="10px">
     <tr>
         <th>ID</th>
         <th>FIRST NAME</th>
         <th>LAST NAME</th>
         <th>EMAIL</th>
         <th>MOBILE</th>
         <th>ADDRESS</th>
     </tr>
    <%
        for(Student s:list)
        {
     %>
     <tr>
         <td><%=s.getId() %></td>
         <td><%=s.getFname() %></td>
         <td><%=s.getLname() %></td>
         <td><%=s.getEmail() %></td>
         <td><%=s.getMobile() %></td>
         <td><%=s.getAddress()  %></td>
     </tr>
     <% 
        }
     %>
</table>
</body>
</html>