/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author RemasTech
 */
public class Model {
    
     private Connection connect() throws SQLException{
    
    Connection conn= null;
    String url = "jdbc:sqlite:C:/Users/RemasTech/Desktop/UQU/Advance Programming/Project/Myhealth.db";
    conn = DriverManager.getConnection(url);
        System.out.println("Connection to SQLite has been established");
        return conn;
    }
            
      public void registerUser ( String Fname,String Lname, String Email, String Mobil, String age, String username, String Pass,String gender) throws SQLException{
      String sql = "INSERT INTO coustemr (fname,lname,phone,age,Gendar,UserName,email, Password )"
              + " VALUES ('"+Fname+"','"+Lname+"',"+Mobil+","+age+",'"+gender+"','"+username+"','"+Email+"','"+Pass+"' )";
      Connection con =  this.connect();
      Statement st = con.createStatement();
      st.executeUpdate(sql);
      st.close();
      con.close ();
          System.out.println("okay  ");
      }
       public boolean loginuser (String username, String password )throws SQLException  
       {
           
           String sql = "SELECT UserName, Password FROM coustemr";
             Connection con =  this.connect();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      boolean b = false;    
      while(rs.next())
        {
            String n = rs.getString("UserName");
            String p = rs.getString("Password");
            if(username.equals(n) && password.equals(p))
            {
               
                b = true;
                break;
            }
            else
            {
                
                b= false;
            }
            
        }
         st.close();
         con.close();
        return b;
        
    }  

    
}
