package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.AlienDictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	//MODELLO
	private AlienDictionary model;
	

    public AlienDictionary getModel() {
		return model;
	}

	public void setModel(AlienDictionary model) {
		this.model = model;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	model.clearList();
    	
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String inserimento = txtWord.getText();
    	String tradotta = null;
    	
    	String array[]= inserimento.split(" ");
    	int dim = array.length;
    	
    	if(dim>2 || dim<=0) {
    		txtResult.appendText("Attenzione! Hai inserito più di una PAROLA ALIENA E TRADUZIONE\n");
    		return;
    	}else {
    		if(dim==2) {
    			String alien = array[0].trim();
        		String trans = array[1].trim();
    			if(alien.matches("[a-zA-Z]*") && trans.matches("[a-zA-Z]*")) {
    				
    				model.addWord(alien.toLowerCase(), trans.toLowerCase());
    				txtResult.appendText("Grazie! Hai contribuito ad una nuova traduzione!\n");
    				return;
    			}
    		}else {
    			String alien = array[0].trim();
    			if(alien.matches("[a-zA-Z]*")) {
    				tradotta = model.translateWord(alien.toLowerCase());
    				if(tradotta==null) {
    					txtResult.appendText("La parola Aliena inserita non ha ancora una traduzione!\n");
    					return;
    				}else {
    					txtResult.appendText("La traduzione della parola aliena "+alien.toUpperCase()+" è : "+tradotta.toUpperCase()+"\n");
    				}
    			}
    			
    			/*else if(alien.contains("?")) { //SE c'e il punto interregativo
    				String arrayAlien[] = alien.split("?");
    				int dimAlien= arrayAlien.length;
    				if(dimAlien==2 && arrayAlien[0].matches("[a-zA-Z]*") && arrayAlien[1].matches("[a-zA-Z]*")) {
    					String alien1 = arrayAlien[0].trim();
    	        		String alien2 = arrayAlien[1].trim();
    					tradotta = model.translateWord(alien1);
    					if(tradotta==null) {
    						tradotta=model.translateWordInterrogativo(alien2);
    					}
    					
    					if(tradotta==null) {
        					txtResult.appendText("La parola Aliena inserita non ha ancora una traduzione!\n");
        					return;
        				}else {
        					txtResult.appendText("La traduzione della parola aliena "+tradotta.toUpperCase()+"\n");
        				}
    				}else if(dimAlien==1){
    					String alien1 = arrayAlien[0].trim();
    					tradotta = model.translateWordInterrogativo(alien1);
    				
    					if(tradotta==null) {
        					txtResult.appendText("La parola Aliena inserita non ha ancora una traduzione!\n");
        					return;
        				}else {
        					txtResult.appendText("La traduzione della parola aliena "+tradotta.toUpperCase()+"\n");
        				}
    					
    				}
    			}*/
    		}
    	}
    	
    	if(tradotta==null) {
    		txtResult.appendText("Attenzione! Hai inserito Caratteri non validi.");
    	}

    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
        txtResult.appendText("\n");

    }
}
