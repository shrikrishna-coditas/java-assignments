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
			<option selected>Panda</option>
			<option>Elephant</option>
			<option>Dog</option>
		</select>
		<br>
		<input type="submit" value="Check">
	</form>
	<% String imageName = request.getParameter("Images"); %>
	<img src="<%=imageName %>.jpg" width=500 height=300>
	<audio controls autoplay>
  	<source src="<%=imageName %>Audio.mp3" type="audio/mpeg">
  	</audio>
</body>
</html>