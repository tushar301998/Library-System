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
public class studentdetails extends JFrame implements ActionListener{
     private JLabel l1,l2,l3;
    private JButton b1,b2,b3;
    private JTextField t1;
    private JTable table;
    private JPanel panel;
    private JScrollPane scroll;
    
    public void Student(){
      try{
        connection con = new connection();
        String str = "select * from student";
        PreparedStatement st = con.conn.prepareStatement(str);
        ResultSet rs = st.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
        st.close();
        rs.close();
      
      
      }catch(Exception e){
       e.printStackTrace();
      }
    }
    
    public studentdetails(){
    setSize(800,600);
      setLocation(300,100);
      setResizable(false);
      setTitle("Books Details");
      panel = new JPanel();
      panel.setBackground(Color.WHITE);
      setContentPane(panel);
      panel.setLayout(null);
      
      scroll = new JScrollPane();
      scroll.setBounds(10,120,760,430);
      add(scroll);
      
      table = new JTable();
      table.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent args){
        int row = table.getSelectedRow();
        t1.setText(table.getModel().getValueAt(row,1).toString());
      }
         });
        
        table.setBackground(Color.CYAN);
      table.setForeground(Color.BLACK);
      table.setFont(new Font("Italic",Font.BOLD,16));
      scroll.setViewportView(table);
      
      b1 = new JButton("SEARCH");
     b1.setBackground(Color.PINK);
     b1.setForeground(Color.BLACK);
     b1.setFont(new Font("italic",Font.BOLD,18));
     b1.setBounds(430,55,150,40);
     add(b1);
     b1.addActionListener(this);
     
     b2 = new JButton("DELETE");
     b2.setBackground(Color.PINK);
     b2.setForeground(Color.BLACK);
     b2.setFont(new Font("italic",Font.BOLD,18));
     b2.setBounds(620,55,150,40);
     add(b2);
     b2.addActionListener(this);
     
     l1 = new JLabel("Student Details...");
     l1.setFont(new Font("Italic",Font.BOLD,20));
     l1.setForeground(Color.RED);
     l1.setBounds(330,10,300,20);
     add(l1);
     
     t1 = new JTextField();
     t1.setBounds(170,60,200,30);
     add(t1);
     t1.setColumns(10);
     
      b3 = new JButton("BACK");
     b3.setBackground(Color.PINK);
     b3.setForeground(Color.BLACK);
     b3.setFont(new Font("italic",Font.BOLD,18));
     b3.setBounds(10,55,120,30);
     add(b3);
     b3.addActionListener(this);
      Student();
      
      
      
     
    
    
    
    }
    public void actionPerformed(ActionEvent ae){
      try{
        connection con = new connection();
        if(ae.getSource()==b1){
           String str = "select * from student where concat(name, student_id) like ?";
           PreparedStatement st = con.conn.prepareStatement(str);
           st.setString(1, "%" + t1.getText() + "%");
           ResultSet rs = st.executeQuery();
           
           table.setModel(DbUtils.resultSetToTableModel(rs));
           rs.close();
           st.close();
        }
        if(ae.getSource()==b2){
          String str = "delete from student where name='" + t1.getText() + "'";
         PreparedStatement st = con.conn.prepareStatement(str);
         JDialog.setDefaultLookAndFeelDecorated(true);
         int response = JOptionPane.showConfirmDialog(null,"Do you want to continue ?","confirm",
                 JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
         if(response==JOptionPane.NO_OPTION){
         
         }else if(response==JOptionPane.YES_OPTION){
            int rs=st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Deleted !");
         }else if(response==JOptionPane.CLOSED_OPTION){
         }
         
        
        }
        if(ae.getSource()==b3){
          setVisible(false);
          new home().setVisible(true);
        }
      
       con.conn.close();
      
      }catch(Exception e){
           e.printStackTrace();
      }
      
    
    }
    public static void main(String[] args) {
        new studentdetails().setVisible(true);
    }
}
