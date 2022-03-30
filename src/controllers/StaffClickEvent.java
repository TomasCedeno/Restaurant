package controllers;

import access.MenuDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import models.FoodModel;
import models.MenuModel;
import views.StaffWindow;

/**
 *
 * @author tomas
 */
public class StaffClickEvent extends MouseAdapter{
    
    private StaffWindow staffWindow;

    public StaffClickEvent(StaffWindow staffWindow) {
        this.staffWindow = staffWindow;
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
        if(event.getSource() == staffWindow.getBtnCreateMenu()) {
            MenuDAO menuDAO = new MenuDAO();
            MenuModel menu = new MenuModel(staffWindow.getTxtMenuName().getText());
            menuDAO.createMenu(menu);
            
            JOptionPane.showMessageDialog(null, "El menú ha sido creado exitosamente.");
            staffWindow.getTxtMenuName().setText("");
            
        } else if (event.getSource() == staffWindow.getBtnAddMenuItem()){
            FoodModel item = new FoodModel(staffWindow.getTxtItemName().getText(), 
                    staffWindow.getTxtItemDescription().getText(),
                    Double.valueOf(staffWindow.getTxtItemPrice().getText()) );
            
            MenuDAO menuDAO = new MenuDAO();
            int menuIndex = staffWindow.getCbxMenus().getSelectedIndex();
            menuDAO.addItemToMenu(menuIndex, item);
            
            JOptionPane.showMessageDialog(null, "Se ha agregado " + item.getName() + " al menú " +
                    menuDAO.getAllMenus().get(menuIndex).getName() + " exitosamente." );
            staffWindow.getTxtItemName().setText("");
            staffWindow.getTxtItemDescription().setText("");
            staffWindow.getTxtItemPrice().setText("");
        }
    }
    
}
