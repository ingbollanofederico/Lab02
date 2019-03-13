package it.polito.tdp.alien.model;
import java.util.*;

public class AlienDictionary {
	//VARIABILI
	private List<Word> dictionary;

	//COSTRUTTORE
	public AlienDictionary() {
		this.dictionary= new LinkedList<Word>();
	}
	
	
	//METODI
	public void addWord(String alien, String trans) {
		
		//verificare se alien word già presente
		Word w = new Word(alien,trans);
		
		for(Word wtemp : this.dictionary) {
			if(w.equals(wtemp)) {
				wtemp.setTranslation(trans);
				return;
			}
		}
		

		//alien word no presente
		this.dictionary.add(w);
		
		
	}
	
	public String translateWord(String alien) {
		
		for(Word wtemp : this.dictionary) {
			if(wtemp.getAlienoWord().compareTo(alien)==0) {
				return wtemp.getTranslation();
			}
		}
		
		
		return null;
		
	}
	
	
	public void clearList() {
		this.dictionary.clear();
	}
	
	
	

}
