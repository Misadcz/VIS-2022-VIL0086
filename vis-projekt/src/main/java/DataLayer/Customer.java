package DataLayer;

import java.sql.Date;   

public class Customer
{
	int id_customer;
    String firstname;
    String lastname;
    String email;
    String date;
    String alergy;
    

    public Customer(int rand,String firstname,String lastname,String email , String alergy)
    {
    	this.id_customer = rand;
		this.firstname =firstname;
		this.lastname = lastname;
		this.email = email;
	   this.alergy = alergy;
	   this.date =  "2000-04-10";
    }

    public void printMenu()
    {
        System.out.print("firstname:   ");
        System.out.println(firstname);
        System.out.print("lastname:   ");
        System.out.println(lastname);
        System.out.print("date:   ");
        System.out.println(date);
        System.out.print("alergy:   ");
        System.out.println(alergy);
    }


}
