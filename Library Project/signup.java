package libraryproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author Tushar Gupta
 */
public class signup extends JFrame implements ActionListener{
    private JLabel l1,l2,l3;
    private JTextField t1,t2;
    private JButton b1,b2;
    private JPasswordField p1;
    JPanel pane1;
    
    public signup(){
        pane1 = new JPanel();
        pane1.setBackground(new Color(176, 224, 230));
        setContentPane(pane1);
        pane1.setLayout(null);
        
        l1 = new JLabel("username   :");
        
        l2 = new JLabel("password   :");
        l3 = new JLabel("name   :");
        t1 = new JTextField();
        t2 = new JTextField();
        p1 = new JPasswordField();
        b1 = new JButton("SAVE");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.RED);
        b2 = new JButton("BACK");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.RED);
        
        l1.setBounds(80,60,200,40);
        add(l1);
        
        t1.setBounds(280,60,200,30);
        add(t1);
        
        l2.setBounds(80,110,200,40);
        add(l2);
        
        p1.setBounds(280,110,200,30);
        add(p1);
        
        l3.setBounds(80,170,200,40);
        add(l3);
        
        
        t2.setBounds(280,170,200,30);
        add(t2);
        
        b1.setBounds(180,350,100,40);
        add(b1);
        b1.addActionListener(this);
        
        b2.setBounds(350,350,100,40);
        add(b2);
        b2.addActionListener(this);
     
     setBackground(new Color(169, 169, 169));
      setSize(650,500);
      setLocation(350,120);
      setTitle("New Account");
      setVisible(true);
      setResizable(false);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            connection con = new connection();
            if(ae.getSource()==b1){
            String q = "insert into account(username, password, name)values(?, ?, ?)";
            PreparedStatement st = con.conn.prepareStatement(q);
            st.setString(1,t1.getText());
            st.setString(2,p1.getText());
            st.setString(3,t2.getText());
            
            int i=st.executeUpdate();
            if(i>0)
                JOptionPane.showMessageDialog(null,"Created Account Successfully");
            t1.setText("");
            p1.setText("");
            t2.setText("");
            }
            if(ae.getSource()==b2){
                this.setVisible(false);
              new login().setVisible(true);
            }
        
        
        }catch(Exception e){
           e.printStackTrace();
        
        }    
    
    
    
    }
    public static void main(String[] args) {
        new signup().setVisible(true);
    }
}




