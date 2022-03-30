package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import models.OrderModel;
import views.CustomerWindow;
import views.CustomerWindow;

/**
 *
 * @author tomas
 */
public class CustomerClickEvent extends MouseAdapter{
    private CustomerWindow customerWindow;
    
    public CustomerClickEvent(CustomerWindow customerWindow){
        this.customerWindow = customerWindow;
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
        if(event.getSource() == customerWindow.getBtnFinishOrder()) {
            //TODO: Create finish order window wich allows to save the order in the DB
        }
    }
}
