/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediathequeclient;

import Mod�le.Kindle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author hiba-
 */
public class MediathequeClient {
   static float la;
   static float lo;
  
  
    public static void main(String[] args) throws IOException, SQLException, SocketException{
      try{
           String hote = "127.0.0.1";
        int port =1300;
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
        String requete="SELECT * FROM kindle WHERE emprunte=0";
        ResultSet res=stmt.executeQuery(requete);
        if(res.next()){        
            String Mac=res.getString("mac");
            String Modele=res.getString("modele");
            //Boolean emprunt=res.getBoolean("emprunt");
            Kindle k=new Kindle(Mac,Modele);
              
            String req="UPDATE kindle SET emprunte=1 WHERE mac='"+Mac+"'";
	    stmt.executeUpdate(req);
            sortie.write(k.getMac()+"\n");
            sortie.flush();
            
            FileReader bf = new FileReader("C:\\Users\\hiba-\\Documents\\NetBeansProjects\\MediathequeClient\\src\\mediathequeclient\\Cordonnees.txt");
    BufferedReader bufferedReader = new BufferedReader(bf);
    HashMap<Integer, ArrayList> hmap = new HashMap<>();
    
    String ress;
            int j=0;
                while((ress=bufferedReader.readLine())!=null){
                    
                  //  String res = bufferedReader.readLine();
                    String[] splitted = ress.split(" ");
                    ArrayList l=new ArrayList();
                    l.add(splitted[0]);
                    l.add(splitted[1]);
                    hmap.put(j,l);
                    j++;      
               }     
               
                Random random = new Random();
                int nb;
                nb = random.nextInt(8);   
                ArrayList<String> coordonnees;   
               coordonnees = hmap.get(nb);
               
               String s1=coordonnees.get(0);
               la=Float.parseFloat(s1);
             
                String s2=coordonnees.get(1);
                lo=Float.parseFloat(s2);
                
                sortie.write(la+"\n");
                sortie.flush();
                sortie.write(lo+"\n");
                sortie.flush();
                
                //soc.close();
                
                String login=entree.readLine();
                if(login.equals("Erreur...")){
                    System.out.println(login);
                    soc.close();
                }
                else{
               
                 
                    int cpt=1;
                    while(cpt<4){
                 
                System.out.println(login);
                Scanner sc=new Scanner(System.in);
                String login1=sc.nextLine();
                sortie.write(login1+"\n");
                sortie.flush();
                String Passwd=entree.readLine();
                System.out.println(Passwd);                
                String Passwd1=sc.nextLine();
                sortie.write(Passwd1+"\n");
                sortie.flush();
                String rep=entree.readLine();
                System.out.println(rep);
                
                if(rep.equals("Informations incorrectes...")){
                 cpt=entree.read();
                }
                else{
                 cpt=entree.read();    } 
              }
                    if(cpt==4){
                    String rep1=entree.readLine();
                    System.out.println(rep1);
                    soc.close();
                    }
                    else{
                        System.out.println(entree.readLine());
                        
                         System.out.println("Choisir votre mode de recherche");
                 System.out.println("1)Par titre");
                 System.out.println("2)Par auteur");
                 System.out.println("3)Par année d\'édition");
                 System.out.println("4)Par editeur");
                 System.out.println("5)Par isbn");  
                 Scanner sc=new Scanner(System.in);
                 String choix=sc.nextLine();
                 sortie.write(choix+"\n");
                 sortie.flush();
                 String st=entree.readLine();
                  System.out.println(st);
                 String motcle=sc.nextLine();
                 sortie.write(motcle+"\n");
                 sortie.flush();
                Boolean boucle=true;
                 System.out.println(entree.readLine());
                 //System.out.println(entree.readLine());
                //int n=0;
                 while(true){
                 System.out.println(entree.readLine()+"\n");
                 //n++;
                 }
        /*         
                 if((entree.readLine()).equals("Au revoir temps epuisé..")){
                     System.out.println(entree.readLine());
                     soc.close();
                 }
                 
                 
            System.out.println("A la prochaine...");
            soc.close();
             
     */            
                 
                 
                    }
                    
                
        }
        }
//soc.close();
//sortie.close();
//entree.close();
       }catch(IOException ex){
           ex.printStackTrace();
       }
 
    }
    
}
