package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.CustomerWindow;
import access.MenuDAO;
import java.util.ArrayList;
import models.MenuModel;

/**
 *
 * @author tomas
 */
public class ChangeEvent implements ActionListener{
    
    private CustomerWindow window; 

    public ChangeEvent(CustomerWindow window) {
        this.window = window;
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() ==  window.getCbxMenusList()) {
            MenuDAO menuDAO = new MenuDAO();
            ArrayList<MenuModel> presentations = null;
            MenuModel menu = (MenuModel)window.getCbxMenusList().getSelectedItem();
            window.setContentMenu(menu);
        }
    }
    
}
