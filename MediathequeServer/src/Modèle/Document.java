/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.util.Arrays;

/**
 *
 * @author hiba-
 */
public abstract class Document {
    //static private int idi=0;
	//private int id;
	private final String Titre;
	private final String[] Auteur;
	private final int Edition;
	private final String Editeur; 
	private String URL;
	private final String Isbn;
	
	
	public Document(String titre, String[] auteur, int année, String editeur,String url,String isbn) {
		//idi++;
		//this.id=idi;
		this.Titre=titre;
		this.Auteur=auteur.clone();
		this.Edition=année;
		this.Editeur=editeur;
		this.URL=url;
		this.Isbn=isbn;
		
	}
	
	public Document(Document D){
		//this.id=D.idi;
		this.Titre=new String(D.getTitre());
		this.Auteur=D.getAuteur().clone();
		this.Edition=D.getEdition();
		this.Editeur=new String(D.getEditeur());
		this.URL=new String(D.getUrl());
		this.Isbn=new String(D.Isbn);
	}
	
	
	
	public String toString() {
		return "ISBN : "+this.Isbn+"\n"+
			   "Titre : "+this.Titre+"\n"+
			   "Auteur : "+Arrays.toString(this.Auteur)+"\n"+
			   "AnnÃ©e : "+this.Edition+"\n"+
			   "Editeur : "+this.Editeur+"\n"+
			   "Lien : "+this.URL+"\n";
	}
	
	
	
	
	public String getIsbn(){
        return Isbn;    
        }
        
        public String getUrl(){
            return URL;
        }
        
	public String getTitre() {
		return Titre;
	}
	
	public String[] getAuteur() {
		return Auteur;
	}

	public int getEdition() {
		return Edition;
	}
	
        public void setURL(String url){
           this.URL=url;
        }
        
        
	public String getEditeur() {
		return Editeur;
	}

	
	public void setUrl(String url) {
		URL = url;
	}

	
	public void finalize() {
		System.out.println("Voila un destructeur");
	}
}

