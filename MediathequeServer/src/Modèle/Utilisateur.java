/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.io.IOException;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hiba-
 */
public abstract class Utilisateur {
     private String Login,Password;
     
     static private int n=0;
     private int nl;
 public Statement stmt; 
   public void connexion() throws SQLException {
    
    Connection conx = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/mediatheque",
                         "root",
                         "");
   
           stmt = (Statement) conx.createStatement();

}
   public final  String GenererPassword() throws SQLException{
       connexion();
     String  sql="SELECT * FROM authentification WHERE retenu="+0+" LIMIT 1";
     ResultSet res=stmt.executeQuery(sql);
     if(res.next()){
       String st=res.getString("password");  
       return st;
     }
       return null;
   }
	
   public final String GenererLogin() throws SQLException{
       connexion();
     String  sql="SELECT * FROM authentification WHERE retenu="+0+" LIMIT 1";
       ResultSet res=stmt.executeQuery(sql);
     if(res.next()){
       String st=res.getString("login");  
       return st;
     }
       return null;
      
   }
   public Utilisateur() throws SQLException{
        connexion();
        this.Login=GenererLogin();
        this.Password=GenererPassword();
        String query="UPDATE authentification SET retenu="+1+" WHERE login='"+this.Login+"'AND password='"+this.Password+"'";
        int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        
    }
   
     public String getLogin(){
       return Login;
   }
   public String getPassword(){
       return Password;
   }
   public void setLogin(String lg){
       this.Login=lg;
   }
   
   public void setPassword(String pswrd){
       this.Password=pswrd;
   }
    
    
}