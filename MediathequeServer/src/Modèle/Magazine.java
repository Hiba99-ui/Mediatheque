/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author hiba-
 */
public class Magazine extends Document{
    public float periodicite;
    public int moisEdition;
    public int jour;
  
  public Magazine(String titre, String[] auteur,int année, String editeur, String url, String isbn, float per, int moisEd,int jr){
  super(titre, auteur, année, editeur, url,isbn);
  periodicite=per;
  moisEdition=moisEd;
  jour=jr;
  }
  
    public float getPeriodicite(){
       return periodicite;    
    }
    
    public int getMoisEdition(){
       return moisEdition;    
    }
    
    public int getJour(){
       return jour;    
    }
    
  public String toString(){
  return "Magazine : \n"+super.toString()+"PeriodicitÃ© : "+periodicite+"\nMois d'edition : "+moisEdition+"\nJour : "+jour+"";
  }

    public static void main(String[] args) {

    }
}
