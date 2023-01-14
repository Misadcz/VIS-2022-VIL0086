package BusinessLayer.mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import BusinessLayer.objects.Customer;
import DataLayer.gateway.CustomerGateway;

public class CustomerMapper
{
	Customer customer;
    
	public void addCustomer(Customer c)	
	{
		CustomerGateway gw = new CustomerGateway();
		gw.addCustomer(c);
	}
	
	public Customer findByID(int id)
	{
		CustomerGateway gw = new CustomerGateway();
		return gw.findByID(id);
		
	}
    
	
	public ArrayList<Customer> getAllCustomers()
	{
		CustomerGateway gw = new CustomerGateway();
		return gw.getAllCustomers();
	}
	
	
	public void printAllCustomers()
	{
		CustomerGateway gw = new CustomerGateway();
		ArrayList<Customer> temp = gw.getAllCustomers();
		temp.forEach((n) -> System.out.println("  ID: " + n.getId() 
												+ "  First name: " + n.getFirstname() 
												+ "  Last name: " + n.getLastname()
												+ "  Email: " + n.getEmail()
												+ "  Date Registration: " + n.getDate()
												+ "  Alergies: " + n.getAlergy()
												));
	}

	public void editCustomer(int id) throws IOException 
	{
		CustomerGateway gw = new CustomerGateway();
		BufferedReader ans = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Write new first name:");
		String firstname = ans.readLine();
		System.out.println("Write new last name:");
		String lastname = ans.readLine();
		System.out.println("Write new email:");
		String email = ans.readLine();
		System.out.println("Write new alergy:");
		String alergy = ans.readLine();
		
		gw.editCustomer(new Customer(id,firstname,lastname,email,alergy));
		
	}
    
}