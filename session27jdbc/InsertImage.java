package session27jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class InsertImage {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fin=new FileInputStream("src/session27jdbc/Coditas.jpg");
        try {
            Connection con;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/JavaTraining", "root", "");
            System.out.println("Connected");

            String query="Insert into ImageInfo(Id,Image) values(?,?)";
            PreparedStatement stmt=con.prepareStatement(query);
            stmt.setInt(1,1);
            stmt.setBinaryStream(2,fin);
            stmt.execute();

            String query2="Select * from ImageInfo";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query2);

            while (rs.next()){
                System.out.println("Id: "+rs.getInt(1));
                System.out.println("Image: "+rs.getBlob(2));
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

/**Output:
 * Connected
 * Id: 1
 * Image: com.mysql.cj.jdbc.Blob@ed9d034
 */

