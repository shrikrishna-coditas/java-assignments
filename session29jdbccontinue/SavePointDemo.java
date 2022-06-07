package session29jdbccontinue;

import java.sql.*;

public class SavePointDemo {
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

    public void displayData(Connection con){
        try{
            String query="Select * from student1";
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery(query);
            System.out.println("-------------------------");
            System.out.println("| SId |   SName   | TId |");
            System.out.println("-------------------------");
            while (rs.next()){
                System.out.printf("| %2d  |%9s  | %2d  |\n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void updateTable(Connection con,SavePointDemo obj_sp){
        try{
            String query="Delete from student1 where TId=4";
            Statement st=con.createStatement();
            Savepoint beforeDelete=con.setSavepoint();
            System.out.println("Added savepoint");
            st.executeUpdate(query);
            st.executeUpdate(query);
            System.out.println("\n1 Row Deleted");
            obj_sp.displayData(con);
            System.out.println("\nRoll back to savepoint");
            con.rollback(beforeDelete);
            obj_sp.displayData(con);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        SavePointDemo obj_sp=new SavePointDemo();
        Connection con=obj_sp.createConnection();
        try {
            con.setAutoCommit(false);
            obj_sp.displayData(con);
            obj_sp.updateTable(con,obj_sp);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

/**Output:
 * Connected
 * -------------------------
 * | SId |   SName   | TId |
 * -------------------------
 * |  1  |  Krishna  |  1  |
 * |  2  |   Kartik  |  2  |
 * |  3  |  Sridevi  |  3  |
 * |  4  |   Manasa  |  4  |
 * Added savepoint
 *
 * 1 Row Deleted
 * -------------------------
 * | SId |   SName   | TId |
 * -------------------------
 * |  1  |  Krishna  |  1  |
 * |  2  |   Kartik  |  2  |
 * |  3  |  Sridevi  |  3  |
 *
 * Roll back to savepoint
 * -------------------------
 * | SId |   SName   | TId |
 * -------------------------
 * |  1  |  Krishna  |  1  |
 * |  2  |   Kartik  |  2  |
 * |  3  |  Sridevi  |  3  |
 * |  4  |   Manasa  |  4  |
 */