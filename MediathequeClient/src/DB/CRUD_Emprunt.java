
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import Mod�le.Emprunt;

public class CRUD_Emprunt {
    Statement stmt;
    public CRUD_Emprunt(String login, String password) throws SQLException{
         Connection cnx=DriverManager.getConnection("jbdc:mysql://localhost:80:mediatheque",login,password);
         Statement stmt=cnx.createStatement();  
    } 
    
   ////////////:L'ajout d'1 emprunt
    public Boolean ajouter_emprunt(Emprunt e) throws SQLException{
        // tester l'existance du client et de la disponibilité du kindle 
        
        String requete="INSERT INTO emprunt VALUES '"+e.getIdClient()+"','"+e.getIdKindle()+"','"+e.getDateEmprunt()+"','"+e.getDateRetour();
        int res=stmt.executeUpdate(requete);
        if(res!=0) return true; 
        else return false; 
    }
    
    ////// La modification d'1 emprunt 
    //////La suppression d'1 emprunt
      public Boolean supprimer_emprunt(Emprunt e) throws SQLException{
        // tester l'existance du client et de la disponibilité du kindle 
        
        String requete="DELETE FROME emprunt where idclient like "+e.getIdClient()+" and idkindle like "+e.getIdKindle();
        int res=stmt.executeUpdate(requete);
        if(res!=0) return true; 
        else return false; 
    }
    
    ////// La liste des emprunts pour un client 
          public LinkedList<Emprunt> getListedesEmprunts(int idclient) throws SQLException{
     
        String requete="SELECT FROM emrunt WHERE idclient like"+idclient;
        ResultSet res=stmt.executeQuery(requete);
        LinkedList <Emprunt> listeEmprunts=new LinkedList<>();
        while(res.next()){
            int idkindle=res.getInt("idkindle");
            Date dd=res.getDate("date_debut");
            Date df=res.getDate("date_fin");
          
            Emprunt e=new Emprunt(idclient,idkindle,dd,4,5); 
            listeEmprunts.add(e);
        }
    return listeEmprunts;
    }
    
    
    
    
    
}

