package libraryproject;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Tushar Gupta
 */
public class statistics extends JFrame implements ActionListener{
    private JLabel l1,l2,l3;
    private JButton b1,b2;
    private JPanel panel;
    private JTable table1;
    private JTable table2;
    private JScrollPane scrollpane1;
    private JScrollPane scrollpane2;
    
    public void IssueBook(){
     try{
          connection con = new connection();
          String str = "select * from issuebook";
          PreparedStatement st = con.conn.prepareStatement(str);
          ResultSet rs = st.executeQuery();
          table1.setModel(DbUtils.resultSetToTableModel(rs));
     }catch(Exception e){
       e.printStackTrace();
     }
    }
    
    public void ReturnBook(){
     try{
          connection con = new connection();
          String str = "select * from returnbook";
          PreparedStatement st = con.conn.prepareStatement(str);
          ResultSet rs = st.executeQuery();
          table2.setModel(DbUtils.resultSetToTableModel(rs));
     }catch(Exception e){
       e.printStackTrace();
     }
    
    
    }
    
    public statistics(){
     setSize(700,700);
     setLocation(280,25);
     setResizable(false);
     panel = new JPanel();
     panel.setBackground(Color.WHITE);
     setTitle("Statistics");
     setContentPane(panel);
     setLayout(null);
     
     scrollpane1 = new JScrollPane();
     scrollpane1.setBounds(14,18,660,280);
     add(scrollpane1);
     
       table1 = new JTable();
       table1.setBackground(Color.CYAN);
       table1.setForeground(Color.red);
       table1.setFont(new Font("Italic", Font.BOLD,16));
       scrollpane1.setViewportView(table1);
     
       JPanel pane = new JPanel();
	pane.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Issue-Book-Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 128)));
	pane.setForeground(new Color(0, 128, 128));
	pane.setBounds(5, 3, 677, 300);
        pane.setBackground(Color.WHITE);
	panel.add(pane);
        
        
        
        scrollpane2 = new JScrollPane();
     scrollpane2.setBounds(14,325,660,280);
     add(scrollpane2);
     
       table2 = new JTable();
       table2.setBackground(Color.CYAN);
       table2.setForeground(Color.red);
       table2.setFont(new Font("Italic", Font.BOLD,16));
       scrollpane2.setViewportView(table2);
     
       JPanel pan = new JPanel();
	pan.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Return-Book-Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 128)));
	pan.setForeground(new Color(0, 128, 128));
	pan.setBounds(5, 310, 677, 300);
        pan.setBackground(Color.WHITE);
	panel.add(pan);
        
        b1 = new JButton("BACK");
        b1.setFont(new Font("Italic", Font.BOLD, 14));
       b1.setForeground(Color.BLACK);
       b1.setBackground(Color.PINK);
       b1.setBounds(270, 616, 100, 30);
       add(b1);
        b1.addActionListener(this);
      IssueBook();
      ReturnBook();
    
    }
    
    public void actionPerformed(ActionEvent ae){
       if (ae.getSource()==b1){
          setVisible(false);
          new home().setVisible(true);
       }
    }
    public static void main(String[] args) {
        new statistics().setVisible(true);
    }
}
