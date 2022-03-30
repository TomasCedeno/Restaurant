package controllers;

import java.util.ArrayList;
import models.*;
import access.*;

/**
 *
 * @author tomas
 */
public class InitialData {
    
    private ArrayList<MenuModel> menus = null;
    private ArrayList<OrderModel> orders = null;
    
    public InitialData(){
        MenuDAO menuDAO = new MenuDAO();
        menus = menuDAO.getAllMenus();
        
        OrderDAO orderDAO = new OrderDAO();
        orders = orderDAO.getAllOrders();
    }
    
    /**
     * @return todos los menus
     */
    public ArrayList<MenuModel> getMenus() {
        return menus;
    }

    /**
     * @return todos las ordenes
     */
    public ArrayList<OrderModel> getOrders() {
        return orders;
    }
    
}
