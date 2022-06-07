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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
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
            System.out.println("Connected confirm");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return con;
    }
    
    public void bookTable(Connection con,PrintWriter out,HttpServletResponse response,int id,String rid,String fname,String lname,long contact) {
    	try {
    		int tid=0;;
    		String tcapacity=null;
    		String ttype=null;
    		String query="select * from tables where tid="+id+";";
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery(query);
    		while(rs.next()) {
    		tid=rs.getInt(1);
    		tcapacity=rs.getString(2);
    		ttype=rs.getString(3);
    		
    		}
    		String query1="insert into reserved_tables values("+tid+","+tcapacity+","+"\""+ttype+"\","+"\""+rid+"\","+"\""+fname+"\","+"\""+lname+"\","+"\""+contact+"\");";
    		st.executeUpdate(query1);
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String fname=request.getParameter("FirstName");
		BookServlet bs=new BookServlet();
		Connection con=bs.createConnection(getServletContext());
		String lname=request.getParameter("LastName");
		String rid=request.getParameter("Email");
		String contact=request.getParameter("Phone");
		long contactNo=Long.parseLong(contact);
		Cookie c[]=request.getCookies();
		String id1=c[0].getValue();
		System.out.println("id="+id1);
		int id=Integer.parseInt(id1);
		bs.bookTable(con, out, response, id, rid, fname, lname, contactNo);
		out.println("Dear "+fname+", Your table has been successfully booked<br>Thank you!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
