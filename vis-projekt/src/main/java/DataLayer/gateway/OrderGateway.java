package DataLayer.gateway;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import BusinessLayer.objects.Order;
import DataLayer.connection.SQLConnection;

public class OrderGateway {
	
	
	

	public void addOrder(Order o) {
		SQLConnection url = new SQLConnection();
		try (Connection connection = DriverManager.getConnection(url.getConnection());
	             Statement statement = connection.createStatement();) {
				
	            String insertSql = "INSERT INTO Orders ( id_orders, type_menu, customer_id_customer, menu_id_menu) VALUES "
	                    + "("+ o.getId()+",'"+ o.getType() + "',"+o.getCustomerId()+","+o.getMenuId()+");";
	            statement.executeUpdate(insertSql);
	           

	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
	
	public void editOrder(int id, Order o) {
		// TODO Auto-generated method stub
		
	}

	public Order findByID(int id) {
		
		SQLConnection url = new SQLConnection();
		try (Connection connection = DriverManager.getConnection(url.getConnection());
	             Statement statement = connection.createStatement();) {

	            // Create and execute a SELECT SQL statement.
	            String selectSql = "SELECT * FROM Orders WHERE id_orders =" + id;
	            ResultSet rs = statement.executeQuery(selectSql);
	            
	            while(rs.next())
	            {	
	            	return new Order(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
	            }
	           
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
		return null;
	}

	public ArrayList<Order> getAllOrders() {
		
		SQLConnection url = new SQLConnection();
		try (Connection connection = DriverManager.getConnection(url.getConnection());
	             Statement statement = connection.createStatement();) {
	            // Create and execute a SELECT SQL statement.
	            String selectSql = "SELECT * FROM Orders";
	            ResultSet rs = statement.executeQuery(selectSql);
	            ArrayList<Order> orders = new ArrayList<Order>();
	            while(rs.next())
	            {	
	            	
	            	orders.add(new Order(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
        }
	            return orders;

	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
		return null;
	}


}
