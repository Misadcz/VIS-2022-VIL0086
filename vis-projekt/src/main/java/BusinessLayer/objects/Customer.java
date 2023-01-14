package BusinessLayer.objects;

public class Customer
{
	private int id_customer;
	private String firstname;
	private String lastname;
	private String email;
	private String date;
	private String alergy;
    
    public Customer(int rand,String firstname,String lastname,String email , String alergy)
    {
    	this.id_customer = rand;
		this.firstname =firstname;
		this.lastname = lastname;
		this.email = email;
	   this.alergy = alergy;
	   this.date =  "2000-04-10";
    }
    
    public int getId() { return this.id_customer;}
    public String getFirstname() { return this.firstname;}
    public String getLastname() { return this.lastname;}
    public String getEmail() { return this.email;}
    public String getDate() { return this.date;}
    public String getAlergy() { return this.alergy;}
    
}