package libraryproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author Tushar Gupta
 */
public class home extends JFrame implements ActionListener{
    private JButton b1,b2,b3,b4,b5,b6;
    private JPanel panel;
    JMenuBar menubar;
    JMenu menu1,menu2,menu3;
    JMenuItem i1,i2,i3,i4,i5;
    
    public home(){
      setSize(900,680);
      setLocation(230,15);
      setResizable(false);
      setTitle("Library Management System");
      panel = new JPanel();
      panel.setLayout(null);
      panel.setBackground(Color.WHITE);
      setContentPane(panel);
      
       menubar = new JMenuBar();
       menubar.setBackground(Color.CYAN);
       menubar.setBounds(0,12,900,40);
       add(menubar);
       
       menu1 = new JMenu("Record");
       menu1.setFont(new Font("Italic",Font.BOLD,18));
       menubar.add(menu1);
       
       menu2 = new JMenu("Exit");
       menu2.setFont(new Font("Italic",Font.BOLD,18));
       menubar.add(menu2);
       
       menu3 = new JMenu("Help");
       menu3.setFont(new Font("Italic",Font.BOLD,18));
       menubar.add(menu3);
       
       i1 = new JMenuItem("Book Details");
       i1.setForeground(Color.BLACK);
       i1.setBackground(Color.WHITE);
       menu1.add(i1);
       i1.addActionListener(this);
       
       i2 = new JMenuItem("Student Details");
       i2.setForeground(Color.BLACK);
       i2.setBackground(Color.WHITE);
       menu1.add(i2);
       i2.addActionListener(this);
       
       i3 = new JMenuItem("Logout");
       i3.setForeground(Color.BLACK);
       i3.setBackground(Color.WHITE);
       i3.addActionListener(this);
       menu2.add(i3);
       
       i4 = new JMenuItem("Exit");
       i4.setForeground(Color.BLACK);
       i4.setBackground(Color.WHITE);
       i4.addActionListener(this);
       menu2.add(i4);
       
       i5 = new JMenuItem("Read Me");
       i5.setForeground(Color.BLACK);
       i5.setBackground(Color.WHITE);
       menu3.add(i5);
       
       b1 = new JButton("ADD BOOKS");
       b1.setFont(new Font("Italic",Font.BOLD,40));
       b1.setForeground(Color.BLACK);
       b1.setBackground(Color.PINK);
       b1.setBounds(10,100,400,60);
       add(b1);
       b1.addActionListener(this);
       
       b2 = new JButton("ADD STUDENT");
       b2.setFont(new Font("Italic",Font.BOLD,40));
       b2.setForeground(Color.BLACK);
       b2.setBackground(Color.PINK);
       b2.setBounds(470,100,400,60);
       add(b2);
       b2.addActionListener(this);
       
       b3 = new JButton("ISSUE BOOKS");
       b3.setFont(new Font("Italic",Font.BOLD,40));
       b3.setForeground(Color.BLACK);
       b3.setBackground(Color.PINK);
       b3.setBounds(10,300,400,60);
       add(b3);
       b3.addActionListener(this);
       
       b4 = new JButton("RETURNS BOOKS");
       b4.setFont(new Font("Italic",Font.BOLD,40));
       b4.setForeground(Color.BLACK);
       b4.setBackground(Color.PINK);
       b4.setBounds(470,300,400,60);
       add(b4);
       b4.addActionListener(this);
       
       b5 = new JButton("STATISTICS");
       b5.setFont(new Font("Italic",Font.BOLD,40));
       b5.setForeground(Color.BLACK);
       b5.setBackground(Color.PINK);
       b5.setBounds(10,500,400,60);
       add(b5);
       b5.addActionListener(this);
       
       
       b6 = new JButton("ABOUT ME");
       b6.setFont(new Font("Italic",Font.BOLD,40));
       b6.setForeground(Color.BLACK);
       b6.setBackground(Color.PINK);
       b6.setBounds(470,500,400,60);
       add(b6);
       b6.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
     String msg = ae.getActionCommand();
     if(msg.equals("Logout")){
       setVisible(false);
       new login().setVisible(true);
     }
     else if(msg.equals("Exit")){
        System.exit(0);
     }
     else if(msg.equals("Book Details")){
       setVisible(false);
        new bookdetails().setVisible(true);
     }
     else if(msg.equals("Student Details")){
       setVisible(false);
        new studentdetails().setVisible(true);
     }
     if(b1==ae.getSource()){
       setVisible(false);
        new addbooks().setVisible(true);
     }
     if(ae.getSource()==b2){
       this.setVisible(false);
        new addstudent().setVisible(true);
     }
     if(ae.getSource()==b3){
       this.setVisible(false);
         new issuebook().setVisible(true);
     }
     if(ae.getSource()==b4){
       this.setVisible(false);
        new returnsbook().setVisible(true);
     }
     if(ae.getSource()==b5){
       this.setVisible(false);
       new statistics().setVisible(true);
     }
     if(ae.getSource()==b6){
        setVisible(false);
        new aboutus().setVisible(true);
     
     }
    }
    public static void main(String[] args) {
        new home().setVisible(true);
    }
}
