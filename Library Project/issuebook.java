package libraryproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

public class issuebook extends JFrame implements ActionListener{
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    private JButton b1,b2,b3,b4;
    private JPanel panel;
    
    public issuebook(){
    setSize(800,550);
    setLocation(250,70);
    setResizable(false);
    setTitle("Issue Books");
    panel = new JPanel();
    setContentPane(panel);
    panel.setBackground(Color.WHITE);
    setLayout(null);
    
    l1 = new JLabel("ISSUE BOOK....");
    l1.setFont(new Font("Italic",Font.BOLD,18));
    l1.setForeground(Color.RED);
    l1.setBounds(320,10,200,20);
    add(l1);
    
    l8 = new JLabel("Enter Book ID to search book");
    l8.setFont(new Font("Tahoma", Font.BOLD, 14));
    l8.setForeground(Color.BLUE);
    l8.setBounds(30, 80, 250, 25);
    add(l8);
    
    b1 = new JButton("SEARCH");
    b1.setFont(new Font("Italic", Font.BOLD, 14));
    b1.setForeground(Color.BLACK);
    b1.setBackground(Color.PINK);
    b1.setBounds(260, 80, 100, 30);
    add(b1);
    b1.addActionListener(this);
    
    l2 = new JLabel("Book_Id :");
    l2.setFont(new Font("Tahoma", Font.BOLD, 14));
    l2.setForeground(Color.RED);
    l2.setBounds(30, 130, 100, 25);
    add(l2);
    
    t1 = new JTextField();
    t1.setBounds(170,132,170,20);
    add(t1);
    
    l3 = new JLabel("Name :");
    l3.setFont(new Font("Tahoma", Font.BOLD, 14));
    l3.setForeground(Color.RED);
    l3.setBounds(30, 170, 100, 25);
    add(l3);
    
     t2 = new JTextField();
    t2.setBounds(170,172,170,20);
    add(t2);
    
    l4 = new JLabel("Publisher :");
    l4.setFont(new Font("Tahoma", Font.BOLD, 14));
    l4.setForeground(Color.RED);
    l4.setBounds(30, 210, 100, 25);
    add(l4);
    
     t3 = new JTextField();
    t3.setBounds(170,212,170,20);
    add(t3);
    
    
    l5 = new JLabel("Price :");
    l5.setFont(new Font("Tahoma", Font.BOLD, 14));
    l5.setForeground(Color.RED);
    l5.setBounds(30, 250, 100, 25);
    add(l5);
    
     t4 = new JTextField();
    t4.setBounds(170,252,170,20);
    add(t4);
    
    l6 = new JLabel("Editon :");
    l6.setFont(new Font("Tahoma", Font.BOLD, 14));
    l6.setForeground(Color.RED);
    l6.setBounds(30, 290, 100, 25);
    add(l6);
    
     t5 = new JTextField();
    t5.setBounds(170,292,170,20);
    add(t5);
    
    l7 = new JLabel("Pages :");
    l7.setFont(new Font("Tahoma", Font.BOLD, 14));
    l7.setForeground(Color.RED);
    l7.setBounds(30, 330, 100, 25);
    add(l7);
    
     t6 = new JTextField();
    t6.setBounds(170,332,170,20);
    add(t6);
    
    
    JPanel pane = new JPanel();
	pane.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Book-Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	pane.setFont(new Font("Tahoma", Font.BOLD, 14));
	pane.setBounds(10, 50, 370, 360);
        pane.setBackground(Color.WHITE);
	panel.add(pane);
        
        
        l8 = new JLabel("Enter Student ID to Search");
        l8.setFont(new Font("Tahoma", Font.BOLD, 14));
        l8.setForeground(Color.BLUE);
        l8.setBounds(420, 80, 250, 25);
        add(l8);
        
        b2 = new JButton("SEARCH");
        b2.setFont(new Font("Italic", Font.BOLD, 14));
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.PINK);
        b2.setBounds(650, 80, 100, 30);
        add(b2);
        b2.addActionListener(this);
        
        l9 = new JLabel("Student_ID :");
        l9.setFont(new Font("Tahoma", Font.BOLD, 14));
        l9.setForeground(Color.RED);
        l9.setBounds(420, 130, 100, 25);
       add(l9);
       
       t7 = new JTextField();
       t7.setBounds(560,132,170,20);
       add(t7);
       
        l10 = new JLabel("Name :");
        l10.setFont(new Font("Tahoma", Font.BOLD, 14));
        l10.setForeground(Color.RED);
        l10.setBounds(420, 170, 100, 25);
       add(l10);
       
       t8 = new JTextField();
       t8.setBounds(560,172,170,20);
       add(t8);
       
