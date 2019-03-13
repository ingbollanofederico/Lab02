package it.polito.tdp.alien.model;
import java.util.*;

public class Word {
	
	private String alienoWord;
	//private String translation;
	private List<String> translation =new LinkedList<String>();
	
	
	public Word(String alienoWord, String translation) {
		this.alienoWord = alienoWord;
		this.translation.add(translation);
		
	}

	

	public String getAlienoWord() {
		return alienoWord;
	}



	public void setAlienoWord(String alienoWord) {
		this.alienoWord = alienoWord;
	}



	public String getTranslation() {
		//return translation;
		String temp="";
		for(String s : this.translation) {
			temp+=s+" ";
		}
		return temp.trim();
	}



	public void setTranslation(String translation) {
		//this.translation = translation;
		this.translation.add(translation);
	}



	@Override
	public boolean equals(Object obj) {
		
		Word temp = (Word)obj;
		
		if(this.getAlienoWord().compareTo(temp.getAlienoWord())==0) {
			return true;
		}else {
			return false;
		}
	
	}
	
	
	
	
	

}
