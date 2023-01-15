package DataLayer.gateway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BusinessLayer.objects.Customer;
import DataLayer.connection.SQLConnection;

public class CustomerGateway
{
	
	
	public void addCustomer(Customer c)
    {
    	
		SQLConnection url = new SQLConnection();
        try (Connection connection = DriverManager.getConnection(url.getConnection());
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String insertSql = "INSERT INTO Customer (id_customer, firstname, lastname, email, alergie) VALUES "
                    + "("+c.getId()+",'"+ c.getFirstname()+"','"+c.getLastname()+"','"+c.getEmail()+"','"+c.getAlergy()+"');";
            statement.executeUpdate(insertSql);
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }

	public Customer findByID(int id) {
		SQLConnection url = new SQLConnection();
		try (Connection connection = DriverManager.getConnection(url.getConnection());
	             Statement statement = connection.createStatement();) {
	            // Create and execute a SELECT SQL statement.
	            String selectSql = "SELECT * FROM Customer WHERE id_customer =" + id;
	            ResultSet rs = statement.executeQuery(selectSql);
	            while(rs.next())
	            {	
	            	return new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
	            }
	            
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
		return null;
		
	}

	public ArrayList<Customer> getAllCustomers() {
		
		SQLConnection url = new SQLConnection();
		try (Connection connection = DriverManager.getConnection(url.getConnection());
	             Statement statement = connection.createStatement();) {
	            // Create and execute a SELECT SQL statement.
	            String selectSql = "SELECT * FROM Customer";
	            ResultSet rs = statement.executeQuery(selectSql);

	            ArrayList<Customer> customers = new ArrayList<Customer>();
	            while(rs.next())
	            {	
	            	
	            	customers.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
        }
	            return customers;

	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
		return null;
	}

	public void editCustomer(Customer c) 
	{
		SQLConnection url = new SQLConnection();
        try (Connection connection = DriverManager.getConnection(url.getConnection());
             Statement statement = connection.createStatement();) {

            String updateSql = "UPDATE Customer set firstname = '" + c.getFirstname() +"', lastname = '"+ c.getLastname() +"',email = '"+ c.getEmail()+"',alergie = '"+c.getAlergy()+"' where id_customer = "+c.getId();                                                      
            statement.executeUpdate(updateSql);
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}