import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import BusinessLayer.mapper.CustomerMapper;
import BusinessLayer.mapper.OrderMapper;


public class Main
{

    public static void main(String args[]) throws IOException
    {
    	
    	while(true)
    	{
    		System.out.println(" 0 - EXIT");
    		System.out.println(" 1 - Show Order by Order ID");
    		System.out.println(" 2 - Show All Customers");
    		System.out.println(" 3 - Show All Orders");
    		System.out.println(" 4 - Create Order");
    		System.out.println(" 5 - Edit Customer ");
    		System.out.println(" 6 - Delete Order ");
    		
    		BufferedReader ans = new BufferedReader(new InputStreamReader(System.in));
    		String answer = ans.readLine();
    
    		CustomerMapper customerMapper = new CustomerMapper();
    		OrderMapper orderMapper = new OrderMapper();
    		 
    		
    		switch(answer)
    		{
    		case "0" :
    			return;
    			
    		case "1" :
    			System.out.print("Type ID of Order");
        		orderMapper.findByID(Integer.parseInt(ans.readLine()));
    			break;
    			
    		case "2" :
    			customerMapper.printAllCustomers();
    			break;
    			
    		case "3" :
    			orderMapper.printAllOrders();
    			break;
    			
    		case "4" :
    			orderMapper.addOrder();
    			break;
    		case "5" :
    			System.out.print("ID of Customer");
    			customerMapper.editCustomer(Integer.parseInt(ans.readLine()));
    			break;
    		case "6" :
    			System.out.print("ID of Order");
    			orderMapper.deleteOrder(Integer.parseInt(ans.readLine()));
    			break;
    			
    		default:
    			break;
    		}
    		
    	}	
    }
}
