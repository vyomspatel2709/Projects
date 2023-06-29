<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<%
    if(request.getAttribute("msg")!=null)
    {
    	out.println(request.getAttribute("msg"));
    }
%>
<form name="insert"method="post"action="StudentController">
     
        <table cellpading="10px" cellspacing="10px">
        <tr>
             <td>First Name</td>              
             <td><input type="text" name="fname"></td>
        </tr>
         <tr>
             <td>Last Name</td>              
             <td><input type="text" name="lname"></td>
        </tr>
         <tr>
             <td>Email</td>              
             <td><input type="text" name="email"></td>
        </tr>
         <tr>
             <td>Mobile</td>              
             <td><input type="text" name="mobile"></td>
        </tr>
         <tr>
             <td>Address</td>              
             <td><textarea rows="5" cols="20" name="address"></textarea></td>
        </tr>
        <tr>
             <td colspan="2" align="center">
             <input type="submit" name="action" value="Insert" class="btn btn-primary ">
             
             </td>
             
        </tr>
        </table>

</form>
<a href="show.jsp">Show All Students</a>
</body>
</html>