package session29jdbccontinue;

import java.sql.*;

public class RollBackDemo {
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
    public void displayTable(Connection con){
        try {
            String query2 = "select * from Employee";
            ResultSet rs;
            PreparedStatement stmt = con.prepareStatement(query2);
            rs = stmt.executeQuery();
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("| ID |   Name   | Desgn|    Date     | Exp |  Salary   |  Status  |   City   |");
            System.out.println("------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("|%2d  |%10s|%5s |%12tF |  %2d |  %6.2f |%9s |%10s|\n", rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertData(Connection con) throws SQLException {
        try {
            String query = "insert into employee(Name,Designation,Doj,Exp,Salary,Status,City) " +
                    "values(\"Nandan\",\"HR\",\"2021-01-03\",0,10000,\"Working\",\"Dharwad\");";
            Statement st = con.createStatement();
            st.executeUpdate(query);
            System.out.println("1 row inserted");
            con.rollback();
        }catch (SQLException e){
            e.printStackTrace();
           // con.rollback();
        }


    }
    public static void main(String[] args){
        RollBackDemo obj_rollback=new RollBackDemo();
        Connection con=obj_rollback.createConnection();
        try {
            con.setAutoCommit(false);
            obj_rollback.insertData(con);
            obj_rollback.displayTable(con);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

/**Output: Before RollBack last row is there in output:
 * Connected
 * 1 row inserted
 * ------------------------------------------------------------------------------
 * | ID |   Name   | Desgn|    Date     | Exp |  Salary   |  Status  |   City   |
 * ------------------------------------------------------------------------------
 * |13  |   Krishna|  ASE |  2022-01-03 |   0 |  11000.00 |  Working |   Dharwad|
 * |15  |     Nidhi|   SE |  2015-06-18 |   6 |  12000.00 |  Working | Hyderabad|
 * |16  |     Rohit|  ASE |  2022-01-17 |   0 |  11000.00 |  Working | Bangalore|
 * |17  |   Praveen|   HR |  2017-11-05 |   4 |  30000.00 |  Working |      Pune|
 * |19  |   Supriya|  ASE |  2018-09-07 |   3 |  30000.00 |  Working |      Pune|
 * |21  |     Vivek|   TE |  2013-09-22 |   8 |  45000.00 |  Working |      Pune|
 * |30  |    Nandan|   HR |  2021-01-03 |   0 |  10000.00 |  Working |   Dharwad|
 *
 * Output: After RollBack last row is not there:
 * ------------------------------------------------------------------------------
 * | ID |   Name   | Desgn|    Date     | Exp |  Salary   |  Status  |   City   |
 * ------------------------------------------------------------------------------
 * |13  |   Krishna|  ASE |  2022-01-03 |   0 |  11000.00 |  Working |   Dharwad|
 * |15  |     Nidhi|   SE |  2015-06-18 |   6 |  12000.00 |  Working | Hyderabad|
 * |16  |     Rohit|  ASE |  2022-01-17 |   0 |  11000.00 |  Working | Bangalore|
 * |17  |   Praveen|   HR |  2017-11-05 |   4 |  30000.00 |  Working |      Pune|
 * |19  |   Supriya|  ASE |  2018-09-07 |   3 |  30000.00 |  Working |      Pune|
 * |21  |     Vivek|   TE |  2013-09-22 |   8 |  45000.00 |  Working |      Pune|
 */