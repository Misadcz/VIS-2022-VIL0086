import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import BusinessLayer.MenuL;
import DataLayer.Customer;
import DataLayer.CustomerDB;
import DataLayer.Menu;
import DataLayer.MenuDB;
import DataLayer.MenuDB2;
import DataLayer.Orders;
import DataLayer.OrdersDB;
public class main
{

    public static void main(String args[]) throws IOException
    {

    		System.out.println(" 1 - Show Order");
    		System.out.println(" 2 - Add Order");
    		System.out.println(" 3 - Show Menu by Costumer ID ");
    		BufferedReader ans = new BufferedReader(new InputStreamReader(System.in));
    		String answer = ans.readLine();
    
        Menu m1 = new Menu(0,"2 Vejce s houskou","mensí salat","Kuře s rýží","Jahody","Pečené batáty s mletým masem",2620,170,24,42,13,6,7);
        Menu m2 = new Menu(1,"Rohlík","Jablko","Zeleninový salát","Proteinový nápoj","Mix Zelenina(Paprika,rajče,okurka)",1600,100,10,23,13,2,4);
        MenuDB db = new MenuDB();
        MenuL menul = new MenuL(db);
        //menul.addMenu(m1);
        //menul.addMenu(m2);
        
        System.out.println(answer);
        if(answer.equals("2"))
        {
        	Random random = new Random();
        	int id = random.nextInt(1000)+10;
        	int id2 = random.nextInt(1000)+10;
        	System.out.println("Napiste jmeno");
        	String firstname = ans.readLine();
        	System.out.println("Napiste prijmeni");
        	String lastname = ans.readLine();
        	System.out.println("Napiste typ jidelnicku");
        	String type_menu = ans.readLine();
        	System.out.println("Napiste email");
        	String email = ans.readLine();
        	System.out.println("Napiste alergie");
        	String alergy = ans.readLine();
        	Customer customer = new Customer(id,firstname,lastname,email,alergy);
        	CustomerDB cdb = new CustomerDB();
        	cdb.addCustomer(customer);
        	Orders o = new Orders(id2,type_menu,id,1);
        	OrdersDB odb = new OrdersDB();
        	odb.addOrders(o);
        }
        if(answer.equals("1"))
        {
        	System.out.println("Napiste ID objednavky");
        	Scanner in = new Scanner(System.in);
        	int find_id = in.nextInt();
        	
        	OrdersDB odb = new OrdersDB();
        	odb.findOrder(find_id);
        }
        
        if(answer.equals("3"))
        {
        	System.out.println("Napiste ID Zakaznika");
        	Scanner in = new Scanner(System.in);
        	int find_id = in.nextInt();
        	CustomerDB cdb = new CustomerDB();
        	cdb.find_id(find_id);
        	
        }

        
        MenuDB2 db2 = new MenuDB2();
        db2.printIdMenu(0);
       
        
        
        
        //menul.printMenuById(0);


        System.out.print("KONEC");

    }

}
