<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <jsp:forward page="Header.jsp">
            <jsp:param value="Krishna" name="data"/>
            <jsp:param value="22-03-2000" name="data1"/>
        </jsp:forward>
    </body>
</html>
