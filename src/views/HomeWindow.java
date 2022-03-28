package views;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author tomas
 */
public class HomeWindow extends JFrame{
    
    public HomeWindow(){
        setTitle("Restaurante"); 
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/images/icon.png"));
        initComponents();
        
    }
    
    private void initComponents(){
        
        //Establece tamano y posicion en el centro de la pantalla
        setSize(900, 620);
        setLocationRelativeTo(null);
        
        HomePanel homePanel = new HomePanel();
        add(homePanel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}


class HomePanel extends JPanel{
    
    private JButton adminButton;
    private JButton customerButton;
    private JLabel lblHeader;
    
    private Font headerFont = new Font("Lucida Sans Unicode", Font.BOLD, 40);
    
    public HomePanel(){
        initComponents();
    }
    
    private void initComponents(){
        
        //Crea un Grid para posicionar elemntos de la GUI
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //Crea label principal y lo posiciona
        lblHeader = new JLabel("Restaurante");
        lblHeader.setForeground(Color.DARK_GRAY);
        lblHeader.setFont(headerFont);
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(lblHeader, gbc);
        
        ImageIcon icon;
        adminButton = new JButton("Administrador");
        adminButton.setSize(200, 200);
        icon = new ImageIcon("src/images/admin_icon.png");
        adminButton.setIcon(new ImageIcon(icon.getImage().getScaledInstance(adminButton.getWidth(), adminButton.getHeight(), Image.SCALE_DEFAULT)));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(30,20,30,20);
        add(adminButton, gbc);
        
        customerButton = new JButton("Cliente");
        customerButton.setSize(200, 200);
        icon = new ImageIcon("src/images/customer_icon.png");
        customerButton.setIcon(new ImageIcon(icon.getImage().getScaledInstance(customerButton.getWidth(), customerButton.getHeight(), Image.SCALE_DEFAULT)));
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(customerButton, gbc);
    }
    
}