       l11 = new JLabel("Father Name :");
       l11.setFont(new Font("Tahoma", Font.BOLD, 14));
        l11.setForeground(Color.RED);
        l11.setBounds(420, 210, 100, 25);
       add(l11);
       
       t9 = new JTextField();
       t9.setBounds(560,212,170,20);
       add(t9);
       
       l12 = new JLabel("Branch :");
       l12.setFont(new Font("Tahoma", Font.BOLD, 14));
        l12.setForeground(Color.RED);
        l12.setBounds(420, 250, 100, 25);
       add(l12);
       
       t10 = new JTextField();
       t10.setBounds(560,252,170,20);
       add(t10);
       
       l13 = new JLabel("Year :");
       l13.setFont(new Font("Tahoma", Font.BOLD, 14));
        l13.setForeground(Color.RED);
        l13.setBounds(420, 290, 100, 25);
       add(l13);
       
       t11 = new JTextField();
       t11.setBounds(560,292,170,20);
       add(t11);
       
       l14 = new JLabel("Semester :");
       l14.setFont(new Font("Tahoma", Font.BOLD, 14));
        l14.setForeground(Color.RED);
        l14.setBounds(420, 330, 100, 25);
       add(l14);
       
        t12 = new JTextField();
       t12.setBounds(560,332,170,20);
       add(t12);
        
        JPanel panel_1 = new JPanel();
	panel_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180), 2, true), "Student-Deatails",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100, 149, 237)));
	panel_1.setForeground(new Color(0, 100, 0));
	panel_1.setBounds(394, 50, 378, 360);
        panel_1.setBackground(Color.WHITE);
	panel.add(panel_1);
        
        l15 = new JLabel("Enter Date to Issue Book :");
        l15.setFont(new Font("Tahoma", Font.BOLD, 18));
        l15.setForeground(Color.BLUE);
        l15.setBounds(30, 435, 250, 25);
       add(l15);
       
       t13 = new JTextField();
       t13.setBounds(300,437,200,20);
       add(t13);
       
       b3 = new JButton("ISSUE");
       b3.setFont(new Font("Italic", Font.BOLD, 14));
       b3.setForeground(Color.BLACK);
       b3.setBackground(Color.PINK);
       b3.setBounds(530, 432, 100, 30);
       add(b3);
       b3.addActionListener(this);
       
       b4 = new JButton("BACK");
       b4.setFont(new Font("Italic", Font.BOLD, 14));
       b4.setForeground(Color.BLACK);
       b4.setBackground(Color.PINK);
       b4.setBounds(650, 432, 100, 30);
       add(b4);
       b4.addActionListener(this);
    
    }
    public void actionPerformed(ActionEvent ae){
        try{
          connection con = new connection();
          if(ae.getSource()==b1){
          String str = "select * from book where book_id = ?";
          PreparedStatement st = con.conn.prepareStatement(str);
          st.setString(1, t1.getText());
          ResultSet rs = st.executeQuery();
          
          while(rs.next()){
          t2.setText(rs.getString("name"));
          t3.setText(rs.getString("publisher"));
          t4.setText(rs.getString("price"));
          t5.setText(rs.getString("edition"));
          t6.setText(rs.getString("page"));
          }
      }
          if(ae.getSource()==b2){
          String str = "select * from student where student_id = ?";
          PreparedStatement st = con.conn.prepareStatement(str);
          st.setString(1, t7.getText());
          ResultSet rs = st.executeQuery();
          
          while(rs.next()){
              t8.setText(rs.getString("name"));
              t9.setText(rs.getString("fathername"));
              t10.setText(rs.getString("branch"));
              t11.setText(rs.getString("year"));
              t12.setText(rs.getString("semester"));
          }
       }
          if(ae.getSource()==b3){
            String str = "insert into issuebook(book_id, student_id, bname, sname, branch, year, date)values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.conn.prepareStatement(str);
            st.setString(1, t1.getText());
            st.setString(2, t7.getText());
            st.setString(3, t2.getText());
            st.setString(4, t8.getText());
            st.setString(5, t10.getText());
            st.setString(6, t11.getText());
            st.setString(7, t13.getText());
            
            int i = st.executeUpdate();
            if(i>0){
            JOptionPane.showMessageDialog(null, "Book Issue Confirm");
            }else{
              JOptionPane.showMessageDialog(null, "ERROR !!!");
            }
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("");
            t9.setText("");
            t10.setText("");
            t11.setText("");
            t12.setText("");
            t13.setText("");
          }  
        if(ae.getSource()==b4){
          setVisible(false);
          new home().setVisible(true);
        }
        
        }catch(Exception e){
             e.printStackTrace();
        }  
      }
        
    public static void main(String[] args) {
        new issuebook().setVisible(true);
    }
}
