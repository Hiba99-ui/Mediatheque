/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

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
     private static int nl=0;
 static Statement stmt; 
   public void connexion(String user, String password) throws SQLException {
    
    Connection conx = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/mediatheque",
                         user,
                         password);
   
          stmt = conx.createStatement();

}
   public static String GenererPassword() throws SQLException{
     String  sql="SELECT * FROM authentification WHERE LIMIT(nl,nl)";
     ResultSet res=stmt.executeQuery(sql);
     
       return res.getString("password");
   }
	
   public static String GenererLogin() throws SQLException{
       String  sql="SELECT * FROM authentification WHERE LIMIT(nl,nl)";
     ResultSet res=stmt.executeQuery(sql);
     
       return res.getString("login");
   }
   public Utilisateur() throws SQLException{
        this.Login=GenererLogin();
        this.Password=GenererPassword();
        nl++;
    }
   
   public String getLogin(){
       return Login;
   }

    /**
     *
     * @return
     */
    public String getPassword(){
       return Password;
   }
     
    
    
}