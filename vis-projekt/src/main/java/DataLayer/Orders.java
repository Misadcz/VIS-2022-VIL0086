package DataLayer;

public class Orders
{

    int id_orders;
    String type_menu;
    int customer_id_customer;
    int menu_id_menu;

    public Orders(int id_orders,String type_menu, int customer_id_customer,int menu_id_menu)
    {
        this.id_orders = id_orders;
        this.type_menu = type_menu;
        this.customer_id_customer = customer_id_customer;
        this. menu_id_menu = menu_id_menu;
    }

    public void printMenu()
    {
    }


}
