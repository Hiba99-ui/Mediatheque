/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.util.Date;

/**
 *
 * @author hiba-
 */
public class Emprunt {
    
	private final String IdClient;
	private final String IdKindle;
	private final String DateDebut;
        private final String DateFin;
	
	
	
	public Emprunt(String idc, String idk, String d, String f) {
	   	
		this.IdClient=idc;
		this.IdKindle=idk;
		this.DateDebut=d;
                this.DateFin=f;
	}


	public String getIdClient() {
		return IdClient;
	}


	public String getIdKindle() {
		return IdKindle;
	}


	public String getDateEmprunt() {
		return DateDebut;
	}
        
        public String getDateRetour() {
		return DateFin;
	}

       public String toString(){
           String s;
           s="Emprunt : \nIDClient : "+this.getIdClient()+"\nIDKindle : "+this.getIdKindle()+"\nDate de dÃ©but : "+this.getDateEmprunt()+"\nDate de fin : "+this.getDateRetour()+"";
           return s;
       }
	
	
}

