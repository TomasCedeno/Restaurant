package models;

import java.io.Serializable;

/**
 *
 * @author tomas
 */
public class FoodModel implements Serializable{
    
    private String name;
    private String description;
    private double price;
    
    public FoodModel(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * @return el nombre
     */
    public String getName() {
        return name;
    }

    /**
     * @return la descripcion
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return el precio
     */
    public double getPrice() {
        return price;
    }
    
}
