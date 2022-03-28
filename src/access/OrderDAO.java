package access;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.OrderModel;
import utils.CreationDB;

/**
 *
 * @author tomas
 */
public class OrderDAO {
    
    private String path = System.getProperty("user.dir") + "/src/utils/orders.dat";
    ArrayList<OrderModel> orders = new ArrayList();
    
    /**
     * Al crear el objeto se verifica si ya existe el archivo donde se guardan los objetos serializados,
     * en caso de que no exista llama a la operacion de la clase que crea el archivo.
    */
    public OrderDAO(){
        File file = new File(path);
        
        if (!file.exists())
            CreationDB.createOrderDB();
    }
    
    
    /**
     * Recibe un objeto de tipo OrderModel, lo serializa y lo guarda en el archivo correspondiente.
     * @param order la orden para guardar
     */
    public void createOrder(OrderModel order){
        
        try{
            
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            orders = (ArrayList)in.readObject();
            orders.add(order);
            in.close();
                        
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(orders);
            out.close();
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }        
    }
    
    
    /**
     *
     * @return la lista de todas las ordenes.
     */
    public ArrayList<OrderModel> getAllOrders(){
        
        try {
            
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            orders = (ArrayList)in.readObject();
            in.close();
            
        } catch (EOFException ex){
           //Si el archivo esta vacio
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        
        return orders;
    }
    
}
