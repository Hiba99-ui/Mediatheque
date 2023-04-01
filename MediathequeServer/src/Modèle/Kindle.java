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
public class Kindle {
    private final String Mac;
	private final String Modele;
	//private static int idK=0;
	//private int id;
	private int Emprunte=0;
	
	public Kindle(String mac,String modele) {
		this.Mac= mac;
		this.Modele=modele;
		//this.setId(++idK);
	}

	public String getMac() {
		return Mac;
	}

	public String getModele() {
		return Modele;
	}

	

	public int isEmprunte() {
		return Emprunte;
	}

	public void setEmprunte(int emprunte) {
		Emprunte = emprunte;
	}
        public String toString(){
            String s;
            s="Kindle :\nMAC : "+this.getMac()+"\nModÃ¨le : "+this.Modele+"\nEmprunte : "+this.Emprunte+"\n";
            return s;
        }
        

}

