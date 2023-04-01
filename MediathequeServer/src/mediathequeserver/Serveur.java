/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediathequeserver;

import Mod�le.Dictionnaire;
import Mod�le.Etudiant;
import Mod�le.Kindle;
import Mod�le.Livre;
import Mod�le.Magazine;
import Mod�le.Professeur;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author hiba-
 */
public class Serveur {
     public static void main(String[] args) throws IOException, SQLException, SocketException{
         try{
          
            int port=1200;
       ServerSocket sersoc=new ServerSocket(port);
       System.out.println("Le serveur est actif sur le port " + port);
       
       while(true){
        Socket soc=sersoc.accept();
        InputStream flux = soc.getInputStream ();
        BufferedReader entree = new BufferedReader (new InputStreamReader (flux)) ; 
        
        OutputStream flux1 = soc.getOutputStream() ; 
        OutputStreamWriter sortie1 = new OutputStreamWriter (flux1);
        sortie1.write("Attention ! Vous avez qu\'une seule tentative..\n");
        sortie1.flush();
        sortie1.write("Login..\n");
        sortie1.flush();
        String log=entree.readLine();
        sortie1.write("Password..\n");
        sortie1.flush();
        String passw=entree.readLine();
        
        Statement stmt=null;
  
        //Class.forName("com.mysql.jdbc.Driver");
       Connection conx = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/mediatheque",
                           "root","");
        stmt = conx.createStatement();
        
        String sql="SELECT * FROM admins WHERE login='"+log+"' AND password='"+passw+"'";
         ResultSet res=stmt.executeQuery(sql);
         if(res.next()){
             sortie1.write("Connexion autorisée..\n");
             sortie1.flush();
             //String choix=entree.readLine();
             String choix2=entree.readLine();
             
         switch(choix2){
             case "1.1":
                 sortie1.write("Entrez les cordonnées en respectant la forme suivante (nom,prenom,cne)\n");
                 sortie1.flush();
                 String cor=entree.readLine();
                 String[] reslt=cor.split("[,]", 0);
                 Etudiant e=new Etudiant(reslt[0],reslt[1],reslt[2]);
                 int b=new DB.CRUD_Client().AjouterEtudiant(e);
                 break;

             case "1.2":
                 sortie1.write("Entrez le CNE de l\'étudiant \n");
                 sortie1.flush();
                 String cor1=entree.readLine();
                 int b1=new DB.CRUD_Client().SupprimerEtudiant(cor1);
                 break;
             case "1.3":
                 sortie1.write("Entrez les cordonnées en respectant la forme suivante (nom,prenom,cin)\n");
                 sortie1.flush();
                 String cor2=entree.readLine();
                 String[] reslt1=cor2.split("[,]", 0);
                 Professeur p=new Professeur(reslt1[0],reslt1[1],reslt1[2]);
                 int b2=new DB.CRUD_Client().AjouterProfesseur(p);
                 break;
             case "1.4":
                 sortie1.write("Entrez le CIN du professeur \n");
                 sortie1.flush();
                 String cor3=entree.readLine();
                 int b3=new DB.CRUD_Client().SupprimerProfesseur(cor3);
                 break;
             case "2.1":
                 sortie1.write("Entrez les cordonnées en respectant la forme suivante (mac,modele)\n");
                 sortie1.flush();
                 String cor4=entree.readLine();
                 String[] reslt2=cor4.split("[,]", 0);
                 Kindle k=new Kindle(reslt2[0],reslt2[1]);
                 int b4=new DB.CRUD_Kindle().Ajouter_kindle(k);
                 break;
             case "2.2":
                 sortie1.write("Entrez Mac du Kindle \n");
                 sortie1.flush();
                 String cor5=entree.readLine();
                 boolean b5=new DB.CRUD_Kindle().Supprimer_kindle(cor5);
                 break;
             case "3.1":
                 sortie1.write("Entrez les cordonnées en respectant la forme suivante (titre,auteur1-auteur2,année,editeur,url,nbrpages,isbn)\n");
                 sortie1.flush();
                 String cor6=entree.readLine();
                 String[] reslt3=cor6.split("[,]", 0);
                 String[] auteur=reslt3[1].split("-",0);
                 int n1=Integer.parseInt(reslt3[2]);
                  int n2=Integer.parseInt(reslt3[5]);
                 Livre l=new Livre(reslt3[0],auteur,n1,reslt3[3],reslt3[4],n2,reslt3[6]);
                 boolean b6=new DB.CRUD_Document().AjouterLivre(l);
                 break;
             case "3.2":
                 sortie1.write("Entrez ISBN du livre \n");
                 sortie1.flush();
                 String cor7=entree.readLine();
                 boolean b7=new DB.CRUD_Document().SupprimerLivre(cor7);
                 break;
             case "3.3":
                 sortie1.write("Entrez les cordonnées en respectant la forme suivante (titre,auteur1-auteur2,année,editeur,url,isbn,périodicité,mois d\'édition,jour)\n");
                 sortie1.flush();
                 String cor8=entree.readLine();
                 String[] reslt4=cor8.split("[,]", 0);
                 String[] auteur1=reslt4[1].split("-",0);
                 int n3=Integer.parseInt(reslt4[2]);
                 float n4=Float.parseFloat(reslt4[6]);
                 int n5=Integer.parseInt(reslt4[7]);
                 int n6=Integer.parseInt(reslt4[8]);
                 Magazine m=new Magazine(reslt4[0],auteur1,n3,reslt4[3],reslt4[4],reslt4[5],n4,n5,n6);
                 boolean b8=new DB.CRUD_Document().AjouterMagazine(m);
                 break;
             case "3.4":
                 sortie1.write("Entrez ISBN du magazine \n");
                 sortie1.flush();
                 String cor9=entree.readLine();
                 boolean b9=new DB.CRUD_Document().SupprimerMagazine(cor9);
                 break;
             case "3.5":
                 sortie1.write("Entrez les cordonnées en respectant la forme suivante (titre,auteur1-auteur2,année,editeur,url,isbn,langue,tome\n");
                 sortie1.flush();
                 String cor10=entree.readLine();
                 String[] reslt5=cor10.split("[,]", 0);
                 String[] auteur2=reslt5[1].split("-",0);
                 int n7=Integer.parseInt(reslt5[2]);
                
                 int n8=Integer.parseInt(reslt5[7]);
                 
                 Dictionnaire d=new Dictionnaire(reslt5[0],auteur2,n7,reslt5[3],reslt5[4],reslt5[5],reslt5[6],n8);
                 boolean b11=new DB.CRUD_Document().AjouterDictionnaire(d);
                 break;
             case "3.6":
                 sortie1.write("Entrez ISBN du dictionnaire \n");
                 sortie1.flush();
                 String cor11=entree.readLine();
                 boolean b12=new DB.CRUD_Document().SupprimerDictionnaire(cor11);
                 break;
             default :
                 sortie1.write("L\'option que vous avez choisi est incorrect \n");
                 sortie1.flush();
                 soc.close();
         }
         }
         else{
             sortie1.write("Connexion refusée..\n");
             sortie1.flush();
             //soc.close();
         }
         soc.close();
         
         
         
         
         
       }
       }catch(IOException ex){
               ex.printStackTrace();
               }
     
     }
}
