package libraryproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.*;
/**
 *
 * @author Tushar Gupta
 */
public class login extends JFrame implements ActionListener{
   private JLabel l1,l2;
    private JTextField t1;
    private JPasswordField p1;
    private JButton b1,b2;
    private JPanel panel;
    
    public login(){ 
        panel = new JPanel();
	panel.setBackground(new Color(176, 224, 230));
	setContentPane(panel);
	panel.setLayout(null);
        
        
        
         l1 = new JLabel("User name :");
         
         l2 = new JLabel("PassWord  :");
         
         t1 = new JTextField();
         
         p1 = new JPasswordField();
         
         b1 = new JButton("login in");
         b1.setForeground(Color.WHITE);
         b1.setBackground(Color.RED);
         
         b2 = new JButton("New Account");
         b2.setForeground(Color.WHITE);
         b2.setBackground(Color.RED);
         
        l1.setBounds(100,50,150,50);
        add(l1);
        l2.setBounds(100,135,150,50);
        add(l2);
        t1.setBounds(265,60,150,25);
        add(t1);
        p1.setBounds(265,144,150,25);
        add(p1);
        b1.setBounds(120,250,100,50);
        add(b1);
        b1.addActionListener(this);
        b2.setBounds(270,250,150,50);
        add(b2);
        b2.addActionListener(this);
        
        
      
        
      setBackground(new Color(169, 169, 169));
      setSize(550,400);
      setLocation(350,150);
      setTitle("Library Management");
      setVisible(true);
      setResizable(false);
       
    
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==b1){
           boolean status = false;
        try{
            connection con = new connection();
          String str = "select * from account where username=? and password=?";
               PreparedStatement st =con.conn.prepareStatement(str);
          
          st.setString(1,t1.getText());
          st.setString(2,p1.getText());
          
          ResultSet rs = st.executeQuery();
          if(rs.next()){
           this.setVisible(false);
           new loading().setVisible(true);
          }
          else
          {
          JOptionPane.showMessageDialog(null, "Invalid Login and password....!");
          }
          
        
        }catch(Exception e2){
          e2.printStackTrace();
        
        }
       
       
       
       }
       if(ae.getSource()==b2){
         setVisible(false);
         new signup().setVisible(true);
       
       
       }
    
    
    
    }
    public static void main(String [] args){
      new login();
    
    
    }
}
