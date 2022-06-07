<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
    <jsp:useBean id="employee" class="com.Employee">
        <jsp:setProperty name="employee" property="empId" value="101"/>
        <jsp:setProperty name="employee" property="fname" value="Krishna"/>
        <jsp:setProperty name="employee" property="lname" value="Huilgol"/>
    </jsp:useBean>

    <h1>Employee Information:</h1>
    Employee Id:<jsp:getProperty property="empId" name="employee"/><br>
    Employee First name:<jsp:getProperty property="fname" name="employee"/><br>
    Employee Last name:<jsp:getProperty property="lname" name="employee"/><br>
    </body>
</html>