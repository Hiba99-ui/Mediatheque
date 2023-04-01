/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.sql.SQLException;

/**
 *
 * @author hiba-
 */
public class Professeur extends Client{
    private String CIN;
	
	public Professeur(String nom, String prenom/*, int age*/, String cin) throws SQLException {
		super(nom, prenom/*, age*/);
		this.CIN=cin;
		
	}


	public String getCIN() {
		return CIN;
	}

	public void setCIN(String CIN) {
		this.CIN = CIN;
	}
    @Override    
     public String toString(){
         String s="Professeur \n"+super.toString()+"\nCIN : "+this.getCIN();
         return s;
     }
}

