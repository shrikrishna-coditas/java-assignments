<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        Name: <%= request.getParameter("data") %><br>
        Birthday: <%= request.getParameter("data1") %><hr>
    </body>
    <jsp:include page="Footer.jsp">
        <jsp:param value="Krishna" name="fname"/>
        <jsp:param value="Huilgol" name="lname"/>
    </jsp:include>
</html>