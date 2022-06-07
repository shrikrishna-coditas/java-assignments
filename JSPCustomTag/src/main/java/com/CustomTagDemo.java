package com;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class CustomTagDemo extends SimpleTagSupport{
	public void doTag() throws JspException,IOException{
		JspWriter out=getJspContext().getOut();
		out.println("<body>\r\n"
				+ "	<form action=\"JSPImage.jsp\">\r\n"
				+ "		Select Image:<select name=\"Images\">\r\n"
				+ "			<option selected>Panda</option>\r\n"
				+ "			<option>Elephant</option>\r\n"
				+ "			<option>Dog</option>\r\n"
				+ "		</select>\r\n"
				+ "		<br>\r\n"
				+ "		<input type=\"submit\" value=\"Check\">\r\n"
				+ "	</form>\r\n"
				+ "</body>");
	}
}
