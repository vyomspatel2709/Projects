<%@page import="com.dao.ProductDao"%>
<%
	
	int pid=Integer.parseInt(request.getParameter("pid"));
	ProductDao.deleteProductByPid(pid);
	response.sendRedirect("seller_view_product.jsp");

%>