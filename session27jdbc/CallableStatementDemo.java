package session27jdbc;

import java.sql.*;

public class CallableStatementDemo {
    public Connection createConnection(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/JavaTraining", "root", "");
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

    public void getDesiredYear(Connection con,int year){
        String callingProc="{call getDesiredYears(?)}";
        try {
            CallableStatement callableStatement = con.prepareCall(callingProc);
            callableStatement.setInt(1,year);
            ResultSet rs=callableStatement.executeQuery();
            System.out.println("Executed");
            System.out.println("----------------------------------------------------");
            System.out.println("| Id|   Name   |Year|Percentage|    City    |Gender|");
            System.out.println("----------------------------------------------------");
            while (rs.next()) {
                System.out.printf("|%2d |%9s | %2d |   %2.1f   | %10s |  %2s  |\n", rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getNameCity(Connection con){
        try {
            String prepare = "{call getNameCity(?)}";
            CallableStatement callableStatement = con.prepareCall(prepare);
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.executeUpdate();
            String name=callableStatement.getString(1);
            System.out.println("Pimpri student:"+name);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getSGradeStudent(Connection con,float percentage){
        try {
            String prepare = "{call getSGradeStudent(?,?)}";
            CallableStatement callableStatement = con.prepareCall(prepare);
            callableStatement.setFloat(1,percentage);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.executeUpdate();
            String name=callableStatement.getString(2);
            System.out.println("S Grade Student:"+name);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args){
        CallableStatementDemo obj_callable=new CallableStatementDemo();
        Connection con=obj_callable.createConnection();
        //IN callable
        obj_callable.getDesiredYear(con,3);
        //Out callable
        obj_callable.getNameCity(con);
        //IN-OUT callable
        obj_callable.getSGradeStudent(con,90);
    }
}
