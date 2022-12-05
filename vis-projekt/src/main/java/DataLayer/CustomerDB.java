package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDB {

	public CustomerDB()
    {
        
    }
	String connectionUrl =
            "jdbc:sqlserver://dbsys.cs.vsb.cz\\STUDENT;"
                    + "database=VIL0086;"
                    + "user=vil0086;"
                    + "password=OK4ns5J3LG6r8EQu;"
                    + "encrypt=false;"
                    + "trustServerCertificate=false;"
                    + "loginTimeout=30;";
	
	
	public void addCustomer(Customer c)
    {
    	
    	
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String insertSql = "INSERT INTO Customer (id_customer, firstname, lastname, email, alergie) VALUES "
                    + "("+c.id_customer+",'"+ c.firstname+"','"+c.lastname+"','"+c.email+"','"+c.alergy+"');";
            statement.executeUpdate(insertSql);
            
            System.out.println("Insert table in given database...");


        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }


	public void find_id(int find_id) {
		try (Connection connection = DriverManager.getConnection(connectionUrl);
	             Statement statement = connection.createStatement();) {
			int temp=0;
	            // Create and execute a SELECT SQL statement.
	            String selectSql = "SELECT * FROM Customer WHERE id_customer =" + find_id;
	            ResultSet rs = statement.executeQuery(selectSql);
	            System.out.println("Selecting table in given database...");
	            while(rs.next())
	            {	
	            	//System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
	            	OrdersDB odb = new OrdersDB();
	            	odb.find_id(Integer.parseInt(rs.getString(1)));
	            
	            	
	            	return;
	            }
	            System.out.println("Not found");
	            

	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
}
