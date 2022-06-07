package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomePage
 */
@WebServlet(value="/WelcomePage",initParams = { 
		   @WebInitParam(name = "pagename", value = "Login")		   
}) 
public class WelcomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomePage() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Connection createConnection(ServletContext context){
    	//ServletContext context=getServletContext();
        Connection con=null;
        try {
        	String forName=context.getInitParameter("forName");
            Class.forName(forName);
            String url=context.getInitParameter("url");
            String user=context.getInitParameter("username");
            String password=context.getInitParameter("password");
            con = DriverManager.getConnection(url, user, "");
            System.out.println("Connected");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return con;
    }
    public void DisplayData(Connection con,PrintWriter out,HttpServletResponse response){
        try {
            Statement st = con.createStatement();
            String query = "select * from Student";
            ResultSet rs = st.executeQuery(query);
           /* System.out.println("----------------------------------------------------");
            System.out.println("| Id|   Name   |Year|Percentage|    City    |Gender|");
            System.out.println("----------------------------------------------------");
            while (rs.next()) {
                System.out.printf("|%2d |%9s | %2d |   %2.1f   | %10s |  %2s  |\n", rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getString(6));
            }*/
         /*   out.println("----------------------------------------------------");
            out.println("| Id|   Name   |Year|Percentage|    City    |Gender|");
            out.println("----------------------------------------------------");*/
          /*  while (rs.next()) {
                out.printf("|%2d |%9s | %2d |   %2.1f   | %10s |  %2s  |\n", rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getString(6));
            }*/
            response.setContentType("text/html");
            out.println("<head>\r\n"
            		+ "<style>\r\n"
            		+ "table,th,td{\r\n"
            		+ "  border: 1px double black;\r\n"
            		+ "  border-collapse: collapse;\r\n"
            		+ "}\r\n"
            		+ "</style>\r\n"
            		+ "</head><table><tr><th>Id</th>"
            		+ "<th>Name</th><th>Year</th><th>Percentage</th><th>City</th><th>Gender</th></tr>");
            while(rs.next()) {
            	out.println("<tr><td>"+rs.getInt(1)+"</td>"+
            			"<td>"+rs.getString(2)+"</td>"+
            			"<td>"+rs.getInt(3)+"</td>"+
            			"<td>"+rs.getFloat(4)+"</td>"+
            			"<td>"+rs.getString(5)+"</td>"+
            			"<td>"+rs.getString(6)+"</td></tr>");
            }
            out.println("</table>");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletConfig config=getServletConfig();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		out.println("<h1><center>"+config.getInitParameter("pagename")+"</center></h1>");
		//out.println("Welcome to Login page:"+email+"<br>");
		//cookies
		Cookie c[]=request.getCookies();
		out.println("Welcome to Login page:"+c[0].getValue()+"<br>");
		
		//out.println("Welcome to my webpage:"+email+"<br>");
		out.println("<a href=\"ByePage\">Welcome</a>");
		//ServletContext context=config.getServletContext();
		//WelcomePage wp=new WelcomePage();
		//Connection con=wp.createConnection(context);
		//wp.DisplayData(con,out,response);
		
		//Hidden form field
		/*out.println("<form action=\"ByePage\">");
		out.println("<input type='hidden' name='email' value='"+email+"'>");
		out.println("<input type=\"submit\" value=\"Go\">");
		out.println("</form");*/
		
		//Http session
		//HttpSession session=request.getSession();
		//session.setAttribute("email", email);
		
		//url-re-writing
		//out.println("<a href='ByePage?email="+email+"'>visit</a>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
