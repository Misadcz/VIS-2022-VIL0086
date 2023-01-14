package BusinessLayer.mapper;

import BusinessLayer.objects.Menu;
import DataLayer.gateway.MenuGateway;

public class MenuMapper
{
	
	public void addMenu(Menu m)
    {
		MenuGateway gw = new MenuGateway();
		gw.addMenu(m);
    }
}