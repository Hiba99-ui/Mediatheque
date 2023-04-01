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
  
  public Magazine(String titre, String[] auteur,int année, String editeur, String url, String isbn, float per, int moisEd,int jour){
  super(titre, auteur, année, editeur, url,isbn);
  periodicite=per;
  moisEdition=moisEd;
  jour=jour;
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
    
  public String ToString(){
  return "C'est une Magazine : "+super.toString()+" \n Sa periodicitÃ© : "+periodicite+"\n Son mois d'edition : "+moisEdition+"\n Le jour "+jour;
  }

    public static void main(String[] args) {

    }
}

