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
public class Admin {

    private String login;
    private String password;
    private String nom;
    private String prenom;
    private String email;
    private String tele;
    
    public Admin(String login,String password,String nom, String prenom,String email, String tele){
        this.login=login;
        this.password=password;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.tele=tele;}
    
    //getter
  
    public String getlogin(){
        return this.login;
    }
}
