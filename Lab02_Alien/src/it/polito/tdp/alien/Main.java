package it.polito.tdp.alien;
	
import it.polito.tdp.alien.model.AlienDictionary;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//FXMLLOADER
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Alien.fxml")); //SI USA LOADER perchè lavora con SceneBuilder. Prende il file xml e crea per noi tutti i nodi
			
			
			
			//VIEW
			BorderPane root = (BorderPane)loader.load(); //nodoradice
			Scene scene = new Scene(root);//creazione scena
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			
			//MODEL
			AlienDictionary model = new AlienDictionary();//CREAZIONE DEL MODELLO
			
			
			
			//CONTROLLER
			AlienController controller = (AlienController)loader.getController();
			controller.setModel(model);
			
			
			
			//display view
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
