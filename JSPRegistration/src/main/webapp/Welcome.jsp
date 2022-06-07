<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
   String fname=(String)session.getAttribute("fname");
   String lname=(String)session.getAttribute("lname");
   Date dob=(Date)session.getAttribute("dob1");
   String city=(String)session.getAttribute("city");
   %>
<p>Your Full name is:<%=fname %> <%=lname %></p>
<p>You are from:<%=city %></p>
<p>Date of Birth:<%=dob %></p>
</body>
</html>