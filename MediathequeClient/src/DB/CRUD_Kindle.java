package DB;
import Modèle.Kindle;
import  Modèle.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class CRUD_Kindle {

    Statement stmt;
     public void CRUD_Kindle(String user, String password) throws SQLException {
    
    Connection conx = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/mediatheque",
                         user,
                         password);
   
    stmt = (Statement) conx.createStatement();

}
    
  
    
    ////// L'ajout d'un kindle
    
    public boolean Ajouter_kindle(Kindle k) throws SQLException{
            
        String requete="INSERT INTO Kindle VALUES '"+k.getMac()+"','"+k.getModele()+"','"+k.isEmprunte()+"','";
        int res=stmt.executeUpdate(requete);
      
        return (res==1);

    }
    
    ////// La suppression d'1 kindle
    
    public boolean Supprimer_kindle(Kindle k) throws SQLException{
    
        String requete="DELETE FROM kindle WHERE id LIKE"+k.getMac();
        int res= stmt.executeUpdate(requete);
        return res==1 ; 
      }
    
    ///// La modification d'un kindle 
    
    public Kindle modifier_kindle(boolean emp,Kindle k) throws SQLException{
        
        String requete="UPDATE kindle set Emprunte="+emp+"WHERE id LIKE "+k.getMac();
        int res=stmt.executeUpdate(requete);
        if (res==1) return k; 
        else return null;         
    }
    ///// La recuperation d'1 kindle via le modele
    public LinkedList<Kindle> getkindleByModele(String modele) throws SQLException{
     
        String requete="SELECT FROM kindle WHERE modele like"+modele;
        ResultSet res=stmt.executeQuery(requete);
        LinkedList <Kindle> listeKindles=new LinkedList<>();
        while(res.next()){
            int id=res.getInt("id");
            String mac=res.getString("mac");
            String Modele=res.getString("modele");
            Boolean emprunt=res.getBoolean("emprunt");
            
        Kindle k=new Kindle(mac,Modele);
        k.setEmprunte(emprunt);  
        listeKindles.add(k);
        }
    return listeKindles;
    }
   ///// la recuperation d'un kindle via l'adresse mac
    public Kindle getKindleByMac(String Mac) throws SQLException{
        
        String requete="SELECT FROM kindle WHERE mac LIKE"+Mac;
        ResultSet res=stmt.executeQuery(requete);
        if(res.next()){
            int id=res.getInt("id");
            String mac=res.getString("mac");
            String Modele=res.getString("modele");
            Boolean emprunt=res.getBoolean("emprunt");
            Kindle k=new Kindle(mac,Modele);
            k.setEmprunte(emprunt); 
         return k;
        }
        else return null;
    }
    
    
    
}
