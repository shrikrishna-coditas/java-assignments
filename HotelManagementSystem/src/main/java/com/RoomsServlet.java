package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RoomsServlet
 */
@WebServlet("/RoomsServlet")
public class RoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomsServlet() {
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
    
    public void displayNonReseervedRooms(Connection con,PrintWriter out,HttpServletResponse response,String rtype) {
    	try {
    		String query="SELECT * FROM rooms r where r.rtype=\""+rtype+"\" and NOT EXISTS (SELECT * FROM reserved_rooms m WHERE m.rtype=\""+rtype+"\" and r.rid=m.rid);";
    		System.out.println(query);
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery(query);
    		response.setContentType("text/html");
    		
    		out.println("<head>\r\n"
            		+ "<style>\r\n"
            		+ "table,th,td{\r\n"
            		+ "  border: 1px double black;\r\n"
            		+ "  border-collapse: collapse;\r\n"
            		+ "}\r\n"
            		+ "</style>\r\n"
            		+ "</head>"
            		+ "<form action=\"RedirectRegsiterServlet\">"
            		+ "<table>"
					+ "<tr>"
					+ "<th>Room Number</th>"
					+ "<th>Room Type</th>"
					+ "<th>Room Price</th>"
					+ "<th>Select</th>"
					+ "</tr>");
    		int id=0;
    		while(rs.next()) {
    			out.println("<tr>"
    					+ "<td name=\"id\">"+rs.getInt(1)+"</td>"
    					+ "<td>"+rs.getString(2)+"</td>"
    					+ "<td>"+rs.getInt(3)+"</td>"
    					+ "<td><input type=\"radio\" name=\"book\" value=\""+rs.getInt(1)+"\"</td>"
    					+ "</tr>");
    		}
    		
    		out.println("</table>"+"<input type=\"submit\" value=\"BOOK\">"+"</form>");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RoomsServlet rs=new RoomsServlet();
		ServletContext context=request.getServletContext();
		Connection con=rs.createConnection(context);
		String rtype=request.getParameter("RoomType");
		PrintWriter out=response.getWriter();
		rs.displayNonReseervedRooms(con, out, response, rtype);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
