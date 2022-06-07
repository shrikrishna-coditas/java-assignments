<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        Full name: <%= request.getParameter("fname") %><%= request.getParameter("lname") %>
    </body>
</html>