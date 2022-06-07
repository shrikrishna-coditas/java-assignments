package session27jdbc;

import java.sql.*;
import java.util.Scanner;

class StudentMethods{
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

    public void DisplayData(Connection con){
        try {
            Statement st = con.createStatement();
            String query = "select * from Student";
            ResultSet rs = st.executeQuery(query);
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

    public void addGenderColumn(Connection con){
        try {
            Statement st;
            String query = "Alter Table Student Add Gender char(1)";
            st = con.createStatement();
            st.executeUpdate(query);
            System.out.println("Added Gender Column");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void fetchThirdSeventy(Connection con){
        try{
            Statement st;
            String query="select Id,Name,Year,Percentage from Student where Year=3 and Percentage>70";
            st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            System.out.println("---------------------------------");
            System.out.println("| Id |  Name  | Year |Percentage|");
            System.out.println("---------------------------------");
            while (rs.next()){
                System.out.printf("| %2d |%7s |%5d |   %2.1f   |\n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getFloat(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void fetchIds(Connection con){
        try{
            String query="select * from Student where id>0 and id<11";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
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

    public void addThreeRecords(Connection con){
        Scanner sc=new Scanner(System.in);
        int rows=0;
        try {
            for(int i=1;i<=3;i++) {
                String query = "insert into student(Name,Year,Percentage,City,Gender) " +
                        "values(?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);

                System.out.println("**Enter details for adding new student:"+i+" ***");

                System.out.println("Enter student name");
                String name=sc.nextLine();
                pst.setString(1,name);

                System.out.println("Enter student year");
                int year=sc.nextInt();
                pst.setInt(2,year);

                System.out.println("Enter student percentage");
                float percentage=sc.nextFloat();
                pst.setFloat(3,percentage);

                sc.nextLine();
                System.out.println("Enter student city");
                String city=sc.nextLine();
                pst.setString(4,city);

                System.out.println("Enter student gender M/F?");
                String gender=sc.nextLine();
                pst.setString(5,gender);

                rows=rows+pst.executeUpdate();
            }

            System.out.println(rows+" rows inserted");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateNames(Connection con){
        try{
            String query="Update Student Set Name=CONCAT('Mr.',Name) where Gender='M'";
            String query2="Update Student Set Name=CONCAT('Ms.',Name) where Gender='F'";
            Statement st=con.createStatement();
            st.executeUpdate(query);
            st.executeUpdate(query2);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteFourthYear(Connection con){
        try{
            String query="Delete from Student where year=4";
            Statement st=con.createStatement();
            st.executeUpdate(query);
            System.out.println("Deleted 4th year details");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
public class StudentDemo {
    public static void main(String[] args){

            StudentMethods obj_student=new StudentMethods();
            Connection con=obj_student.createConnection();

            obj_student.DisplayData(con);
            obj_student.addGenderColumn(con);
            obj_student.fetchThirdSeventy(con);
            obj_student.fetchIds(con);
            obj_student.addThreeRecords(con);
            obj_student.updateNames(con);
            obj_student.deleteFourthYear(con);
    }
}

/**Output after calling createConnection():
 * Connected
 *
 * Output after calling DisplayData(con):
 * ---------------------------------------------
 * | Id|   Name   |Year|Percentage|    City    |
 * ---------------------------------------------
 * | 1 |  Krishna |  4 |   80.1   |    Dharwad |
 * | 2 |    Nidhi |  3 |   75.6   |       Pune |
 * | 3 |    Rohit |  3 |   66.4   |      Delhi |
 * | 4 |    Kajal |  3 |   92.4   |  Bangalore |
 * | 5 |   Gautam |  4 |   82.5   |   Belagavi |
 * | 6 |    Suman |  3 |   77.3   |     Mumbai |
 * | 7 |    Jyoti |  1 |   55.8   |       Pune |
 * | 8 |    Tejas |  2 |   48.7   |     Pimpri |
 * | 9 |   Lokesh |  4 |   78.5   |      Hubli |
 * |10 |    Vivek |  4 |   65.3   |    Dharwad |
 * |11 |    Vidya |  4 |   94.8   |      Sirsi |
 * |12 |    Kavya |  3 |   64.9   |  Hyderabad |
 * |13 |    Suraj |  2 |   49.2   |  Bangalore |
 * |14 |   Adarsh |  1 |   83.4   |        Goa |
 *
 * Output: After calling addGenderColumn(con)
 * Added Gender Column
 *
 * Case 1:Output to check new column: Calling DisplayData(con):
 * ----------------------------------------------------
 * | Id|   Name   |Year|Percentage|    City    |Gender|
 * ----------------------------------------------------
 * | 1 |  Krishna |  4 |   80.1   |    Dharwad | null |
 * | 2 |    Nidhi |  3 |   75.6   |       Pune | null |
 * | 3 |    Rohit |  3 |   66.4   |      Delhi | null |
 * | 4 |    Kajal |  3 |   92.4   |  Bangalore | null |
 * | 5 |   Gautam |  4 |   82.5   |   Belagavi | null |
 * | 6 |    Suman |  3 |   77.3   |     Mumbai | null |
 * | 7 |    Jyoti |  1 |   55.8   |       Pune | null |
 * | 8 |    Tejas |  2 |   48.7   |     Pimpri | null |
 * | 9 |   Lokesh |  4 |   78.5   |      Hubli | null |
 * |10 |    Vivek |  4 |   65.3   |    Dharwad | null |
 * |11 |    Vidya |  4 |   94.8   |      Sirsi | null |
 * |12 |    Kavya |  3 |   64.9   |  Hyderabad | null |
 * |13 |    Suraj |  2 |   49.2   |  Bangalore | null |
 * |14 |   Adarsh |  1 |   83.4   |        Goa | null |
 *
 * Output after updating Gender column values:
 * ----------------------------------------------------
 * | Id|   Name   |Year|Percentage|    City    |Gender|
 * ----------------------------------------------------
 * | 1 |  Krishna |  4 |   80.1   |    Dharwad |   M  |
 * | 2 |    Nidhi |  3 |   75.6   |       Pune |   F  |
 * | 3 |    Rohit |  3 |   66.4   |      Delhi |   M  |
 * | 4 |    Kajal |  3 |   92.4   |  Bangalore |   F  |
 * | 5 |   Gautam |  4 |   82.5   |   Belagavi |   M  |
 * | 6 |    Suman |  3 |   77.3   |     Mumbai |   F  |
 * | 7 |    Jyoti |  1 |   55.8   |       Pune |   F  |
 * | 8 |    Tejas |  2 |   48.7   |     Pimpri |   M  |
 * | 9 |   Lokesh |  4 |   78.5   |      Hubli |   M  |
 * |10 |    Vivek |  4 |   65.3   |    Dharwad |   M  |
 * |11 |    Vidya |  4 |   94.8   |      Sirsi |   F  |
 * |12 |    Kavya |  3 |   64.9   |  Hyderabad |   F  |
 * |13 |    Suraj |  2 |   49.2   |  Bangalore |   M  |
 * |14 |   Adarsh |  1 |   83.4   |        Goa |   M  |
 *
 * Case 2:Output: Fetching records who are in third year and percentage>70
 * ---------------------------------
 * | Id |  Name  | Year |Percentage|
 * ---------------------------------
 * |  2 |  Nidhi |    3 |   75.6   |
 * |  4 |  Kajal |    3 |   92.4   |
 * |  6 |  Suman |    3 |   77.3   |
 *
 * Case 3:Output: Fetching records who's id is between 1 and 10
 * ----------------------------------------------------
 * | Id|   Name   |Year|Percentage|    City    |Gender|
 * ----------------------------------------------------
 * | 1 |  Krishna |  4 |   80.1   |    Dharwad |   M  |
 * | 2 |    Nidhi |  3 |   75.6   |       Pune |   F  |
 * | 3 |    Rohit |  3 |   66.4   |      Delhi |   M  |
 * | 4 |    Kajal |  3 |   92.4   |  Bangalore |   F  |
 * | 5 |   Gautam |  4 |   82.5   |   Belagavi |   M  |
 * | 6 |    Suman |  3 |   77.3   |     Mumbai |   F  |
 * | 7 |    Jyoti |  1 |   55.8   |       Pune |   F  |
 * | 8 |    Tejas |  2 |   48.7   |     Pimpri |   M  |
 * | 9 |   Lokesh |  4 |   78.5   |      Hubli |   M  |
 * |10 |    Vivek |  4 |   65.3   |    Dharwad |   M  |
 *
 * Case 4.1: Adding 3 records by calling addThreeRecords(con):
 * **Enter details for adding new student:1 ***
 * Enter student name
 * Nikita
 * Enter student year
 * 2
 * Enter student percentage
 * 67.2
 * Enter student city
 * Hubli
 * Enter student gender M/F?
 * F
 * **Enter details for adding new student:2 ***
 * Enter student name
 * Prasad
 * Enter student year
 * 1
 * Enter student percentage
 * 88.4
 * Enter student city
 * Mysore
 * Enter student gender M/F?
 * M
 * **Enter details for adding new student:3 ***
 * Enter student name
 * Satvik
 * Enter student year
 * 4
 * Enter student percentage
 * 74.5
 * Enter student city
 * Delhi
 * Enter student gender M/F?
 * M
 * 3 rows inserted
 *
 * Output: for verifying calling DisplayData(con):
 * ----------------------------------------------------
 * | Id|   Name   |Year|Percentage|    City    |Gender|
 * ----------------------------------------------------
 * | 1 |  Krishna |  4 |   80.1   |    Dharwad |   M  |
 * | 2 |    Nidhi |  3 |   75.6   |       Pune |   F  |
 * | 3 |    Rohit |  3 |   66.4   |      Delhi |   M  |
 * | 4 |    Kajal |  3 |   92.4   |  Bangalore |   F  |
 * | 5 |   Gautam |  4 |   82.5   |   Belagavi |   M  |
 * | 6 |    Suman |  3 |   77.3   |     Mumbai |   F  |
 * | 7 |    Jyoti |  1 |   55.8   |       Pune |   F  |
 * | 8 |    Tejas |  2 |   48.7   |     Pimpri |   M  |
 * | 9 |   Lokesh |  4 |   78.5   |      Hubli |   M  |
 * |10 |    Vivek |  4 |   65.3   |    Dharwad |   M  |
 * |11 |    Vidya |  4 |   94.8   |      Sirsi |   F  |
 * |12 |    Kavya |  3 |   64.9   |  Hyderabad |   F  |
 * |13 |    Suraj |  2 |   49.2   |  Bangalore |   M  |
 * |14 |   Adarsh |  1 |   83.4   |        Goa |   M  |
 * |15 |   Nikita |  2 |   67.2   |      Hubli |   F  |
 * |16 |   Prasad |  1 |   88.4   |     Mysore |   M  |
 * |17 |   Satvik |  4 |   74.5   |      Delhi |   M  |
 *
 * Case 4.2: if gender is M adding Mr if F then add Ms. for names:
 * ----------------------------------------------------
 * | Id|   Name   |Year|Percentage|    City    |Gender|
 * ----------------------------------------------------
 * | 1 |Mr.Krishna |  4 |   80.1   |    Dharwad |   M  |
 * | 2 | Ms.Nidhi |  3 |   75.6   |       Pune |   F  |
 * | 3 | Mr.Rohit |  3 |   66.4   |      Delhi |   M  |
 * | 4 | Ms.Kajal |  3 |   92.4   |  Bangalore |   F  |
 * | 5 |Mr.Gautam |  4 |   82.5   |   Belagavi |   M  |
 * | 6 | Ms.Suman |  3 |   77.3   |     Mumbai |   F  |
 * | 7 | Ms.Jyoti |  1 |   55.8   |       Pune |   F  |
 * | 8 | Mr.Tejas |  2 |   48.7   |     Pimpri |   M  |
 * | 9 |Mr.Lokesh |  4 |   78.5   |      Hubli |   M  |
 * |10 | Mr.Vivek |  4 |   65.3   |    Dharwad |   M  |
 * |11 | Ms.Vidya |  4 |   94.8   |      Sirsi |   F  |
 * |12 | Ms.Kavya |  3 |   64.9   |  Hyderabad |   F  |
 * |13 | Mr.Suraj |  2 |   49.2   |  Bangalore |   M  |
 * |14 |Mr.Adarsh |  1 |   83.4   |        Goa |   M  |
 * |15 |Ms.Nikita |  2 |   67.2   |      Hubli |   F  |
 * |16 |Mr.Prasad |  1 |   88.4   |     Mysore |   M  |
 * |17 |Mr.Satvik |  4 |   74.5   |      Delhi |   M  |
 *
 * Case 4.3: Remove last year students:
 * Output by Calling deleteFourthYear(con):
 * Deleted 4th year details
 *
 * Output: Verifying Case 4.3 by calling displayData(Con):
 * ----------------------------------------------------
 * | Id|   Name   |Year|Percentage|    City    |Gender|
 * ----------------------------------------------------
 * | 2 | Ms.Nidhi |  3 |   75.6   |       Pune |   F  |
 * | 3 | Mr.Rohit |  3 |   66.4   |      Delhi |   M  |
 * | 4 | Ms.Kajal |  3 |   92.4   |  Bangalore |   F  |
 * | 6 | Ms.Suman |  3 |   77.3   |     Mumbai |   F  |
 * | 7 | Ms.Jyoti |  1 |   55.8   |       Pune |   F  |
 * | 8 | Mr.Tejas |  2 |   48.7   |     Pimpri |   M  |
 * |12 | Ms.Kavya |  3 |   64.9   |  Hyderabad |   F  |
 * |13 | Mr.Suraj |  2 |   49.2   |  Bangalore |   M  |
 * |14 |Mr.Adarsh |  1 |   83.4   |        Goa |   M  |
 * |15 |Ms.Nikita |  2 |   67.2   |      Hubli |   F  |
 * |16 |Mr.Prasad |  1 |   88.4   |     Mysore |   M  |
 */