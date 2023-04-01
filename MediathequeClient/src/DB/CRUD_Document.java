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


/**
 *
 * @author hiba-
 */
public class CRUD_Document {
    Statement stmt;
    
    public void CRUD_Document(String user, String password) throws SQLException {
    
    Connection conx = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/mediatheque",
                         user,
                         password);
   
    stmt = (Statement) conx.createStatement();

}
    
    
    ///////////////////////////LIVRES////////////////////////////////
    
    public Boolean AjouterDocument(Document d) throws SQLException{
        if (d instanceof Livre){
         String query;       
            query = "insert into livre(isbn, titre, edition, editeur, url,nbpage,auter) values ("+d.getIsbn()+","+d.getTitre()+","+d.getEdition()+","+d.getEditeur()+","+d.getUrl()+","+((Livre)d).getNbPages()+","+d.getAuteur()[0]+")";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
        }
        
        if (d instanceof Magazine){
         String query;       
            query = "insert into magazine(isbn, titre, edition, editeur, url, auteur, periodicite, moisedition, jour) values ("+d.getIsbn()+","+d.getTitre()+","+d.getEdition()+","+d.getEditeur()+","+d.getUrl()+","+d.getAuteur()+","+((Magazine)d).getPeriodicite()+","+((Magazine)d).getMoisEdition()+","+((Magazine)d).getJour()+")";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
        }
        
        if (d instanceof Dictionnaire){
         String query;       
            query = "insert into dictionnaire(isbn, titre, edition, editeur, url, auteur, langue, nbtome) values ("+d.getIsbn()+","+d.getTitre()+","+d.getEdition()+","+d.getEditeur()+","+d.getUrl()+","+d.getAuteur()+","+((Dictionnaire)d).getLangue()+","+((Dictionnaire)d).getNbTome()+")";
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
        }
        
        
        else 
            return true;
     
    }
    
    LinkedList<Livre> getLivreByTitre(String titre) throws SQLException{

        String query="select * from livre where titre = "+titre+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres= new   LinkedList<> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
            String url=rs.getString("url");
            int nbpages=rs.getInt("nbpages");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           Livre l = new Livre(titre, auteurs, edition, editeur, url,nbpages,isbn);
           livres.add(l);
       }

       return livres;
    }
    
    Livre getLivreByISBN(String isbn) throws SQLException{

        String query="select * from livre where isbn = "+isbn+" ";
        ResultSet rs=stmt.executeQuery(query);
       
        if (rs.next()) {
           String titre=rs.getString("titre");
             int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           int nbpages=rs.getInt("nbpages");
           String auteur=rs.getString("auteur");
         
           String auteurs[]={auteur};
           
           Livre l = new Livre(titre, auteurs, edition, editeur, url,nbpages,isbn);
           return l;
       }
        return null;

    }
    
     LinkedList<Livre> getLivreByAnneeEdition(int edition) throws SQLException{

        String query="select * from livre where edition ="+edition+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres;
        livres = new   LinkedList<> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           int nbpages=rs.getInt("nbpages");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           
           Livre l = new Livre(titre, auteurs, edition, editeur, url,nbpages,isbn);
           livres.add(l);
       }

       return livres;
    }
     
     LinkedList<Livre> getLivreByEditeur(String editeur) throws SQLException{

        String query="select * from livre where editeur ="+editeur+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres= new   LinkedList<> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           int edition=rs.getInt("edition");
           String url=rs.getString("url");
           int nbpages=rs.getInt("nbpages");
           String auteur=rs.getString("auteur");
           String auteurs[]={auteur};
           
           Livre l = new Livre(titre, auteurs, edition, editeur, url,nbpages,isbn);
           livres.add(l);
       }

       return livres;
    }
     
     LinkedList<Livre> getLivreByNbPages(int nbpage) throws SQLException{

        String query="select * from livre where nbpage ="+nbpage+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres= new   LinkedList<> ();
        
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
     
     LinkedList<Livre> getLivreByAuteur(String auteur) throws SQLException{

        String query="select * from livre where auteur ="+auteur+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres= new   LinkedList<> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
           int edition=rs.getInt("edition");
           String editeur=rs.getString("editeur");
           String url=rs.getString("url");
           int nbpages=rs.getInt("nbpages");
           
           String auteurs[]={auteur};
           
           Livre l = new Livre(titre, auteurs, edition, editeur, url,nbpages,isbn);
           livres.add(l);
       }

       return livres;
    }
       
     public Boolean SupprimerLivre(String isbn) throws SQLException{
         
         String query;       
            query = "delete from livre where isbn ="+isbn;
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
        
    }
      ////////////////////////////////////////////////////
     
     /////////////////Magazines/////////////////////
     
     LinkedList<Magazine> getMagazineByTitre(String titre) throws SQLException{

        String query="select * from magazine where titre = "+titre+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Magazine> magazines= new   LinkedList<> ();
        
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
    
    Magazine getMagazineByISBN(String isbn) throws SQLException{

        String query="select * from magazine where isbn = "+isbn+" ";
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
    
     LinkedList<Magazine> getMagazineByAnneeEdition(int edition) throws SQLException{

        String query="select * from magazine where edition ="+edition+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Magazine> magazines= new   LinkedList<> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String titre=rs.getString("titre");
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
     
     LinkedList<Magazine> getMagazineByEditeur(String editeur) throws SQLException{

        String query="select * from magazine where editeur ="+editeur+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Magazine> magazines= new   LinkedList<> ();
        
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
     
     LinkedList<Magazine> getMagazineByAuteur(String auteur) throws SQLException{

        String query="select * from magazine where auteur ="+auteur+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Magazine> magazines= new   LinkedList<> ();
        
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
     
     LinkedList<Magazine> getMagazineByPeriodicite(float periodicite) throws SQLException{

        String query="select * from magazine where periodicite ="+periodicite+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Magazine> magazines= new   LinkedList<> ();
        
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
     
     LinkedList<Magazine> getMagazineByMoisEdition(int moisedition) throws SQLException{

        String query="select * from magazine where moisedition ="+moisedition+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Magazine> magazines= new   LinkedList<> ();
        
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
     
     LinkedList<Magazine> getMagazineByJour(int jour) throws SQLException{

        String query="select * from magazine where jour ="+jour+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Magazine> magazines= new   LinkedList<> ();
        
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
            query = "delete from magazine where isbn ="+isbn;
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
        
    }
     
     ////////////////////////////////////////////////////
     
     //////////////////DICTIONNAIRE////////////////////
     
     LinkedList<Dictionnaire> getDictionnaireByTitre(String titre) throws SQLException{

        String query="select * from dictionnaire where titre = "+titre+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Dictionnaire> dictionnaires= new   LinkedList<> ();
        
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
    
    Dictionnaire getDictionnaireByISBN(String isbn) throws SQLException{

        String query="select * from dictionnaire where isbn = "+isbn+" ";
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
    
     LinkedList<Dictionnaire> getDictionnaireByAnneeEdition(int edition) throws SQLException{

        String query="select * from dictionnaire where edition ="+edition+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Dictionnaire> dictionnaires= new   LinkedList<> ();
        
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
     
     LinkedList<Dictionnaire> getDictionnaireByEditeur(String editeur) throws SQLException{

        String query="select * from dictionnaire where editeur ="+editeur+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Dictionnaire> dictionnaires= new   LinkedList<> ();
        
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
     
     LinkedList<Dictionnaire> getDictionnaireByAuteur(String auteur) throws SQLException{

        String query="select * from magazine where auteur ="+auteur+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Dictionnaire> dictionnaires= new   LinkedList<> ();
        
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
     
     LinkedList<Dictionnaire> getDictionnaireByLangue(String langue) throws SQLException{

        String query="select * from magazine where langue ="+langue+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Dictionnaire> dictionnaires= new   LinkedList<> ();
        
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
     
    LinkedList<Dictionnaire> getDictionnaireByNbTome(int nbtome) throws SQLException{

        String query="select * from magazine where nbtome ="+nbtome+" ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Dictionnaire> dictionnaires= new   LinkedList<> ();
        
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
            query = "delete from dictionnaire where isbn ="+isbn;
            int nbUpdated;
            nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
        
    }
       
}

