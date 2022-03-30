package tests;

import models.*;

/**
 *
 * @author tomas
 */
public class Test {
    
    public static void test(){
        
        MenuTest menuTest = new MenuTest();
        OrderTest orderTest = new OrderTest();
        
        //Se crea un item
        FoodModel item1 = new FoodModel("Item 1", "Item de prueba 1", 10000);
        FoodModel item2 = new FoodModel("Item 2", "Item de prueba 2", 20000);

        
        //Se crea un menu
        menuTest.testCreateMenu();
        
        //Se agregan los items al menu
        menuTest.testAddMenuItem(item1);
        menuTest.testAddMenuItem(item2);
        
        //Se muestra el menu creado con sus respectivos items
        menuTest.testGetMenus();
        
        
        //Se inicializa una orden y se le agregan items
        OrderModel order = new OrderModel(1, "12345678", "Cliente Prueba");
        order.addItem(item1);
        order.addItem(item2);

        
        
        //Se crea la orden
        orderTest.testCreateOrder(order);
        
        //Se muestra la orden creada
        orderTest.testGetOrders();
        
    }
    
}
