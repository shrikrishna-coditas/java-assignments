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
 * Servlet implementation class DineInServlet
 */
@WebServlet("/DineInServlet")
public class DineInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DineInServlet() {
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
    
    public void displayNonReservedTables(Connection con,PrintWriter out,HttpServletResponse response,int noOfPeople,String typeOfTable,String timeSlot) {
    	try {
    		String query="SELECT * FROM tables t where t.tcapacity="+noOfPeople+" and t.ttype=\""+typeOfTable+"\" and NOT EXISTS (SELECT * FROM reserved_tables r WHERE r.tcapacity="+noOfPeople+" and r.ttype=\""+typeOfTable+"\" and t.tid=r.tid);";
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
					+ "<th>Table Number</th>"
					+ "<th>Capacity</th>"
					+ "<th>Table type</th>"
					+ "<th>Select</th>"
					+ "</tr>");
    		int id=0;
    		while(rs.next()) {
    			out.println("<tr>"
    					+ "<td name=\"id\">"+rs.getInt(1)+"</td>"
    					+ "<td>"+rs.getInt(2)+"</td>"
    					+ "<td>"+rs.getString(3)+"</td>"
    					+ "<td><input type=\"radio\" name=\"book\" value=\""+rs.getInt(1)+"\"</td>"
    					+ "</tr>");
    		}
    		
    		out.println("</table>"+"<input type=\"submit\" value=\"BOOK\">"+"</form>");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
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
		DineInServlet obj_dn=new DineInServlet();
		ServletContext context=request.getServletContext();
		PrintWriter out=response.getWriter();
		Connection con=obj_dn.createConnection(context);
		System.out.println("Connected");
		//obj_dn.DisplayData(con, out, response);
		String noOfPeople1=request.getParameter("NoOfPeopleList");
		int noOfPeople=Integer.parseInt(noOfPeople1);
		String typeOfTable=request.getParameter("TableType");
		String timeSlot=request.getParameter("TimeSlot");
		System.out.println(noOfPeople);
		System.out.println(typeOfTable);
		System.out.println(timeSlot);
		int id=0;
		System.out.println("<tr>"
    					+ "<td name=\"id\">"+"rs.getInt(1)"+"</td>"
    					+ "<td>"+"rs.getInt(2)"+"</td>"
    					+ "<td>"+"rs.getString(3)"+"</td>"
    					+ "<td><input type=\"radio\" name=\"book\" value=\""+(id++)+"\""
    					+ "<td><input type=\"submit\" value=\"BOOK\">"
    					+ "</tr>");
		
		obj_dn.displayNonReservedTables(con, out, response,noOfPeople,typeOfTable,timeSlot);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
