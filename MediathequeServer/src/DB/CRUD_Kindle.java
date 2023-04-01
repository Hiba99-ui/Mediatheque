package DB;
import Modèle.Kindle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class CRUD_Kindle {

    public Statement stmt;
     public  CRUD_Kindle() throws SQLException {
    
    Connection conx = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/mediatheque",
                         "root",
                         "");
   
    stmt = (Statement) conx.createStatement();

}
    
  
    
    ////// L'ajout d'un kindle
    
    public int Ajouter_kindle(Kindle k) throws SQLException{
            
        String requete;
                requete="INSERT INTO Kindle VALUES ('"+k.getMac()+"','"+k.getModele()+"','"+k.isEmprunte()+"')";
        int res;
                res=stmt.executeUpdate(requete);
      
        return res;

    }
    
    ////// La suppression d'1 kindle
    
    public boolean Supprimer_kindle(String mac) throws SQLException{
    
        String requete="DELETE FROM kindle WHERE mac='"+mac+"'";
        int res= stmt.executeUpdate(requete);
        return res==1 ; 
      }
    //// recuperation des kindles non empruntÃ©s
     public LinkedList<Kindle> getkindleByEmprun() throws SQLException{
     
        String requete="SELECT * FROM kindle WHERE emprunte="+0+"";
        ResultSet res=stmt.executeQuery(requete);
        LinkedList <Kindle> listeKindles=new LinkedList<Kindle>();
        while(res.next()){
            String mac=res.getString("mac");
            String modele=res.getString("modele");
            int emprunt=res.getInt("emprunte");
            
        Kindle k=new Kindle(mac,modele);
        k.setEmprunte(emprunt);  
        listeKindles.add(k);
        }
    return listeKindles;
    }
   
    ///// La recuperation des kindles via le modele
    public LinkedList<Kindle> getkindleByModele(String modele) throws SQLException{
     
        String requete="SELECT * FROM kindle WHERE modele='"+modele+"'";
        ResultSet res=stmt.executeQuery(requete);
        LinkedList <Kindle> listeKindles=new LinkedList<Kindle>();
        while(res.next()){
            String mac=res.getString("mac");
            int emprunt=res.getInt("emprunte");
            
        Kindle k=new Kindle(mac,modele);
        k.setEmprunte(emprunt);  
        listeKindles.add(k);
        }
    return listeKindles;
    }
   ///// la recuperation d'un kindle via l'adresse mac
    public Kindle getKindleByMac(String Mac) throws SQLException{
        
        String requete="SELECT * FROM kindle WHERE mac='"+Mac+"'";
        ResultSet res=stmt.executeQuery(requete);
        if(res.next()){
            String Modele=res.getString("modele");
            int emprunt=res.getInt("emprunte");
            Kindle k=new Kindle(Mac,Modele);
            k.setEmprunte(emprunt); 
         return k;
        }
        else return null;
    }
    
    
    
}
