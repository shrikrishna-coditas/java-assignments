<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="ISO-8859-1">
    <title>Action</title>
</head>
<body>
    <% String uname=request.getParameter("uname");
       String pwd=request.getParameter("pwd");

       session.setAttribute("session-uid",uname);

       if(uname.equals(pwd)){
            response.sendRedirect("Success.jsp");
       }
       else{
            response.sendRedirect("Failure.jsp");
       }
       %>
</body>
</html>