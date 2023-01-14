package BusinessLayer.mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import BusinessLayer.objects.Customer;
import BusinessLayer.objects.Order;
import DataLayer.gateway.OrderGateway;

public class OrderMapper
{
   //private Order order;

    public OrderMapper()//Order o)
    {
       // this.order = o;
    }
    
    public Order findByID(int id)
    {
    	OrderGateway gw = new OrderGateway();
    	Order result = gw.findByID(id);
    	if(result == null)
    		System.out.print("Order " + id + " not found.");
    	else
    		printOrder(result);
    	
    	return result;
    }
    
    private void printOrder(Order o) 
    {
    	 System.out.println("  ID: " + o.getId()  
		+ "  Type of Menu: " + o.getType()
		+ "  Customer ID: " + o.getCustomerId()
		+ "  Menu ID: " + o.getMenuId()
		);
	}

	public void addOrder() throws IOException
    {
		BufferedReader ans = new BufferedReader(new InputStreamReader(System.in));
    	OrderGateway gw = new OrderGateway();
    	CustomerMapper gw2 = new CustomerMapper();
    	
    	System.out.println("Jmeno:");
    	String firstname = ans.readLine();
    	System.out.println("Prijmeni:");
		String lastname = ans.readLine();
    	System.out.println("Email:");
    	String email = ans.readLine();
    	System.out.println("Alergy:");
    	String alergy = ans.readLine();
    	System.out.println("Type of Menu:");
    	String type = ans.readLine();
    	
    	Random random = new Random();
    	int id_order = random.nextInt(400);
    	int customer_id  = random.nextInt(400);
		
    	gw2.addCustomer(new Customer(customer_id,firstname,lastname,email,alergy));
    	gw.addOrder(new Order(id_order,type,customer_id,0));
    }
    
    public void editOrder(int id,Order o)
    {
    	OrderGateway gw = new OrderGateway();
    	gw.editOrder(id,o);
    	
    }

	public void printAllOrders() 
		{
			OrderGateway gw = new OrderGateway();
			ArrayList<Order> temp = gw.getAllOrders();
			temp.forEach((n) -> System.out.println("  ID: " + n.getId() 
													+ "  Type of menu: " + n.getType() 
													+ "  Customer ID: " + n.getCustomerId()
													+ "  Menu ID: " + n.getMenuId()
													));
		}
    
    
}
