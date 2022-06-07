<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
   String fname=request.getParameter("fname");
   String lname=request.getParameter("lname");
   Date dob=new Date();
   String dob1=request.getParameter("dob");
   String city=request.getParameter("city");
   String startDateStr = request.getParameter("dob");
   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
   Date date= sdf.parse(startDateStr);
   session.setAttribute("fname",fname);
   session.setAttribute("lname",lname);
   session.setAttribute("dob1",date);
   session.setAttribute("city",city);
   %>
<h3>Welcome <%=fname %></h3>
<form action="Welcome.jsp">
	User name:<input type="text" name="uname">
	Password:<input type="password" name="pwd">
	<input type="submit" value="Login">
</form>
</body>
</html>