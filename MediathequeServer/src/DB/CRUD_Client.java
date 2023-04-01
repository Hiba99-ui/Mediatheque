/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Modèle.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import Modèle.Document;
import Modèle.Livre;
import java.util.ArrayList;
/**
 *
 * @author hiba-
 */
public class CRUD_Client {
    
   public Statement stmt;
    
    public CRUD_Client() throws SQLException {
    
    Connection conx = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/mediatheque",
                         "root",
                         "");
   
    stmt = (Statement) conx.createStatement();

}
    
    public int AjouterEtudiant(Etudiant e) throws SQLException{
     String query;       
            query="INSERT INTO etudiant VALUES ('"+e.getLogin()+"','"+e.getPassword()+"','"+e.getNom()+"','"+e.getPrenom()+"','"+e.getCNE()+"')";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated;
    }
        
      public int AjouterProfesseur(Professeur p) throws SQLException{
     String query;       
            query="INSERT INTO professeur VALUES ('"+p.getLogin()+"','"+p.getPassword()+"','"+p.getNom()+"','"+p.getPrenom()+"','"+p.getCIN()+"')";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated;
    }
    
   public Etudiant getEtudiantByCNE(String cne) throws SQLException{

        String query="SELECT * FROM etudiant WHERE cne='"+cne+"'";
        ResultSet rs=stmt.executeQuery(query);
       
        if (rs.next()) {
           String login=rs.getString("login");
             String password=rs.getString("password");
           String nom=rs.getString("nom");
           String prenom=rs.getString("prenom");
           
           
           Etudiant e = new Etudiant(nom, prenom, cne);
           e.setLogin(login);
           e.setPassword(password);
           return e;
       }
        return null;

    }
    
   public Professeur getProfesseurByCIN(String cin) throws SQLException{

        String query="SELECT * FROM professeur WHERE cin='"+cin+"'";
        ResultSet rs=stmt.executeQuery(query);
       
        if (rs.next()) {
           String login=rs.getString("login");
             String password=rs.getString("password");
           String nom=rs.getString("nom");
           String prenom=rs.getString("prenom");
           
           
           Professeur p = new Professeur(nom, prenom, cin);
           return p;
       }
        return null;

    }
   
   public String getProfesseurbylogin(String log) throws SQLException{

        String query="SELECT * FROM professeur WHERE login='"+log+"'";
        ResultSet rs=stmt.executeQuery(query);
       
        if (rs.next()) {
          String cin=rs.getString("cin"); 
          return cin;
       }
        return null;

    }
   
   public String getEtudiantbylogin(String log) throws SQLException{

        String query="SELECT * FROM etudiant WHERE login='"+log+"'";
        ResultSet rs=stmt.executeQuery(query);
       
        if (rs.next()) {
          String cne=rs.getString("cne"); 
          return cne;
       }
        return null;

    }
    
    
    
    /* public Boolean ModifierClient(Client c){
        return false;
    }*/
     
       public int SupprimerEtudiant(String cne) throws SQLException{
         
         String query;       
            query = "DELETE FROM etudiant WHERE cne='"+cne+"'";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated;
        
    }
       
        public int SupprimerProfesseur(String cin) throws SQLException{
         
         String query;       
            query = "DELETE FROM professeur WHERE cin='"+cin+"'";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated;
        
    }
       
}
