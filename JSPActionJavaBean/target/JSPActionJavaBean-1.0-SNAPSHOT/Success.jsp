<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="ISO-8859-1">
    <title>Success</title>
</head>
<body>
    <% String uname=(String)session.getAttribute("session-uid");
    out.println("Welcome: "+uname);
    %>
</body>
</html>