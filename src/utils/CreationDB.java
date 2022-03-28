package utils;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.*;

/**
 *
 * @author tomas
 */
public class CreationDB {
    
    /**
     * Crea el archivo para guardar los objetos serializados de tipo Menu
     */
    public static void createMenuDB(){
        
        String path = System.getProperty("user.dir") + "/src/utils/menus.dat";
        
        try{ 
            
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            ArrayList<MenuModel> menus = new ArrayList();
            out.writeObject(menus);
            out.close();
        
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }   
    }
    
    /**
     * Crea el archivo para guardar los objetos serializados de tipo Order
     */
    public static void createOrderDB(){
        
        String path = System.getProperty("user.dir") + "/src/utils/orders.dat";
        
        try{ 
            
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            ArrayList<OrderModel> orders = new ArrayList();
            out.writeObject(orders);
            out.close();
        
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }   
    }
}
