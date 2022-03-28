package access;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.FoodModel;
import models.MenuModel;
import utils.CreationDB;

/**
 *
 * @author tomas
 */
public class MenuDAO {
    
    private String path = System.getProperty("user.dir") + "/src/utils/menus.dat";
    ArrayList<MenuModel> menus = new ArrayList();
    
    /**
     * Al crear el objeto se verifica si ya existe el archivo donde se guardan los objetos serializados,
     * en caso de que no exista llama a la operacion de la clase que crea el archivo.
    */
    public MenuDAO(){
        File file = new File(path);
        
        if (!file.exists())
            CreationDB.createMenuDB();
    }
    
    
    /**
     * Recibe un objeto de tipo MenuModel, lo serializa y lo guarda en el archivo correspondiente.
     * @param menu el menu para guardar
     */
    public void createMenu(MenuModel menu){
        
        try{
            
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            menus = (ArrayList)in.readObject();
            menus.add(menu);
            in.close();
                        
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(menus);
            out.close();
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }        
    }
    
    
    /**
     * 
     * @return la lista de todos los menus.
     */
    public ArrayList<MenuModel> getAllMenus(){
        
        try {
            
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            menus = (ArrayList)in.readObject();
            in.close();
            
        } catch (EOFException ex){
           //Si el archivo esta vacio
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        
        return menus;  
    }
    
    
    /**
     * Agrega un item a un menu
     * @param menuIndex el indice del menu en el que se quiere agregar el item
     * @param item el item que se quiere agregar
     */
    public void addItemToMenu(int menuIndex, FoodModel item){
        
        try{
            
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            menus = (ArrayList)in.readObject();
            in.close();
            
            MenuModel menu = menus.get(menuIndex);
            menu.addItem(item);
            menus.remove(menuIndex);
            menus.add(menuIndex, menu);
            
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(menus);
            out.close();
             
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } 
    }
       
}
