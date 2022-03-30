package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author tomas
 */
public class OrderModel implements Serializable{
    
    private int id;
    private String customerId;
    private String customerName;
    private ArrayList<FoodModel> items = new ArrayList();
    private double totalPrice = 0;

    public OrderModel(int id, String customerId, String customerName) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
    }

    /**
     * @return el numero de orden
     */
    public int getId() {
        return id;
    }
    
    /**
     * @return la identificacion del cliente
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @return el nombre del cleinte
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @return la lista de items de la orden
     */
    public ArrayList<FoodModel> getItems() {
        return items;
    }

    /**
     * Calcula el precio total de la orden, sumando todos los precios de la lista de items
     * @return el precio total de la orden
     */
    public double getTotalPrice() {
        items.forEach((item) -> {
            totalPrice += item.getPrice();
        });

        return totalPrice;
    }
    
    /**
     * @param item item para agregar a la orden
     */
    public void addItem(FoodModel item){
        items.add(item);
    }
    
}
