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
public class Etudiant extends Client{
    private String CNE;
    
    public Etudiant(String nom, String prenom/*, int age*/, String cne) throws SQLException {
		super(nom, prenom/*, age*/);
		this.CNE=new String(cne);
	}

    public String toString() {
		String s="C'est un Etudiant : \n"+super.toString()+"\n CNE : "+this.getCNE();
		return s;
	}
	
	
	public String getCNE() {
		return CNE;
	}

	public void setCNE(String CNE) {
		this.CNE = CNE;
	}
        
      
}
