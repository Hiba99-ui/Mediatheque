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
import java.util.Arrays;

/**
 *
 * @author hiba-
 */
public class CRUD_Document {
   public Statement stmt;
    
    public CRUD_Document() throws SQLException {
    
    Connection conx = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/mediatheque",
                         "root",
                         "");
   
    stmt = (Statement) conx.createStatement();

}
    
    
    ///////////////////////////LIVRES////////////////////////////////
    
     public Boolean AjouterLivre(Livre l) throws SQLException{
     
        String query = "INSERT INTO livre VALUES ('"+l.getIsbn()+"','"+l.getTitre()+"','"+l.getEdition()+"','"+l.getEditeur()+"','"+l.getUrl()+"','"+l.getNbPages()+"','"+Arrays.toString(l.getAuteur())+"')";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
    }
     
     
    public Boolean AjouterMagazine(Magazine m) throws SQLException{
         String query;       
            query = "INSERT INTO magazine VALUES ('"+m.getIsbn()+"','"+m.getTitre()+"','"+m.getEdition()+"','"+m.getEditeur()+"','"+m.getUrl()+"','"+Arrays.toString(m.getAuteur())+"','"+m.getPeriodicite()+"','"+m.getMoisEdition()+"','"+m.getJour()+"')";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
       
     return nbUpdated!=0;
     
    }
    
    
    public Boolean AjouterDictionnaire(Dictionnaire d) throws SQLException{
          String query;       
            query = "INSERT INTO dictionnaire(isbn, titre, edition, editeur, url, auteur, langue, nbtome) VALUES ('"+d.getIsbn()+"','"+d.getTitre()+"','"+d.getEdition()+"','"+d.getEditeur()+"','"+d.getUrl()+"','"+Arrays.toString(d.getAuteur())+"','"+d.getLangue()+"','"+d.getNbTome()+"')";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
        }
   
    public LinkedList<Livre> getLivreByTitre(String titre) throws SQLException{

        String query = "SELECT * FROM livre WHERE titre='"+titre+"'";
        
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres= new LinkedList<> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
            String url=rs.getString("url");
            int nbpage=rs.getInt("nbpage");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           Livre l = new Livre(titre, auteurs, edition, editeur, url,nbpage,isbn);
           livres.add(l);
       }

       return livres;
    }
    
    public Livre getLivreByISBN(String isbn) throws SQLException{

        String query="SELECT * FROM livre WHERE isbn='"+isbn+"'";
        ResultSet rs=stmt.executeQuery(query);
       
        if (rs.next()) {
           String titre=rs.getString("titre");
             int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           int nbpages=rs.getInt("nbpage");
           String auteur=rs.getString("auteur");
         
           String auteurs[]={auteur};
           
           Livre l = new Livre(titre, auteurs, edition, editeur, url,nbpages,isbn);
           return l;
       }
        return null;

    }
    
     public LinkedList<Livre> getLivreByAnneeEdition(int edition) throws SQLException{

        String query="SELECT * FROM livre WHERE edition='"+edition+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres= new LinkedList<Livre> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           int nbpages=rs.getInt("nbpage");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           
           Livre l = new Livre(titre, auteurs, edition, editeur, url,nbpages,isbn);
           livres.add(l);
       }

       return livres;
    }
     
    public LinkedList<Livre> getLivreByEditeur(String editeur) throws SQLException{

        String query="SELECT * FROM livre WHERE editeur='"+editeur+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres= new LinkedList<Livre> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           int edition=rs.getInt("edition");
           String url=rs.getString("url");
           int nbpages=rs.getInt("nbpage");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           
           Livre l = new Livre(titre, auteurs, edition, editeur, url,nbpages,isbn);
           livres.add(l);
       }

       return livres;
    }
     
     public LinkedList<Livre> getLivreByNbPages(int nbpage) throws SQLException{

        String query="SELECT * FROM livre WHERE nbpage='"+nbpage+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres= new LinkedList<Livre> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           
           Livre l = new Livre(titre, auteurs, edition, editeur, url,nbpage,isbn);
           livres.add(l);
       }

       return livres;
    }
     
     public LinkedList<Livre> getLivreByAuteur(String auteur) throws SQLException{

        String query="SELECT * FROM livre WHERE auteur='"+auteur+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres= new LinkedList<Livre> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           int nbpages=rs.getInt("nbpage");
           
           String auteurs[]={auteur};
           
           Livre l = new Livre(titre, auteurs, edition, editeur, url,nbpages,isbn);
           livres.add(l);
       }

       return livres;
    }
       
     public Boolean SupprimerLivre(String isbn) throws SQLException{
         
         String query;       
            query = "DELETE FROM livre WHERE isbn='"+isbn+"'";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
        
    }
      ////////////////////////////////////////////////////
     
     /////////////////Magazines/////////////////////
     
    public LinkedList<Magazine> getMagazineByTitre(String titre) throws SQLException{

        String query="SELECT * FROM magazine WHERE titre='"+titre+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Magazine> magazines= new LinkedList<Magazine> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
            String url=rs.getString("url");
            String auteur=rs.getString("auteur");
            String auteurs[]={auteur};
            float periodicite=rs.getFloat("periodicite");
           int moisedition=rs.getInt("moisedition");
           int jour=rs.getInt("jour");
           Magazine m = new Magazine(titre, auteurs, edition, editeur, url, isbn, periodicite, moisedition, jour);
           magazines.add(m);
       }

       return magazines;
    }
    
    public Magazine getMagazineByISBN(String isbn) throws SQLException{

        String query="SELECT * FROM magazine WHERE isbn='"+isbn+"'";
        ResultSet rs=stmt.executeQuery(query);
       
        if (rs.next()) {
           String titre=rs.getString("titre");
             int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           String auteur=rs.getString("auteur");
         
           String auteurs[]={auteur};
           float periodicite=rs.getFloat("periodicite");
           int moisedition=rs.getInt("moisedition");
           int jour=rs.getInt("jour");
           
           Magazine m = new Magazine(titre, auteurs, edition, editeur, url, isbn, periodicite, moisedition, jour);
           return m;
       }
        return null;

    }
    
     public LinkedList<Magazine> getMagazineByAnneeEdition(int edition) throws SQLException{

        String query="SELECT * FROM magazine WHERE edition='"+edition+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Magazine> magazines= new LinkedList<Magazine> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           float periodicite=rs.getFloat("periodicite");
           int moisedition=rs.getInt("moisedition");
           int jr=rs.getInt("jour");
          Magazine m = new Magazine(titre, auteurs, edition, editeur, url, isbn, periodicite, moisedition, jr);
           magazines.add(m);
       }

       return magazines;
    }
     
    public LinkedList<Magazine> getMagazineByEditeur(String editeur) throws SQLException{

        String query="SELECT * FROM magazine WHERE editeur='"+editeur+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Magazine> magazines= new LinkedList<Magazine> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           int edition=rs.getInt("edition");
           String url=rs.getString("url");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           float periodicite=rs.getFloat("periodicite");
           int moisedition=rs.getInt("moisedition");
           int jour=rs.getInt("jour");
           
           Magazine l = new Magazine(titre, auteurs, edition, editeur, url, isbn, periodicite, moisedition, jour);
           magazines.add(l);
       }

       return magazines;
    }
     
    public LinkedList<Magazine> getMagazineByAuteur(String auteur) throws SQLException{

        String query="SELECT * FROM magazine WHERE auteur='"+auteur+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Magazine> magazines= new LinkedList<Magazine> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           
           String auteurs[]={auteur};
           float periodicite=rs.getFloat("periodicite");
           int moisedition=rs.getInt("moisedition");
           int jour=rs.getInt("jour");
           
           Magazine l = new Magazine(titre, auteurs, edition, editeur, url, isbn, periodicite, moisedition, jour);
           magazines.add(l);
       }

       return magazines;
    }
     
    public LinkedList<Magazine> getMagazineByPeriodicite(float periodicite) throws SQLException{

        String query="SELECT * FROM magazine WHERE periodicite='"+periodicite+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Magazine> magazines= new LinkedList<Magazine> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           
           int moisedition=rs.getInt("moisedition");
           int jour=rs.getInt("jour");
           
           Magazine l = new Magazine(titre, auteurs, edition, editeur, url, isbn, periodicite, moisedition, jour);
           magazines.add(l);
       }

       return magazines;
    }
     
    public LinkedList<Magazine> getMagazineByMoisEdition(int moisedition) throws SQLException{

        String query="SELECT * FROM magazine WHERE moisedition='"+moisedition+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Magazine> magazines= new LinkedList<Magazine> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           float periodicite=rs.getFloat("periodicite");
          
           int jour=rs.getInt("jour");
           
           Magazine l = new Magazine(titre, auteurs, edition, editeur, url, isbn, periodicite, moisedition, jour);
           magazines.add(l);
       }

       return magazines;
    }
     
    public LinkedList<Magazine> getMagazineByJour(int jour) throws SQLException{

        String query="SELECT * FROM magazine WHERE jour='"+jour+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Magazine> magazines= new LinkedList<Magazine> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           float periodicite=rs.getFloat("periodicite");
           int moisedition=rs.getInt("moisedition");
           
           
           Magazine l = new Magazine(titre, auteurs, edition, editeur, url, isbn, periodicite, moisedition, jour);
           magazines.add(l);
       }

       return magazines;
    }
       
     public Boolean SupprimerMagazine(String isbn) throws SQLException{
         
         String query;       
            query = "DELETE FROM magazine WHERE isbn='"+isbn+"'";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
        
    }
     
     ////////////////////////////////////////////////////
     
     //////////////////DICTIONNAIRE////////////////////
     
    public LinkedList<Dictionnaire> getDictionnaireByTitre(String titre) throws SQLException{

        String query="SELECT * FROM dictionnaire WHERE titre='"+titre+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Dictionnaire> dictionnaires= new LinkedList<Dictionnaire> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
            String url=rs.getString("url");
            String auteur=rs.getString("auteur");
            String auteurs[]={auteur};
           String langue=rs.getString("langue");
           int nbtome=rs.getInt("nbtome");
           
           Dictionnaire d = new Dictionnaire(titre, auteurs, edition, editeur, url, isbn, langue, nbtome);
           dictionnaires.add(d);
       }

       return dictionnaires;
    }
    
   public Dictionnaire getDictionnaireByISBN(String isbn) throws SQLException{

        String query="SELECT * FROM dictionnaire WHERE isbn='"+isbn+"'";
        ResultSet rs=stmt.executeQuery(query);
       
        if (rs.next()) {
           String titre=rs.getString("titre");
             int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           String auteur=rs.getString("auteur");
         
           String auteurs[]={auteur};
           String langue=rs.getString("langue");
           int nbtome=rs.getInt("nbtome");
           
          Dictionnaire d = new Dictionnaire(titre, auteurs, edition, editeur, url, isbn, langue, nbtome);
           return d;
       }
        return null;

    }
    
    public LinkedList<Dictionnaire> getDictionnaireByAnneeEdition(int edition) throws SQLException{

        String query="SELECT * FROM dictionnaire WHERE edition='"+edition+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Dictionnaire> dictionnaires= new LinkedList<Dictionnaire> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           String langue=rs.getString("langue");
           int nbtome=rs.getInt("nbtome");
          Dictionnaire d = new Dictionnaire(titre, auteurs, edition, editeur, url, isbn, langue,nbtome);
           dictionnaires.add(d);
       }

       return dictionnaires;
    }
     
    public LinkedList<Dictionnaire> getDictionnaireByEditeur(String editeur) throws SQLException{

        String query="SELECT * FROM dictionnaire WHERE editeur='"+editeur+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Dictionnaire> dictionnaires= new LinkedList<Dictionnaire> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           int edition=rs.getInt("edition");
           String url=rs.getString("url");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           String langue=rs.getString("langue");
           int nbtome=rs.getInt("nbtome");
           
           Dictionnaire d = new Dictionnaire(titre, auteurs, edition, editeur, url, isbn, langue, nbtome);
           dictionnaires.add(d);
       }

       return dictionnaires;
    }
     
    public LinkedList<Dictionnaire> getDictionnaireByAuteur(String auteur) throws SQLException{

        String query="SELECT * FROM magazine WHERE auteur='"+auteur+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Dictionnaire> dictionnaires= new LinkedList<Dictionnaire> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           
           String auteurs[]={auteur};
           String langue=rs.getString("langue");
           int nbtome=rs.getInt("nbtome");
           
           Dictionnaire l = new Dictionnaire(titre, auteurs, edition, editeur, url, isbn, langue, nbtome);
           dictionnaires.add(l);
       }

       return dictionnaires;
    }
     
    public LinkedList<Dictionnaire> getDictionnaireByLangue(String langue) throws SQLException{

        String query="SELECT * FROM magazine WHERE langue ='"+langue+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Dictionnaire> dictionnaires= new LinkedList<Dictionnaire> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           
           
           int nbtome=rs.getInt("nbtome");
           
           Dictionnaire l = new Dictionnaire(titre, auteurs, edition, editeur, url, isbn, langue, nbtome);
           dictionnaires.add(l);
       }

       return dictionnaires;
    }
     
    public LinkedList<Dictionnaire> getDictionnaireByNbTome(int nbtome) throws SQLException{

        String query="SELECT * FROM magazine WHERE nbtome='"+nbtome+"'";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Dictionnaire> dictionnaires= new LinkedList<Dictionnaire> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           String langue=rs.getString("langue");
           
           Dictionnaire l = new Dictionnaire(titre, auteurs, edition, editeur, url, isbn, langue, nbtome);
           dictionnaires.add(l);
       }

       return dictionnaires;
    }
       
     public Boolean SupprimerDictionnaire(String isbn) throws SQLException{
         
         String query;       
            query = "DELETE FROM dictionnaire WHERE isbn='"+isbn+"'";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
        
    }
       
}

