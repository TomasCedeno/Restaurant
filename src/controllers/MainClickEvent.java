package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import models.OrderModel;
import views.*;

/**
 *
 * @author tomas
 */
public class MainClickEvent extends MouseAdapter{
    
    private MainWindow mainWindow;
    
    public MainClickEvent(MainWindow mainWindow){
        this.mainWindow = mainWindow;
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
        if(event.getSource() == mainWindow.getBtnMakeOrder() 
            && !mainWindow.getTxtCustomerId().getText().isEmpty()
            && !mainWindow.getTxtCustomerName().getText().isEmpty() ) {
            
            if (new InitialData().getMenus().isEmpty()){
                JOptionPane.showMessageDialog(null, "Por ahora el servicio no está disponible.");
                
            } else {
                int orderId = new InitialData().getOrders().size() + 1;
            
                OrderModel order = new OrderModel(orderId, mainWindow.getTxtCustomerId().getText(),
                        mainWindow.getTxtCustomerName().getText());

                mainWindow.dispose();
                CustomerWindow customerWindow = new CustomerWindow(order);
                customerWindow.setVisible(true);
            }
            
        } else if (event.getSource() == mainWindow.getBtnStaffLogin()){
            String password = String.valueOf( mainWindow.getTxtStaffPassword().getPassword() );
            
            if (password.equals("restaurante123")){
                mainWindow.dispose();
                StaffWindow staffWindow = new StaffWindow();
                staffWindow.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta.");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingrese toda la información.");
        }
    }
    
}
