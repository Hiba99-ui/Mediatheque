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
    //private static int idE=0;
	//private final int Id;
	private final int IdClient;
	private final int IdKindle;
	private final Date DateEmprunt;
        private final Date DateRetour;
	private int Longitude;
	private int Altitude;
	
	
	public Emprunt(int idc, int idk, Date d , int lo, int la) {
		//this.Id=++idE;
		this.IdClient=idc;
		this.IdKindle=idk;
		this.DateEmprunt=d;
                this.DateRetour=null;
	}


	public int getIdClient() {
		return IdClient;
	}


	public int getIdKindle() {
		return IdKindle;
	}


	public Date getDateEmprunt() {
		return DateEmprunt;
	}
        
        public Date getDateRetour() {
		return DateRetour;
	}


	public int getLo() {
		return Longitude;
	}


	public void setLo(int lo) {
		Longitude = lo;
	}


	public int getLa() {
		return Altitude;
	}


	public void setLa(int la) {
		Altitude = la;
	}
	
	
}

