package DataLayer;

import java.util.*;
import java.sql.*;

public class MenuDB
{
	
	String connectionUrl =
            "jdbc:sqlserver://dbsys.cs.vsb.cz\\STUDENT;"
                    + "database=VIL0086;"
                    + "user=vil0086;"
                    + "password=OK4ns5J3LG6r8EQu;"
                    + "encrypt=false;"
                    + "trustServerCertificate=false;"
                    + "loginTimeout=30;";

    public MenuDB()
    {
        
    }

    public Menu GetById(int id)
    {
       return null;
    }

    public void addMenu(Menu m)
    {
    	
    	


        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String insertSql = "INSERT INTO Menu ( id_menu, breakfast, snack_1, lunch, snack_2, dinner, calories, carbohydrate, fat, protein, sugar, salt, fiber) VALUES "
                    + "('"+m.id_menu+"','"+ m.breakfast+"','"+m.snack_1+"','"+m.lunch+"','"+m.snack_2+"','"+m.dinner+"',"+m.calories+","+ m.carbohydrate+","+ m.fat+","+ m.protein+","+ m.sugar+","+ m.salt+","+ m.fiber+");";
            statement.executeUpdate(insertSql);
            
            System.out.println("Insert table in given database...");


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
       
          

               

           



    }


    public void printAllMenus()
    {
    }


    public void printIdMenu(int id)
    {
    	 String connectionUrl =
                 "jdbc:sqlserver://dbsys.cs.vsb.cz\\STUDENT;"
                         + "database=VIL0086;"
                         + "user=vil0086;"
                         + "password=OK4ns5J3LG6r8EQu;"
                         + "encrypt=false;"
                         + "trustServerCertificate=false;"
                         + "loginTimeout=30;";


         try (Connection connection = DriverManager.getConnection(connectionUrl);
              Statement statement = connection.createStatement();) {

             // Create and execute a SELECT SQL statement.
             String selectSql = "SELECT * FROM Menu WHERE "+id+" = id_menu";
            ResultSet rs = statement.executeQuery(selectSql);

           while(rs.next())
           {
        	   System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getString(9)+"  "+rs.getString(10)+"  "+rs.getString(11)+"  "+rs.getString(12)+"  "+rs.getString(13));
           }
            
         }
         catch (SQLException e) {
             e.printStackTrace();
         }
    	
    }


    public void deleteMenu(int id)
    {
      /*  for(int i = 0 ; i < list.size(); i++)
        {

            Menu temp = list.get(i);
            if(temp.id_menu == id)
            {
                list.remove(i);
                return;
            }
        }*/
    }











}
