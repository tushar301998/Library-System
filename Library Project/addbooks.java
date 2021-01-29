package libraryproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
/**
 *
 * @author Tushar Gupta
 */
public class addbooks extends JFrame implements ActionListener{
    JPanel panel;
    private JLabel l1,l2,l3,l4,l5,l6,l7;
    private JButton b1,b2;
    private JTextField t1,t2,t3,t4,t5;
    JComboBox c1;
    public void random(){
    Random r1 = new Random();
    t1.setText(""+r1.nextInt(10000+1));
    }
    
    public addbooks(){
       setSize(600,550);
       setTitle("Book Detail");
       setLocation(300,100);
       setResizable(false);
       panel = new JPanel();
       setContentPane(panel);
       panel.setLayout((null));
       panel.setBackground(Color.WHITE);
       
       l6 = new JLabel("BOOK DETAIL...");
       l6.setForeground(Color.BLACK);
       l6.setFont(new Font("Italic",Font.BOLD,22));
       l6.setBounds(200,5,250,30);
       add(l6);
       
       
       l1 = new JLabel("Book_Id :");
       l1.setFont(new Font("Italic",Font.BOLD,17));
       l1.setForeground(Color.RED);
       l1.setBounds(60,75,100,20);
       add(l1);
       
        t1 = new JTextField();
        t1.setBounds(280,75,200,20);
        add(t1);
       
       l2 = new JLabel("Name    :");
       l2.setFont(new Font("Italic",Font.BOLD,17));
       l2.setForeground(Color.RED);
       l2.setBounds(60,125,100,22);
       add(l2);
       
       t2 = new JTextField();
       t2.setBounds(280,125,200,22);
       add(t2);
       
       l3 = new JLabel("Publisher   :");
       l3.setFont(new Font("Italic",Font.BOLD,17));
       l3.setForeground(Color.RED);
       l3.setBounds(60,175,100,20);
       add(l3);
       
       t3 = new JTextField();
       t3.setBounds(280,175,200,22);
       add(t3);
       
       l4= new JLabel("Price    :");
       l4.setFont(new Font("Italic",Font.BOLD,17));
       l4.setForeground(Color.RED);
       l4.setBounds(60,225,100,20);
       add(l4);
       
       t4 = new JTextField();
       t4.setBounds(280,225,200,20);
       add(t4);
       
       l5 = new JLabel("Edition :");
       l5.setFont(new Font("Italic",Font.BOLD,17));
       l5.setForeground(Color.RED);
       l5.setBounds(60,275,100,20);
       add(l5);
       
       String combo[] = {"1","2","3","4","5","6","7","8","9"};
       c1 = new JComboBox(combo);
       c1.setForeground(Color.BLACK);
       c1.setBounds(280,275,200,20);
       add(c1);
       
       l7 = new JLabel("Pages   :");
       l7.setFont(new Font("Italic",Font.BOLD,17));
       l7.setForeground(Color.RED);
       l7.setBounds(60,325,100,20);
       add(l7);
       
       t5 = new JTextField();
       t5.setBounds(280,325,200,20);
       add(t5);
       
       b1 = new JButton("SAVE");
       b1.setBackground(Color.PINK);
       b1.setForeground(Color.BLACK);
       b1.setBounds(150,420,100,30);
       add(b1);
       b1.addActionListener(this);
       
       b2 = new JButton("BACK");
       b2.setBackground(Color.PINK);
       b2.setForeground(Color.BLACK);
       b2.setBounds(280,420,100,30);
       add(b2);
       b2.addActionListener(this);
       
       random();
    }
    public void actionPerformed(ActionEvent ae){
        try{
            connection con = new connection();
            if(ae.getSource()==b1){
              String str = "insert into book(book_id, name, publisher, price, edition, page)values(?, ?, ?, ?, ?, ?)";
             PreparedStatement st = con.conn.prepareStatement(str);
             st.setString(1, t1.getText());
             st.setString(2, t2.getText());
             st.setString(3, t3.getText());
             st.setString(4, t4.getText());
             st.setString(5, (String)c1.getSelectedItem());
             st.setString(6, t5.getText());
             
             int rs = st.executeUpdate();
             if(rs>0){
                JOptionPane.showMessageDialog(null,"Inserted Suceesfully");
             
             }else
                 JOptionPane.showMessageDialog(null, "Error");
            }
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            
             if(ae.getSource()==b2){
          setVisible(false);
          new home().setVisible(true);
        }
             con.conn.close();
        }catch(Exception e){
          e.printStackTrace();
        }
       
    
    
    
    }
    public static void main(String[] args) {
        new addbooks().setVisible(true);
    }
}
