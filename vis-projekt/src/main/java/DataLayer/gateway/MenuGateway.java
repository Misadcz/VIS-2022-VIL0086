package DataLayer.gateway;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessLayer.objects.Menu;
import DataLayer.connection.SQLConnection;


public class MenuGateway
{
	public void addMenu(Menu m)
    {
    
		SQLConnection url = new SQLConnection();
        try (Connection connection = DriverManager.getConnection(url.getConnection());
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String insertSql = "INSERT INTO Menu ( id_menu, breakfast, snack_1, lunch, snack_2, dinner, calories, carbohydrate, fat, protein, sugar, salt, fiber) VALUES "
                    + "('"+m.getID()+"','"+ m.getBreakfast()+"','"+m.getSnack_1()+"','"+m.getLunch()+"','"+m.getSnack_2()+"','"+m.getDinner()+"',"+m.getCalories()+","+ m.getCarbohydrate()+","+ m.getFat()+","+ m.getProtein()+","+ m.getSugar()+","+ m.getSalt()+","+ m.getFiber()+");";
            statement.executeUpdate(insertSql);
           
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
	
}
	
	
	public void SaveFileMenu(int id)
    {
		ResultSet rs;
		SQLConnection url = new SQLConnection();
		
		try (Connection connection = DriverManager.getConnection(url.getConnection());
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