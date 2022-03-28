package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author tomas
 */
public class MenuModel implements Serializable{
    
    private String name;
    private ArrayList<FoodModel> items = new ArrayList();

    public MenuModel(String name) {
        this.name = name;
    }
    
    /**
     * @return el nombre
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return los items del menu
     */
    public ArrayList<FoodModel> getItems() {
        return items;
    }
    
    /**
     * Agrega un item al final del menu
     * @param item item para agregar en el menu
     */
    public void addItem(FoodModel item){
        items.add(item);
    }
    
}
