/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediathequeserver;

import Modèle.Dictionnaire;
import Modèle.Livre;
import Modèle.Magazine;
import java.io.IOException;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author hiba-
 */
public class Test {
     public static void main(String[] args) throws IOException, SQLException, SocketException{
         String cor10="jjj,rr-dfc,1234,ddd,ddd,der,dfgh,12";
         String[] reslt5=cor10.split("[,]", 0);
                 String[] auteur2=reslt5[1].split("-",0);
                 int n7=Integer.parseInt(reslt5[2]);
                
                 int n8=Integer.parseInt(reslt5[7]);
                 
                 Dictionnaire d=new Dictionnaire(reslt5[0],auteur2,n7,reslt5[3],reslt5[4],reslt5[5],reslt5[6],n8);
                 boolean b11=new DB.CRUD_Document().AjouterDictionnaire(d);
     }
}
