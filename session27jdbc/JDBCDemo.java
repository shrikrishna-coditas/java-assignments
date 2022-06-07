package session27jdbc;

import java.sql.*;
import java.util.Scanner;
class AllCases{
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

    public void addRecords(Connection con){
        Scanner sc=new Scanner(System.in);
        try {
            String query = "insert into employee(Name,Designation,Doj,Exp,Salary,Status) " +
                    "values(?,?,?,?,?,?);";
            PreparedStatement stmt = con.prepareStatement(query);
            int rows = 0;
            for (int i = 1; i <=10 ; i++) {
                System.out.println("****Enter Details of employee: "+i+" ****");
                System.out.println("Enter Employee name");
                String name = sc.nextLine();
                stmt.setString(1, name);

                System.out.println("Enter Employee designation");
                String designation = sc.nextLine();
                stmt.setString(2, designation);

                System.out.println("Enter joining date in yyyy-mm-dd format");
                String dates = sc.nextLine();
                Date date = Date.valueOf(dates);
                stmt.setDate(3, date);

                System.out.println("Enter experience in years");
                int exp = sc.nextInt();
                stmt.setInt(4, exp);

                System.out.println("Enter salary");
                float salary = sc.nextFloat();
                stmt.setFloat(5, salary);

                sc.nextLine();
                System.out.println("Working/left?");
                String status = sc.nextLine();
                stmt.setString(6, status);
                rows = rows + stmt.executeUpdate();
            }
            System.out.println(rows + " rows inserted");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void displayTable(Connection con){
        try {
            String query2 = "select * from Employee";
            ResultSet rs;
            PreparedStatement stmt = con.prepareStatement(query2);
            rs = stmt.executeQuery();
            System.out.println("------------------------------------------------------------------------");
            System.out.println("| ID |   Name   | Desgn|    Date     | Exp |  Salary   |  Status  | City");
            System.out.println("------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("|%2d  |%10s|%5s |%12tF |  %2d |  %5.2f |%9s |%8s\n", rs.getInt(1),
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

    public void addColumnCity(Connection con){
        try {
            Statement st;
            String query3 = "ALTER TABLE employee ADD COLUMN City varchar(15);";
            st = con.createStatement();
            st.executeUpdate(query3);
            System.out.println("Added column city");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateAllCities(Connection con){
        Scanner sc=new Scanner(System.in);
        try{
            for(int i=13;i<=22;i++) {
                System.out.println("Enter City for employee id:"+i);
                String city=sc.nextLine();
                String query4 = "UPDATE Employee SET City = ? WHERE Id = ?;";
                PreparedStatement stmt = con.prepareStatement(query4);
                stmt.setString(1, city);
                stmt.setInt(2, i);
                stmt.executeUpdate();
            }
            System.out.println("All cities updated");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void fetchPuneEmployees(Connection con){
        try{
            Statement st;
            ResultSet rs;
            String query5="select id,name from employee where city=\"Pune\" and salary>20000";
            st= con.createStatement();
            rs=st.executeQuery(query5);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateSalary(Connection con){
        try{
            Statement st;
            String query6="Update employee set Salary=1000 where Exp>3";
            st= con.createStatement();
            st.executeUpdate(query6);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteLeftEmployees(Connection con){
        try{
            Statement st;
            String query7="Delete from employee where Status=\"Left\";";
            st= con.createStatement();
            st.executeUpdate(query7);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
public class JDBCDemo {
    public static void main(String[] args){
        try{
            AllCases obj_cases=new AllCases();
            Connection con=obj_cases.createConnection();
            obj_cases.addRecords(con);
            obj_cases.displayTable(con);
            obj_cases.addColumnCity(con);
            obj_cases.updateAllCities(con);
            obj_cases.displayTable(con);
            obj_cases.fetchPuneEmployees(con);
            obj_cases.updateSalary(con);
            obj_cases.displayTable(con);
            obj_cases.deleteLeftEmployees(con);
            obj_cases.displayTable(con);

            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}

/**Output for createConnection() call:
 * Connected
 *
 * Output for addRecords(con) call:
 * ****Enter Details of employee: 1 ****
 * Enter Employee name
 * Krishna
 * Enter Employee designation
 * ASE
 * Enter joining date in yyyy-mm-dd format
 * 2022-01-03
 * Enter experience in years
 * 0
 * Enter salary
 * 11000
 * Working/left?
 * Working
 * ****Enter Details of employee: 2 ****
 * Enter Employee name
 * Suraj
 * Enter Employee designation
 * QA
 * Enter joining date in yyyy-mm-dd format
 * 2019-08-24
 * Enter experience in years
 * 2
 * Enter salary
 * 20000
 * Working/left?
 * Left
 * ****Enter Details of employee: 3 ****
 * Enter Employee name
 * Nidhi
 * Enter Employee designation
 * SE
 * Enter joining date in yyyy-mm-dd format
 * 2015-06-18
 * Enter experience in years
 * 6
 * Enter salary
 * 50000
 * Working/left?
 * Working
 * ****Enter Details of employee: 4 ****
 * Enter Employee name
 * Rohit
 * Enter Employee designation
 * ASE
 * Enter joining date in yyyy-mm-dd format
 * 2022-01-17
 * Enter experience in years
 * 0
 * Enter salary
 * 11000
 * Working/left?
 * Working
 * ****Enter Details of employee: 5 ****
 * Enter Employee name
 * Praveen
 * Enter Employee designation
 * HR
 * Enter joining date in yyyy-mm-dd format
 * 2017-11-05
 * Enter experience in years
 * 4
 * Enter salary
 * 40000
 * Working/left?
 * Working
 * ****Enter Details of employee: 6 ****
 * Enter Employee name
 * Abhishek
 * Enter Employee designation
 * QA
 * Enter joining date in yyyy-mm-dd format
 * 2012-03-22
 * Enter experience in years
 * 9
 * Enter salary
 * 65000
 * Working/left?
 * Left
 * ****Enter Details of employee: 7 ****
 * Enter Employee name
 * Supriya
 * Enter Employee designation
 * ASE
 * Enter joining date in yyyy-mm-dd format
 * 2018-09-07
 * Enter experience in years
 * 3
 * Enter salary
 * 30000
 * Working/left?
 * Working
 * ****Enter Details of employee: 8 ****
 * Enter Employee name
 * Mohan
 * Enter Employee designation
 * SE
 * Enter joining date in yyyy-mm-dd format
 * 2020-02-01
 * Enter experience in years
 * 2
 * Enter salary
 * 25000
 * Working/left?
 * Left
 * ****Enter Details of employee: 9 ****
 * Enter Employee name
 * Vivek
 * Enter Employee designation
 * TE
 * Enter joining date in yyyy-mm-dd format
 * 2013-09-22
 * Enter experience in years
 * 8
 * Enter salary
 * 57000
 * Working/left?
 * Working
 * ****Enter Details of employee: 10 ****
 * Enter Employee name
 * Ram
 * Enter Employee designation
 * ASE
 * Enter joining date in yyyy-mm-dd format
 * 2021-01-03
 * Enter experience in years
 * 0
 * Enter salary
 * 11000
 * Working/left?
 * Left
 * 10 rows inserted
 *
 * Output for displayTable(con):
 * -------------------------------------------------------------------
 * | ID |   Name   | Desgn|    Date     | Exp |  Salary   |  Status  |
 * -------------------------------------------------------------------
 * |13  |   Krishna|  ASE |  2022-01-03 |   0 |  11000.00 |  Working |
 * |14  |     Suraj|   QA |  2019-08-24 |   2 |  20000.00 |     Left |
 * |15  |     Nidhi|   SE |  2015-06-18 |   6 |  50000.00 |  Working |
 * |16  |     Rohit|  ASE |  2022-01-17 |   0 |  11000.00 |  Working |
 * |17  |   Praveen|   HR |  2017-11-05 |   4 |  40000.00 |  Working |
 * |18  |  Abhishek|   QA |  2012-03-22 |   9 |  65000.00 |     Left |
 * |19  |   Supriya|  ASE |  2018-09-07 |   3 |  30000.00 |  Working |
 * |20  |     Mohan|   SE |  2020-02-01 |   2 |  25000.00 |     Left |
 * |21  |     Vivek|   TE |  2013-09-22 |   8 |  57000.00 |  Working |
 * |22  |       Ram|  ASE |  2021-01-03 |   0 |  11000.00 |     Left |
 *
 * Output for adding column city:
 * Added column city
 * ------------------------------------------------------------------------
 * | ID |   Name   | Desgn|    Date     | Exp |  Salary   |  Status  | City
 * ------------------------------------------------------------------------
 * |13  |   Krishna|  ASE |  2022-01-03 |   0 |  11000.00 |  Working |    null
 * |14  |     Suraj|   QA |  2019-08-24 |   2 |  20000.00 |     Left |    null
 * |15  |     Nidhi|   SE |  2015-06-18 |   6 |  50000.00 |  Working |    null
 * |16  |     Rohit|  ASE |  2022-01-17 |   0 |  11000.00 |  Working |    null
 * |17  |   Praveen|   HR |  2017-11-05 |   4 |  40000.00 |  Working |    null
 * |18  |  Abhishek|   QA |  2012-03-22 |   9 |  65000.00 |     Left |    null
 * |19  |   Supriya|  ASE |  2018-09-07 |   3 |  30000.00 |  Working |    null
 * |20  |     Mohan|   SE |  2020-02-01 |   2 |  25000.00 |     Left |    null
 * |21  |     Vivek|   TE |  2013-09-22 |   8 |  57000.00 |  Working |    null
 * |22  |       Ram|  ASE |  2021-01-03 |   0 |  11000.00 |     Left |    null
 *
 * Output for updating all cities:
 * Enter City for employee id:13
 * Dharwad
 * Enter City for employee id:14
 * Pune
 * Enter City for employee id:15
 * Hyderabad
 * Enter City for employee id:16
 * Bangalore
 * Enter City for employee id:17
 * Pune
 * Enter City for employee id:18
 * Pune
 * Enter City for employee id:19
 * Pune
 * Enter City for employee id:20
 * Mumbai
 * Enter City for employee id:21
 * Pune
 * Enter City for employee id:22
 * Delhi
 * All cities updated
 * ------------------------------------------------------------------------
 * | ID |   Name   | Desgn|    Date     | Exp |  Salary   |  Status  | City
 * ------------------------------------------------------------------------
 * |13  |   Krishna|  ASE |  2022-01-03 |   0 |  11000.00 |  Working | Dharwad
 * |14  |     Suraj|   QA |  2019-08-24 |   2 |  20000.00 |     Left |    Pune
 * |15  |     Nidhi|   SE |  2015-06-18 |   6 |  50000.00 |  Working |Hyderabad
 * |16  |     Rohit|  ASE |  2022-01-17 |   0 |  11000.00 |  Working |Bangalore
 * |17  |   Praveen|   HR |  2017-11-05 |   4 |  40000.00 |  Working |    Pune
 * |18  |  Abhishek|   QA |  2012-03-22 |   9 |  65000.00 |     Left |    Pune
 * |19  |   Supriya|  ASE |  2018-09-07 |   3 |  30000.00 |  Working |    Pune
 * |20  |     Mohan|   SE |  2020-02-01 |   2 |  25000.00 |     Left |  Mumbai
 * |21  |     Vivek|   TE |  2013-09-22 |   8 |  57000.00 |  Working |    Pune
 * |22  |       Ram|  ASE |  2021-01-03 |   0 |  11000.00 |     Left |   Delhi
 *
 * Output for fetching pune employees:
 * 17 Praveen
 * 18 Abhishek
 * 19 Supriya
 * 21 Vivek
 *
 * Output for updating salary of experience>3:
 * ------------------------------------------------------------------------
 * | ID |   Name   | Desgn|    Date     | Exp |  Salary   |  Status  | City
 * ------------------------------------------------------------------------
 * |13  |   Krishna|  ASE |  2022-01-03 |   0 |  11000.00 |  Working | Dharwad
 * |14  |     Suraj|   QA |  2019-08-24 |   2 |  20000.00 |     Left |    Pune
 * |15  |     Nidhi|   SE |  2015-06-18 |   6 |  1000.00 |  Working |Hyderabad
 * |16  |     Rohit|  ASE |  2022-01-17 |   0 |  11000.00 |  Working |Bangalore
 * |17  |   Praveen|   HR |  2017-11-05 |   4 |  1000.00 |  Working |    Pune
 * |18  |  Abhishek|   QA |  2012-03-22 |   9 |  1000.00 |     Left |    Pune
 * |19  |   Supriya|  ASE |  2018-09-07 |   3 |  30000.00 |  Working |    Pune
 * |20  |     Mohan|   SE |  2020-02-01 |   2 |  25000.00 |     Left |  Mumbai
 * |21  |     Vivek|   TE |  2013-09-22 |   8 |  1000.00 |  Working |    Pune
 * |22  |       Ram|  ASE |  2021-01-03 |   0 |  11000.00 |     Left |   Delhi
 *
 * Output for deleting who left organization:
 * ------------------------------------------------------------------------
 * | ID |   Name   | Desgn|    Date     | Exp |  Salary   |  Status  | City
 * ------------------------------------------------------------------------
 * |13  |   Krishna|  ASE |  2022-01-03 |   0 |  11000.00 |  Working | Dharwad
 * |15  |     Nidhi|   SE |  2015-06-18 |   6 |  1000.00 |  Working |Hyderabad
 * |16  |     Rohit|  ASE |  2022-01-17 |   0 |  11000.00 |  Working |Bangalore
 * |17  |   Praveen|   HR |  2017-11-05 |   4 |  1000.00 |  Working |    Pune
 * |19  |   Supriya|  ASE |  2018-09-07 |   3 |  30000.00 |  Working |    Pune
 * |21  |     Vivek|   TE |  2013-09-22 |   8 |  1000.00 |  Working |    Pune
 */