/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediathequeserver;

import Mod�le.Dictionnaire;
import Mod�le.Livre;
import Mod�le.Magazine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hiba-
 */
public class ThreadServer implements Runnable{
    Socket soc;
    Boolean repeat=true;
    String cname;
    public ThreadServer(Socket sock){
        this.soc=sock;
    }
    @Override
    public void run() {
       try{
          ArrayList<String> Kindlevoles = new ArrayList<String>(Arrays.asList("5E:FF:56:A2:AF:15","50:AD:B6:A5:AF:13","5E:F8:BC:22:A0:12"));
        float lacompus=40.33f;
        float locompus=22.12f;
            
       while(true){
       
        InputStream flux = soc.getInputStream ();
           BufferedReader entree = new BufferedReader (new InputStreamReader (flux)) ; 
           String mac=entree.readLine();
           //System.out.println(mac);
           OutputStream flux1 = soc.getOutputStream() ; 
            OutputStreamWriter sortie1 = new OutputStreamWriter (flux1);
            //sortie1.write("Latitude:\n");
            //sortie1.flush();
            float la=Float.parseFloat(entree.readLine());
            //System.out.println(la);
            //sortie1.write("Longitude:\n");
            //sortie1.flush();
            float lo=Float.parseFloat(entree.readLine());
            //System.out.println(lo);
            int o=Kindlevoles.indexOf(mac);
            
            if(o!=(-1)||(lo>locompus)||(la>lacompus)){
            sortie1.write("Erreur...\n");
            sortie1.flush();
            }
            else 
            {
              int cpt=1;
              sortie1.write("Login:...\n");
              sortie1.flush();
              while(cpt<4){
              
              String lgin;
              lgin = entree.readLine();
              sortie1.write("Password:...\n");
              sortie1.flush();
              String Passwd=entree.readLine(); 
              
              Statement stmt=null;
  
        //Class.forName("com.mysql.jdbc.Driver");
       Connection conx = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/mediatheque",
                           "root","");
        stmt = conx.createStatement();
              String rqt="SELECT * FROM authentification WHERE login='"+lgin+"' AND password='"+Passwd+"'";
               ResultSet res=stmt.executeQuery(rqt);
               
               if(res.next())
               {   cpt=5;
                   
               sortie1.write("Connexion autorisée...\n");
               sortie1.flush();
               String idclient="";
               if(new DB.CRUD_Client().getProfesseurbylogin(lgin)!=null){
                   idclient=new DB.CRUD_Client().getProfesseurbylogin(lgin);
                   sortie1.write(" Bienvenue, vous etes un professeur, notez que vous n\'avez aucune restriction \n");
                   sortie1.flush();
               }
               if(new DB.CRUD_Client().getEtudiantbylogin(lgin)!=null){
                   idclient=new DB.CRUD_Client().getEtudiantbylogin(lgin);
                   sortie1.write(" Bienvenue, vous etes un etudiant, notez que vous avez que 3 heures afin de rendre le kindle \n");
                   sortie1.flush();
               }
               boolean b=new DB.CRUD_Emprunt().ajouter_emprunt(idclient, mac);
               sortie1.write(cpt);
               sortie1.flush();
               String choix=entree.readLine();
               
               
     switch(choix){
            case "1":
                sortie1.write("Mot clé...\n");
               sortie1.flush();
               String motcle1=entree.readLine();
                sortie1.write("Affichage des documents par titre :\n");
                sortie1.flush();
                LinkedList<Livre> l1;
                l1=new DB.CRUD_Document().getLivreByTitre(motcle1);
                sortie1.write(l1+"\n"); 
                sortie1.flush();
                LinkedList<Magazine> l2;
                l2=new DB.CRUD_Document().getMagazineByTitre(motcle1);
                sortie1.write(l2+"\n"); 
                sortie1.flush();
                LinkedList<Dictionnaire> l3;
                l3=new DB.CRUD_Document().getDictionnaireByTitre(motcle1);
                sortie1.write(l3+"\n"); 
                sortie1.flush();
                break;
            case "2":
                sortie1.write("Mot clé...\n");
               sortie1.flush();
               String motcle2=entree.readLine();
                sortie1.write("Affichage des documents par auteur :\n");
                sortie1.flush();
                LinkedList<Livre> a1=new DB.CRUD_Document().getLivreByAuteur(motcle2);
                sortie1.write(a1+"\n"); 
                sortie1.flush();
                LinkedList<Magazine> a2=new DB.CRUD_Document().getMagazineByAuteur(motcle2);
                sortie1.write(a2+"\n"); 
                sortie1.flush();
                LinkedList<Dictionnaire> a3=new DB.CRUD_Document().getDictionnaireByAuteur(motcle2);
                sortie1.write(a3+"\n"); 
                sortie1.flush();
                break;
            case "3":
                sortie1.write("Mot clé...\n");
               sortie1.flush();
               String motcle3=entree.readLine();
                int annee=Integer.parseInt(motcle3);
                sortie1.write("Affichage des documents par année d\'édition :\n");
                sortie1.flush();
                LinkedList<Livre> e1=new DB.CRUD_Document().getLivreByAnneeEdition(annee);
                sortie1.write(e1+"\n");
                sortie1.flush();
                
                LinkedList<Magazine> e2=new DB.CRUD_Document().getMagazineByAnneeEdition(annee);
                sortie1.write(e2+"\n"); 
                sortie1.flush();
                LinkedList<Dictionnaire> e3=new DB.CRUD_Document().getDictionnaireByAnneeEdition(annee);
               sortie1.write(e3+"\n"); 
                sortie1.flush();
                break;
            case "4":
                sortie1.write("Mot clé...\n");
               sortie1.flush();
               String motcle4=entree.readLine();
                sortie1.write("Affichage des documents par editeur :\n");
                sortie1.flush();
                LinkedList<Livre> ed1=new DB.CRUD_Document().getLivreByEditeur(motcle4);
                sortie1.write(ed1+"\n"); 
                sortie1.flush();
                LinkedList<Magazine> ed2=new DB.CRUD_Document().getMagazineByEditeur(motcle4);
                sortie1.write(ed2+"\n"); 
                sortie1.flush();
                LinkedList<Dictionnaire> ed3=new DB.CRUD_Document().getDictionnaireByEditeur(motcle4);
                sortie1.write(ed3+"\n"); 
                sortie1.flush();
                break;
            case "5":
                sortie1.write("Mot clé...\n");
               sortie1.flush();
               String motcle5=entree.readLine();
                sortie1.write("Affichage des documents par isbn :\n");
                sortie1.flush();
                Livre is1=new DB.CRUD_Document().getLivreByISBN(motcle5);
                sortie1.write(is1+"\n"); 
                sortie1.flush();
                Magazine is2=new DB.CRUD_Document().getMagazineByISBN(motcle5);
                sortie1.write(is2+"\n"); 
                sortie1.flush();
                Dictionnaire is3=new DB.CRUD_Document().getDictionnaireByISBN(motcle5);
                sortie1.write(is3+"\n"); 
                sortie1.flush();
                break;
            default:
                sortie1.write("Le mode de recherche que vous avez choisi est incorrect \n");
                sortie1.flush();
                soc.close();
                break; 
               }
  /*   if(new DB.CRUD_Client().getEtudiantByCNE(idclient)!=null){
         Emprunt e=new DB.CRUD_Emprunt().getEmprunt(idclient);
         String str=e.getDateRetour();
         String[] str0=str.split(":",0);
         int str1=Integer.parseInt(str0[0]);
         Date d=new Date();
         int da=d.getHours();
         if(da==str1){
             sortie1.write("Au revoir temps epuisé..\n");
             sortie1.flush();
         }
     }
*/
     
       
               }else
               {
               sortie1.write("Informations incorrectes...\n");
               sortie1.flush();
               cpt++;
               sortie1.write(cpt);
               sortie1.flush();
               }
              }
              if(cpt==4){
                  sortie1.write("Connexion refusée...");
                  sortie1.flush();
                  soc.close();
              }
            }
         
       }
       
        } catch (IOException ex){
            
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     
}