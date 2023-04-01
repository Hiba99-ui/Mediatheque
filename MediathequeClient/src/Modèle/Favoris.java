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
public class Favoris {
    private static int idF=0;
	private final int id;
	private int[] IdDocument;
	private String Label;
	
	public Favoris(int[] iddocument, String label) {
		this.id=++idF;
		this.setIdDocument(iddocument.clone());
		this.setLabel(label);
		
	}

	public int[] getIdDocument() {
		return IdDocument;
	}

	public void setIdDocument(int[] idDocument) {
		IdDocument = idDocument;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public int getId() {
		return id;
	}
}
