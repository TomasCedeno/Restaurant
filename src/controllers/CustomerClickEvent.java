package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import access.OrderDAO;
import javax.swing.JOptionPane;
import views.CustomerWindow;
import views.MainWindow;

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
        if(event.getSource() == customerWindow.getBtnSaveOrder()) {
            OrderDAO orderDAO = new OrderDAO();
            orderDAO.createOrder(customerWindow.getOrder());
            
            JOptionPane.showMessageDialog(null, "La orden ha sido creada exitosamente.");
            customerWindow.dispose();
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        }
    }
}
