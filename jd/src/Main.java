import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Could not load the Driver main class");
        }
        String url = "jdbc:mysql://localhost:3306/jdbc";

     Connection con = null;
        try {
            con = DriverManager.getConnection(url, "root", "007ranjeet");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Statement stmt = con.createStatement();
        stmt.executeUpdate("Delete from student  where name='kahna'");
        System.out.println("+++++++++++");
        PreparedStatement u=con.prepareStatement("select * from student");
        ResultSet ui=u.executeQuery();

        while (ui.next()){
           int roll= ui.getInt(1);
         String name=   ui.getString(2);
            System.out.println(roll+" "+name);
        }


    }
}