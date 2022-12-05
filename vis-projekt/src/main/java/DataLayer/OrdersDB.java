package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdersDB {
	
	
	
	String connectionUrl =
            "jdbc:sqlserver://dbsys.cs.vsb.cz\\STUDENT;"
                    + "database=VIL0086;"
                    + "user=vil0086;"
                    + "password=OK4ns5J3LG6r8EQu;"
                    + "encrypt=false;"
                    + "trustServerCertificate=false;"
                    + "loginTimeout=30;";
	
	public void addOrders(Orders o)
    {
    	
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String insertSql = "INSERT INTO Orders ( id_orders, type_menu, customer_id_customer, menu_id_menu) VALUES "
                    + "("+o.id_orders+",'"+ o.type_menu+"',"+o.customer_id_customer+","+o.menu_id_menu+");";
            statement.executeUpdate(insertSql);
            
            System.out.println("Insert table in given database...");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
       


    }

	public void findOrder(int find_id) {
		
		try (Connection connection = DriverManager.getConnection(connectionUrl);
	             Statement statement = connection.createStatement();) {

	            // Create and execute a SELECT SQL statement.
	            String selectSql = "SELECT * FROM Orders WHERE id_orders =" + find_id;
	            ResultSet rs = statement.executeQuery(selectSql);
	            System.out.println("Selecting table in given database...");
	            while(rs.next())
	            {	
	            	System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
	            	return;
	            }
	            System.out.println("Not found");
	            

	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	public void find_id(int find_id) {

		try (Connection connection = DriverManager.getConnection(connectionUrl);
	             Statement statement = connection.createStatement();) {

	            // Create and execute a SELECT SQL statement.
	            String selectSql = "SELECT menu_id_menu FROM Orders WHERE customer_id_customer =" + find_id;
	            ResultSet rs = statement.executeQuery(selectSql);
	            System.out.println("Selecting table in given database...");
	            while(rs.next())
	            {	
	            	System.out.println(rs.getString(1));
	            	MenuDB mdb = new MenuDB();
	            	mdb.printIdMenu(Integer.parseInt(rs.getString(1)));
	            	//OrdersDB odb = new OrdersDB();
	            	//odb.find_id(rs.getString(1));/
	            	
	            	
	            	return;
	            }
	            System.out.println("Not found");
	            

	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
		
		
		
		
		
	}
	

}
