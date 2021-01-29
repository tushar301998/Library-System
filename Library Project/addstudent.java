package libraryproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import javax.swing.border.*;
/**
 *
 * @author Tushar Gupta
 */
public class addstudent extends JFrame implements ActionListener{
    private JLabel l1,l2,l3,l4,l5,l6,l7;
    private JTextField t1,t2,t3;
    private JButton b1,b2;
    private JComboBox c1,c2,c3;
    JPanel pane;
     public void random(){
    Random r2 = new Random();
    t1.setText(""+r2.nextInt(10000+1));
    }
    
    
    public addstudent(){
      setSize(600,600);
      setLocation(300,100);
      setTitle("Student details");
      setResizable(false);
      pane = new JPanel();
      pane.setBorder(new EmptyBorder(5,50,50,10));
      setContentPane(pane);
      pane.setLayout(null);
      
      l1 = new JLabel("Student Details...");
      l1.setFont(new Font("Italic",Font.BOLD,22));
      l1.setBounds(200,5,250,28);
      add(l1);
      
      l7 = new JLabel("Student Id   :");
      l7.setFont(new Font("Italic",Font.BOLD,17));
      l7.setForeground(Color.RED);
      l7.setBounds(100,55,150,20);
      add(l7);
      
      t1 = new JTextField();
      t1.setBounds(300,54,200,20);
      add(t1);
      
      
      l2 = new JLabel("Name :");
      l2.setFont(new Font("Italic",Font.BOLD,17));
      l2.setForeground(Color.RED);
      l2.setBounds(100,105,150,20);
      add(l2);
      
      t2 = new JTextField();
      t2.setBounds(300,104,200,20);
      add(t2);
      
      l3 = new JLabel("Father Name    :");
      l3.setFont(new Font("Italic",Font.BOLD,17));
      l3.setForeground(Color.RED);
      l3.setBounds(100,170,150,20);
      add(l3);
      
      t3 = new JTextField("");
      t3.setBounds(300,169,200,20);
      add(t3);
      
      l4 = new JLabel("Branch   :");
      l4.setFont(new Font("Italic",Font.BOLD,17));
      l4.setForeground(Color.RED);
      l4.setBounds(100,230,150,20);
      add(l4);
      
      String branch[] = {"CSE","IT","ME","CE","PT","OT","MCA"};
      c1 = new JComboBox(branch);
      c1.setBackground(Color.WHITE);
      c1.setForeground(Color.BLACK);
      c1.setBounds(300,219,200,20);
      add(c1);
      
      
      
      l5 = new JLabel("Year :");
      l5.setFont(new Font("Italic",Font.BOLD,17));
      l5.setForeground(Color.RED);
      l5.setBounds(100,290,150,20);
      add(l5);
      
      String year[] ={"1st","2nd","3rd","4th"};
      c2 = new JComboBox(year);
      c2.setBackground(Color.WHITE);
      c2.setForeground(Color.BLACK);
      c2.setBounds(300,289,200,20);
      add(c2);
      
      l6 = new JLabel("Semester :");
      l6.setFont(new Font("Italic",Font.BOLD,17));
      l6.setForeground(Color.RED);
      l6.setBounds(100,340,150,20);
      add(l6);
      
      String sem[]={"1st","2nd","3rd","4th","5th","6th","7th","8th"};
      c3 = new JComboBox(sem);
      c3.setBackground(Color.WHITE);
      c3.setForeground(Color.BLACK);
      c3.setBounds(300,339,200,20);
      add(c3);
      
      b1 = new JButton("SAVE");
      b1.setBackground(Color.PINK);
      b1.setForeground(Color.BLACK);
      b1.setBounds(140,440,120,40);
      add(b1);
      b1.addActionListener(this);
      
      b2 = new JButton("BACK");
      b2.setBackground(Color.PINK);
      b2.setForeground(Color.BLACK);
      b2.setBounds(290,440,120,40);
      add(b2);
      b2.addActionListener(this);
      
      JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(102, 205, 170), 2, true), "Add-Student",
			TitledBorder.LEADING, TitledBorder.CENTER, null, new Color(30, 144, 255)));
	panel.setBackground(new Color(211, 211, 211));
	panel.setBounds(10,25,555,520);
        
        pane.setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);
        
	pane.add(panel);
       random();
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
       connection con = new connection();
       if(ae.getSource()==b1){
          String str = "insert into student(student_id, name, fathername, branch, year, semester)values(?, ?, ?, ?, ?, ?)";
          PreparedStatement st = con.conn.prepareStatement(str);
          st.setString(1, t1.getText());
          st.setString(2, t2.getText());
          st.setString(3, t3.getText());
          st.setString(4,(String)c1.getSelectedItem());
          st.setString(5,(String)c2.getSelectedItem());
          st.setString(6,(String)c3.getSelectedItem());
          
          int rs = st.executeUpdate();
          if(rs>0)
              JOptionPane.showMessageDialog(null,"Inserted Sucessfully");
          else
              JOptionPane.showMessageDialog(null,"Error");
          
          
 
          t2.setText("");
          t3.setText("");
           
         
 
          
       
       
       }
        if(ae.getSource()==b2){
            setVisible(false);
          new home().setVisible(true);
        
        }
        }catch(Exception e){
          e.printStackTrace();
        }
    
    
    
    }
    public static void main(String[] args) {
        new addstudent().setVisible(true);
    }
            
    
}
