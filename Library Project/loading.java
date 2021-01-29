package libraryproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Tushar Gupta
 */
public class loading extends JFrame implements Runnable
{
    private JPanel pane1;
    private JLabel l1,l2;
    private JProgressBar progress;
    Thread th;
    int s;
    
    public loading(){
        th  = new Thread((Runnable)this);
      
       pane1 = new JPanel();
       setContentPane(pane1);
       pane1.setBackground(Color.WHITE);
       pane1.setLayout(null);
        
        l1 = new JLabel("SMART LIBRARY PROJECT....");
        l1.setFont(new Font("Italic",Font.BOLD,25));
        l1.setForeground(Color.BLUE);
        l1.setBounds(80,50,370,30);
        add(l1);
        
        progress = new JProgressBar();
        progress.setFont(new Font("Tahoma",Font.BOLD,20));
        progress.setStringPainted(true);
        progress.setBounds(60,150,400,40);
        add(progress);
        
        l2 = new JLabel("Please Wait....");
        l2.setFont(new Font("Italic",Font.BOLD,15));
        l2.setForeground(Color.RED);
        l2.setBounds(190,200,120,20);
        add(l2);
        
        
        
        
        
       setBounds(350,120,550,450);
       setTitle("Loading....");
       setResizable(false);
      
       setUploading();
    
    }
    public void setUploading(){
      setVisible(false);
      th.start();
    }
    
    public void run(){
      try{
          for(int i=1;i<200;i++){
             s=s+1;
             int m = progress.getMaximum();
             int v = progress.getValue();
             if(v<m)
                 progress.setValue(progress.getValue()+1);
             else
             {
                i=201;
                setVisible(false);
                new home().setVisible(true);
             
             }
             Thread.sleep(80);
          }
          
          
      }catch(Exception e){
        e.printStackTrace();
      }
    
    }
    
    public static void main(String[] args) {
        new loading().setVisible(true);
    }
}
