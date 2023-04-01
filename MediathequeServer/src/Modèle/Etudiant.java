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
    
    public Etudiant(String nom, String prenom, String cne) throws SQLException {
		super(nom, prenom);
		this.CNE=cne;
	}
    
    

    public String toString() {
		String s="Etudiant : \n"+super.toString()+"\nCNE : "+this.getCNE();
		return s;
	}
	
	
	public String getCNE() {
		return CNE;
	}

	public void setCNE(String CNE) {
		this.CNE = CNE;
	}
        
      
}
