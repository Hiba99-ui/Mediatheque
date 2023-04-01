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
public class Livre extends Document{
    private int NbPages; 
	
	
	


	public Livre(String titre, String[] auteur,int année, String editeur, String url, int Nbr_pages, String isbn) {
		super(titre, auteur, année, editeur, url,isbn);
		//this.Isbn=isbn;
		this.NbPages=Nbr_pages;
		
	}

	
	


	public int getNbPages() {
		return NbPages;
	}


	public void setNombre_Pages(int nombre_Pages) {
		NbPages = nombre_Pages;
	}


	


	
	
	
	
	
	
	public String toString() {
		return "Livre : \n"+super.toString()+"Nombre de Pages : "+this.NbPages+"\n ";
	}
	
	
}

