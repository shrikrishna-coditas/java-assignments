<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<% int a=1; %>
<%!
	public static int add(int a,int b){
	return a+b;
	}
%>

<body>
<h3>Scriplet Tag</h3>
<% out.println(a++); %>
<h3>Expression Tag</h3>
<%= a %>
<h3>Function call</h3>
<%= add(9,7) %>
<h3>Return value</h3>
<% int ans=add(10,18); %>
<% out.println(ans); %>
</body>
</html>