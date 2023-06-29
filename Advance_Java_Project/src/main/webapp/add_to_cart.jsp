<%@page import="com.dao.ProductDao"%>
<%@page import="com.bean.Product"%>
<%@page import="com.bean.Cart"%>
<%@page import="com.dao.CartDao"%>
<%@page import="java.util.List"%>
<%
	Cart c=new Cart();
	c.setPid(Integer.parseInt(request.getParameter("pid")));
	c.setUid(Integer.parseInt(request.getParameter("uid")));
	Product p=ProductDao.getProductsByPid(c.getPid());
	c.setProduct_price(p.getProduct_price());
	c.setProduct_qty(1);
	c.setTotal_price(p.getProduct_price());
	CartDao.addToCart(c);
	List<Cart> list=CartDao.getCartByUser(c.getUid());
	session.setAttribute("cart_count", list.size());
	response.sendRedirect("cart.jsp");
%>