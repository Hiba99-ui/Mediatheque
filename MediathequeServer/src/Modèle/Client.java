/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;
import Modèle.Etudiant;
import Modèle.Utilisateur;
import java.sql.SQLException;

/**
 *
 * @author hiba-
 */
public class Client extends Utilisateur{
        //static private int idC=0;
	private String Nom;
	private String Prenom;
	//private int Age;
	//private int[] LesFavoris;
        
   public Client(String nom, String prenom) throws SQLException {
		super();
               
		this.Nom=new String(nom);
		this.Prenom=new String(prenom);
		
	}
   
	
    public Client(Client C) throws SQLException {
                super();
		this.Nom=new String(C.getNom());
		this.Prenom=new String(C.getPrenom());
		//this.Age=C.getAge();
	}
    
     
    
    public String toString() {
		String s="Le Nom : "+this.getNom()+"\nLe prenom : "+this.getPrenom();
		return s;
	}
  
    public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
       
/*
	public int getAge() {
		return Age;
	}
*/

/*	public void setAge(int age) {
		Age = age;
	}
*/
}
