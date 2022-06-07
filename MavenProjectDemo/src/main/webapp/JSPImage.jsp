<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Images</title>
</head>
<body>
	<form action="JSPImage.jsp">
		Select Image:<select name="Images">
			<option>Panda</option>
			<option>Elephant</option>
			<option>Dog</option>
		</select>
		<br>
		<input type="submit" value="Check">
	</form>
	<% String imageName = request.getParameter("Images"); %>
	<img src="C:\Users\Coditas\Desktop\AnimalImages\<%=name%>.jpg">
</body>
</html>