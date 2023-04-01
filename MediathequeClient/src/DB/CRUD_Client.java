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

/**
 *
 * @author hiba-
 */
public class CRUD_Client {
    
    Statement stmt;
    
    public void CRUD_Document(String user, String password) throws SQLException {
    
    Connection conx = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/mediatheque",
                         user,
                         password);
   
    stmt = (Statement) conx.createStatement();

}
    
    public Boolean AjouterClient(Client c) throws SQLException{
        if (c instanceof Etudiant){
         String query;       
            query = "insert into etudiant(login, password, nom, prenom,cne) values ("+((Etudiant)c).getLogin()+","+((Etudiant)c).getPassword()+","+c.getNom()+","+c.getPrenom()+","+((Etudiant)c).getCNE()+")";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
        }
        
        if (c instanceof Professeur){
         String query;       
            query = "insert into professeur(login, password, nom, prenom,cin) values ("+((Professeur)c).getLogin()+","+((Professeur)c).getPassword()+","+c.getNom()+","+c.getPrenom()+","+((Professeur)c).getCIN()+")";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
        }
        
        else 
            return true;
     
    }
    
    public LinkedList<Client> getClients(){
        return null;
    }
    
    Etudiant getEtudiantByCNE(String cne) throws SQLException{

        String query="select * from etudiant where cne = "+cne+" ";
        ResultSet rs=stmt.executeQuery(query);
       
        if (rs.next()) {
           String login=rs.getString("login");
             String password=rs.getString("password");
           String nom=rs.getString("nom");
           String prenom=rs.getString("prenom");
           
           
           Etudiant e = new Etudiant(nom, prenom, cne);
           return e;
       }
        return null;

    }
    
     Professeur getProfesseurByCIN(String cin) throws SQLException{

        String query="select * from professeur where cin = "+cin+" ";
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
    
    
    
    /* public Boolean ModifierClient(Client c){
        return false;
    }*/
     
       public Boolean SupprimerEtudiant(String cne) throws SQLException{
         
         String query;       
            query = "delete from etudiant where cne ="+cne+" ";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
        
    }
       
        public Boolean SupprimerProfesseur(String cin) throws SQLException{
         
         String query;       
            query = "delete from etudiant where cin ="+cin+" ";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
        
    }
       
}
