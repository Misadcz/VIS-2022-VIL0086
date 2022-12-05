package DataLayer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MenuDB2 {
	String connectionUrl =
            "jdbc:sqlserver://dbsys.cs.vsb.cz\\STUDENT;"
                    + "database=VIL0086;"
                    + "user=vil0086;"
                    + "password=OK4ns5J3LG6r8EQu;"
                    + "encrypt=false;"
                    + "trustServerCertificate=false;"
                    + "loginTimeout=30;";
	
	ResultSet rs;
	
	public void printIdMenu(int id)
    {
		
		
		try (Connection connection = DriverManager.getConnection(connectionUrl);
                Statement statement = connection.createStatement();) {
               String selectSql = "Select * from Menu;";
                rs=statement.executeQuery(selectSql);
               
           try(PrintWriter pw = new PrintWriter(new FileWriter("Menus.txt"))) {
               while (rs.next()) {
                   pw.printf("%s!%s!%s!%s!%s!%s!%s!%s!%s!%s!%s!%s!%s\n",
                           rs.getString(1),
                           rs.getString(2), 
                           rs.getString(3),
                           rs.getString(4), 
                           rs.getString(5),
                           rs.getString(6),
                           rs.getString(7),
                           rs.getString(8),
                           rs.getString(9),
                           rs.getString(10),
                           rs.getString(11),
                           rs.getString(12),
                           rs.getString(13)
                           );
                   } 
               }catch (IOException e) {
               e.printStackTrace();
           } 
       }
       catch (SQLException e) {
           e.printStackTrace();
       }
		
		
		
		
    }
}
