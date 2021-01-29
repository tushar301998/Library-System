/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryproject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
/**
 *
 * @author Tushar Gupta
 */
public class aboutus extends JFrame implements ActionListener{
    private JPanel contentPane;
    private JButton b5;
    public aboutus(){
        super("About Us ");
            
            setBackground(new Color(173, 216, 230));
            setBounds(300, 150, 700, 500);
            setResizable(false);
		
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);       


            JLabel l3 = new JLabel("Smart");
            l3.setForeground(new Color(0, 250, 154));
            l3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
            l3.setBounds(160, 40, 150, 55);
            contentPane.add(l3);

            JLabel l4 = new JLabel("Library System");
            l4.setForeground(new Color(127, 255, 0));
            l4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
            l4.setBounds(70, 90, 405, 40);
            contentPane.add(l4);

            JLabel l5 = new JLabel("v5.1");
            l5.setForeground(new Color(30, 144, 255));
            l5.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
            l5.setBounds(185, 140, 100, 21);
            contentPane.add(l5);


            JLabel l6 = new JLabel("Developed By : Tushar Gupta");
            l6.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
            l6.setBounds(70, 198, 600, 35);
            contentPane.add(l6);

            JLabel l7 = new JLabel("I Have Study HBTU , Kanpur");
            l7.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            l7.setBounds(70, 260, 600, 34);
            contentPane.add(l7);

            JLabel l8 = new JLabel("MY Gmail : tushg@gmail.com");
            l8.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            l8.setBounds(70, 290, 600, 34);
            contentPane.add(l8);

            JLabel l9 = new JLabel("MY CONTACT NUMBER : 8477092468");
            l9.setFont(new Font("Trebuchet MS", Font.BOLD , 20));
            l9.setBounds(70, 320, 600, 34);
            contentPane.add(l9);


            JLabel l10 = new JLabel("**If you want us to make Java Project for you, drop a mail**");
            l10.setForeground(new Color(47, 79, 79));
            l10.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
            l10.setBounds(70, 400, 600, 34);
            contentPane.add(l10);
                
                
            contentPane.setBackground(Color.WHITE);
            b5 = new JButton("BACK");
       b5.setFont(new Font("Italic",Font.BOLD,16));
       b5.setForeground(Color.BLACK);
       b5.setBackground(Color.PINK);
       b5.setBounds(540,20,100,30);
       add(b5);
       b5.addActionListener(this);
    
    
    
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==b5){
         setVisible(false);
         new home().setVisible(true);       
       }
    
    }
    public static void main(String[] args) {
        new aboutus().setVisible(true);
    }
}
