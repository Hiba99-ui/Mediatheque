/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mod�le;

import Mod�le.Document;

/**
 *
 * @author hiba-
 */
public class Dictionnaire extends Document{
    
    public String langue;
    public int nmbtome;
    
      public Dictionnaire(String titre, String[] auteur,int ann�e, String editeur, String url, String isbn,String langue, int tome){
          super(titre, auteur, ann�e, editeur, url,isbn);
          this.langue=langue;
          this.nmbtome=tome;
    }
  
    @Override
       public String toString(){
             return "Dictionnaire : \n"+super.toString()+"Langue : "+langue+"\nNmbtome : "+nmbtome;
            }
       
       
       public String getLangue(){
           return langue;
       }
       
       public int getNbTome(){
           return nmbtome;
       }
       
       
       
    public static void main(String[] args) {

    }
    
}

