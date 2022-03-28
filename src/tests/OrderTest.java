package tests;

import java.util.ArrayList;
import models.*;
import access.OrderDAO;

/**
 *
 * @author tomas
 */
public class OrderTest {
    
    private OrderDAO orderDAO;

    public OrderTest() {
        this.orderDAO = new OrderDAO();
    }
    
    
    public void testCreateOrder(OrderModel order){
        orderDAO.createOrder(order);
    }
    
    
    public void testGetOrders(){
        ArrayList<OrderModel> orders = orderDAO.getAllOrders();
                
        orders.forEach((order) -> {
            System.out.println("\nOrden No." + order.getId()+ "\n");
            System.out.println("No. de Documento: " + order.getCustomerId());
            System.out.println("Nombre: " + order.getCustomerName());
            System.out.println("Comida Ordenada ");
            order.getItems().forEach((item) -> {
                System.out.println("\tNombre: " + item.getName() + "\tPrecio: " + item.getPrice());
            });
            System.out.println("Precio Total: " + order.getTotalPrice() + "\n");
        }
        );
    }
    
}
