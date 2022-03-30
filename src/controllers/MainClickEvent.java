package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import models.OrderModel;
import views.CustomerWindow;
import views.MainWindow;

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
        if(event.getSource() == mainWindow.getBtnMakeOrder()) {
            
            int orderId = new InitialData().getOrders().size() + 1;
            
            OrderModel order = new OrderModel(orderId, mainWindow.getTxtCustomerId().getText(),
                    mainWindow.getTxtCustomerName().getText());
            
            mainWindow.dispose();
            CustomerWindow customerWindow = new CustomerWindow(order);
            customerWindow.setVisible(true);
        }
    }
    
}
