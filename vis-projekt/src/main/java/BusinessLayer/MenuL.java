package BusinessLayer;

import DataLayer.Menu;
import DataLayer.MenuDB;

public class MenuL
{
    private final MenuDB menus;

    public MenuL(MenuDB db)
    {
        this.menus = db;
    }

    Menu GetUserById(int id)
    {
        return menus.GetById(id);
    }

    public void addMenu(Menu m)
    {
        menus.addMenu(m);
    }

    public void printAllMenus()
    {
        menus.printAllMenus();
    }

    public void printMenuById(int id)
    {
        menus.printIdMenu(id);
    }





}
