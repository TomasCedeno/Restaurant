package controllers;

import java.util.ArrayList;
import models.MenuModel;
import access.MenuDAO;

/**
 *
 * @author tomas
 */
public class InitialData {
    
    private ArrayList<MenuModel> menus = null;
    
    public InitialData(){
        
        MenuDAO menuDAO = new MenuDAO();
        menus = menuDAO.getAllMenus();
    }
    
    /**
     * @return todos los menus
     */
    public ArrayList<MenuModel> getMenus() {
        return menus;
    }
    
}
