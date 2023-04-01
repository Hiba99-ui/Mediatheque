
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import Modèle.Emprunt;

public class CRUD_Emprunt {
    public Statement stmt;
    public CRUD_Emprunt() throws SQLException{
         Connection conx=DriverManager.getConnection( "jdbc:mysql://localhost:3306/mediatheque","root","");
          stmt = (Statement) conx.createStatement(); 
    } 
    
   ////////////:L'ajout d'1 emprunt
    public Boolean ajouter_emprunt(String idclient,String idkindle) throws SQLException{
        Date d = new Date();
        String st=d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+"";
        
        if(new DB.CRUD_Client().getEtudiantByCNE(idclient)!=null){
            String stt=(d.getHours()+3)+":"+d.getMinutes()+":"+d.getSeconds()+"";
            String requete="INSERT INTO emprunt VALUES ('"+idclient+"','"+idkindle+"','"+st+"','"+stt+"')";
           int res=stmt.executeUpdate(requete);
           if(res!=0) return true; 
           else return false; 
        }
        
        if(new DB.CRUD_Client().getProfesseurByCIN(idclient)!=null){
            
            String requete="INSERT INTO emprunt VALUES ('"+idclient+"','"+idkindle+"','"+st+"',\"00:00:00\")";
           int res=stmt.executeUpdate(requete);
           if(res!=0) return true; 
           else return false; 
        }
    return false;
    }
    
    ////// La modification d'1 emprunt 
    //////La suppression d'1 emprunt
      public Boolean supprimer_emprunt(String idclient,String idkindle) throws SQLException{
        // tester l'existance du client et de la disponibilitÃ© du kindle 
        
        String requete="DELETE FROM emprunt WHERE idclient='"+idclient+"' AND idkindle='"+idkindle+"'";
        int res=stmt.executeUpdate(requete);
        if(res!=0) return true; 
        else return false; 
    }
    
    ////// La liste des emprunts pour un client 
          public Emprunt getEmprunt(String idclient) throws SQLException{
     
        String requete="SELECT * FROM emprunt WHERE idclient='"+idclient+"'";
        ResultSet res=stmt.executeQuery(requete);
       
        if(res.next()){
            String idkindle=res.getString("idkindle");
            String dd=res.getString("date_debut");
            String df=res.getString("date_fin");
          
            Emprunt e=new Emprunt(idclient,idkindle,dd,df); 
           return e;
        }
    return null;
    }
          
           public LinkedList<Emprunt> getListedesEmpruntsK(String idkindle) throws SQLException{
     
        String requete="SELECT * FROM emprunt WHERE idkindle='"+idkindle+"'";
        ResultSet res=stmt.executeQuery(requete);
        LinkedList <Emprunt> listeEmprunts=new LinkedList<Emprunt>();
        while(res.next()){
            String idclient=res.getString("idclient");
            String dd=res.getString("date_debut");
            String df=res.getString("date_fin");
          
            Emprunt e=new Emprunt(idclient,idkindle,dd,df); 
            listeEmprunts.add(e);
        }
    return listeEmprunts;
    }
    
    
    
    
    
}

