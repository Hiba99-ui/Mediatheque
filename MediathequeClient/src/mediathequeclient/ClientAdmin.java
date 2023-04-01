/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mediathequeclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author hiba-
 */
public class ClientAdmin {
     public static void main(String[] args) throws IOException, SQLException, SocketException{
         try{
           String hote = "127.0.0.1";
        int port =1200;
        Socket soc = new Socket (hote, port);
         
       OutputStream flux = soc.getOutputStream() ; 
        PrintWriter sortie = new PrintWriter (flux) ;
        
        InputStream flux1 = soc.getInputStream ();
        BufferedReader entree = new BufferedReader (new InputStreamReader (flux1)) ;
        
         Statement stmt=null;
  
        //Class.forName("com.mysql.jdbc.Driver");
       Connection conx = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/mediatheque",
                           "root","");
        stmt = conx.createStatement();
        System.out.println(entree.readLine());
        System.out.println(entree.readLine());
        Scanner sc=new Scanner(System.in);
        String log=sc.nextLine();
        sortie.write(log+"\n");
        sortie.flush();
        System.out.println(entree.readLine());
        String passw=sc.nextLine();
        sortie.write(passw+"\n");
        sortie.flush();
        
        System.out.println(entree.readLine());
        
        System.out.println("Choisir une option :");
        System.out.println("1)Gestion des clients");
        System.out.println("2)Gestion des kindles");
        System.out.println("3)Gestion des documents");
        String choix=sc.nextLine();
        switch(choix){
            case "1":
               System.out.println("1.1)Ajouter Etudiant");
               System.out.println("1.2)Supprimer Etudiant");
               System.out.println("1.3)Ajouter Professeur");
               System.out.println("1.4)Supprimer Professeur");
                break;
            case "2":
                System.out.println("2.1)Ajouter Kindle");
               System.out.println("2.2)Supprimer Kindle");
               
                break;
            case "3":
                System.out.println("3.1)Ajouter Livre");
               System.out.println("3.2)Supprimer Livre");
               System.out.println("3.3)Ajouter Magazine");
               System.out.println("3.4)Supprimer Magazine");
               System.out.println("3.5)Ajouter Dictionnaire");
               System.out.println("3.6)Supprimer Dictionnaire");
                break;
            default:
                System.out.println("L\'option que vous avez choisi est incorrect \n");
                
                soc.close();
                break; 
           }
         String choix2=sc.nextLine();
         sortie.write(choix2+"\n");
         sortie.flush();
         System.out.println(entree.readLine());
         String cor=sc.nextLine();
         sortie.write(cor+"\n");
         sortie.flush();
        
         
         
     soc.close();    
         }catch(IOException ex){
             ex.printStackTrace();
         }
       
     }
}
