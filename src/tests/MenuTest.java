package tests;

import java.util.ArrayList;
import models.*;
import access.MenuDAO;


/**
 *
 * @author tomas
 */
public class MenuTest {
    
    private MenuDAO menuDAO;
    
    public MenuTest(){
        menuDAO = new MenuDAO();
    }
    
    public void testCreateMenu(){
        MenuModel menu = new MenuModel("Menu de Prueba");
        menuDAO.createMenu(menu);
    }
    
    public void testGetMenus(){
        ArrayList<MenuModel> menus = menuDAO.getAllMenus();
        
        menus.forEach((menu) -> {
            System.out.println(menu.getName() + "\n");
            menu.getItems().forEach((item) -> {
                System.out.println("Nombre: " + item.getName());
                System.out.println("Descripción: " + item.getDescription());
                System.out.println("Precio: " + item.getPrice() + "\n");
            });
        }
        );
    }
    
    public void testAddMenuItem(FoodModel item){
        menuDAO.addItemToMenu(0, item);
    }
    
}
