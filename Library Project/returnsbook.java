package libraryproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

public class returnsbook extends JFrame implements ActionListener {
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    private JTextField t1,t2,t3,t4,t5,t6,t7;
    private JButton b1,b2,b3;
    private JPanel panel;
    
    public returnsbook(){
    setSize(600,590);
    setLocation(280,50);
    setResizable(false);
    setTitle("Return Books");
    panel = new JPanel();
    setContentPane(panel);
    panel.setBackground(Color.WHITE);
    setLayout(null);
    
    l1 = new JLabel("Return Book");
    l1.setFont(new Font("Italic",Font.BOLD,18));
    l1.setForeground(Color.BLUE);
    l1.setBounds(230,10,200,30);
    add(l1);
    
       b1 = new JButton("SEARCH");
       b1.setFont(new Font("Italic", Font.BOLD, 14));
       b1.setForeground(Color.BLACK);
       b1.setBackground(Color.PINK);
       b1.setBounds(460, 80, 100, 30);
       add(b1);
       b1.addActionListener(this);
    
    l2 = new JLabel("Enter Book ID :");
    l2.setFont(new Font("Tahoma", Font.BOLD, 14));
    l2.setForeground(Color.RED);
    l2.setBounds(30, 100, 150, 25);
    add(l2);
    
    t1 = new JTextField();
    t1.setBounds(240,102,200,25);
    add(t1);
    
    l3 = new JLabel("Enter Student ID :");
    l3.setFont(new Font("Tahoma", Font.BOLD, 14));
    l3.setForeground(Color.RED);
    l3.setBounds(30, 160, 150, 25);
    add(l3);
    
    t2 = new JTextField();
    t2.setBounds(240,162,200,25);
    add(t2);
    
    l4 = new JLabel("Book :");
    l4.setFont(new Font("Tahoma", Font.BOLD, 14));
    l4.setForeground(Color.RED);
    l4.setBounds(30, 210, 150, 25);
    add(l4);
    
    t3 = new JTextField();
    t3.setBounds(240,212,200,25);
    add(t3);
    
    l5 = new JLabel("Student Name :");
    l5.setFont(new Font("Tahoma", Font.BOLD, 14));
    l5.setForeground(Color.RED);
    l5.setBounds(30, 260, 150, 25);
    add(l5);
    
    t4 = new JTextField();
    t4.setBounds(240,262,200,25);
    add(t4);
    
    l6 = new JLabel("Branch :");
    l6.setFont(new Font("Tahoma", Font.BOLD, 14));
    l6.setForeground(Color.RED);
    l6.setBounds(30, 310, 150, 25);
    add(l6);
    
    t5 = new JTextField();
    t5.setBounds(240,312,200,25);
    add(t5);
    
    l7 = new JLabel("Date Of Issue :");
    l7.setFont(new Font("Tahoma", Font.BOLD, 14));
    l7.setForeground(Color.RED);
    l7.setBounds(30, 360, 150, 25);
    add(l7);
    
    t6 = new JTextField();
    t6.setBounds(240,362,200,25);
    add(t6);
    
    
    
    
    JPanel pane = new JPanel();
	pane.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Returns-Book",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	pane.setFont(new Font("Tahoma", Font.BOLD, 14));
	pane.setBounds(10, 60, 568, 380);
        pane.setBackground(Color.WHITE);
	panel.add(pane);
        
        l8 = new JLabel("Enter Return Date :");
        l8.setFont(new Font("Tahoma", Font.BOLD, 14));
        l8.setForeground(Color.RED);
        l8.setBounds(5, 460, 150, 25);
        add(l8);
        
        t7 = new JTextField();
    t7.setBounds(155,462,200,25);
    add(t7);
    
       b2 = new JButton("RETURN");
       b2.setFont(new Font("Italic", Font.BOLD, 14));
       b2.setForeground(Color.BLACK);
       b2.setBackground(Color.PINK);
       b2.setBounds(365, 460, 100, 30);
       add(b2);
       b2.addActionListener(this);
       
       b3 = new JButton("BACK");
       b3.setFont(new Font("Italic", Font.BOLD, 14));
       b3.setForeground(Color.BLACK);
       b3.setBackground(Color.PINK);
       b3.setBounds(475, 460, 100, 30);
       add(b3);
       b3.addActionListener(this);
        
    
    
    }
    public void actionPerformed(ActionEvent ae){
      try{
          connection con = new connection();
          if(ae.getSource()==b1){
             String str = "select * from issuebook where book_id = ? and student_id = ?";
             PreparedStatement st = con.conn.prepareStatement(str);
             st.setString(1, t1.getText());
             st.setString(2, t2.getText());
             ResultSet rs = st.executeQuery();
             while(rs.next()){
                t3.setText(rs.getString("bname"));
                t4.setText(rs.getString("sname"));
                t5.setText(rs.getString("branch"));
                t6.setText(rs.getString("date"));
             }
          }
          
          if(ae.getSource()==b2){
             String str = "insert into returnbook(book_id, student_id, bname, sname, branch, issuedate, returndate)values(?, ?, ?, ?, ?, ?, ?)";
             PreparedStatement st = con.conn.prepareStatement(str);
             st.setString(1, t1.getText());
             st.setString(2, t2.getText());
             st.setString(3, t3.getText());
             st.setString(4, t4.getText());
             st.setString(5, t5.getText());
             st.setString(6, t6.getText());
             st.setString(7, t7.getText());
             int i = st.executeUpdate();
             if(i>0){
                JOptionPane.showMessageDialog(null, "Return Succesfull");
             }
             else{
               JOptionPane.showMessageDialog(null, "Error!!...");
             }
             t1.setText("");
             t2.setText("");
             t3.setText("");
             t4.setText("");
             t5.setText("");
             t6.setText("");
             t7.setText("");
          
          
          }
          
          if(ae.getSource()==b3){
             setVisible(false);
             new home().setVisible(true);
          
          }
      
      
      
      
      }catch(Exception e){
        e.printStackTrace();
      }
    
    }
    public static void main(String[] args) {
        new returnsbook().setVisible(true);
    }
    
}
