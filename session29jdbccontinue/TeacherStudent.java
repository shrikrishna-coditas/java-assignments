package session29jdbccontinue;

import java.sql.*;

public class TeacherStudent {
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

    public void manyToMany(Connection con){
        try {
            String query = "select t.name,s.name from teacher t,student s where s.tid=t.id;";
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            System.out.println("-------------------------------");
            System.out.println("| Teacher Name | Student Name |");
            System.out.println("-------------------------------");
            while (rs.next()){
                System.out.printf("| %10s   |  %10s  |\n",
                        rs.getString(1),
                        rs.getString(2));
            }
            System.out.println("-------------------------------");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void oneToOne(Connection con){
        try {
            String query = "select t.name,s.sname from teacher t,student1 s where s.tid=t.id;";
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            System.out.println("-------------------------------");
            System.out.println("| Teacher Name | Student Name |");
            System.out.println("-------------------------------");
            while (rs.next()){
                System.out.printf("| %10s   |  %10s  |\n",
                        rs.getString(1),
                        rs.getString(2));
            }
            System.out.println("-------------------------------");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void oneToMany(Connection con){
        try {
            String query = "select t.name,s.name from teacher t,student s where s.tid=t.id and t.name=\"aarti\";";
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            System.out.println("-------------------------------");
            System.out.println("| Teacher Name | Student Name |");
            System.out.println("-------------------------------");
            while (rs.next()){
                System.out.printf("| %10s   |  %10s  |\n",
                        rs.getString(1),
                        rs.getString(2));
            }
            System.out.println("-------------------------------");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args){
        TeacherStudent obj_ts=new TeacherStudent();
        Connection con=obj_ts.createConnection();
        obj_ts.oneToMany(con);
        obj_ts.manyToMany(con);
        obj_ts.oneToOne(con);
    }
}

/**Output:One to Many (Training)
 * -------------------------------
 * | Teacher Name | Student Name |
 * -------------------------------
 * |      Aarti   |    Ms.Nidhi  |
 * |      Aarti   |    Ms.Jyoti  |
 * |      Aarti   |   Mr.Adarsh  |
 *
 * Output:Many to Many: (College)
 * -------------------------------
 * | Teacher Name | Student Name |
 * -------------------------------
 * |      Aarti   |    Ms.Nidhi  |
 * |      Aarti   |    Ms.Jyoti  |
 * |      Aarti   |   Mr.Adarsh  |
 * |    Anirudh   |    Mr.Rohit  |
 * |    Anirudh   |    Mr.Tejas  |
 * |    Anirudh   |   Ms.Nikita  |
 * |     Smriti   |    Ms.Kajal  |
 * |     Smriti   |    Ms.Kavya  |
 * |     Smriti   |   Mr.Prasad  |
 * |      Sayli   |    Ms.Suman  |
 * |      Sayli   |    Mr.Suraj  |
 * -------------------------------
 *
 * Output: One to One: (Personal Coaching)
 * -------------------------------
 * | Teacher Name | Student Name |
 * -------------------------------
 * |      Aarti   |     Krishna  |
 * |    Anirudh   |      Kartik  |
 * |     Smriti   |     Sridevi  |
 * |      Sayli   |      Manasa  |
 * -------------------------------
 */