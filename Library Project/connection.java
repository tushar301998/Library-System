/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryproject;
import java.sql.*;
/**
 *
 * @author Tushar Gupta
 */
public class connection {
     Connection conn=null;
       Statement st=null;
   public connection(){
       
        try{
          Class.forName("com.mysql.jdbc.Driver");
          
          conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
          
          st = conn.createStatement();
        
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException ae){
          ae.printStackTrace();
        }
        
    }

   
}
