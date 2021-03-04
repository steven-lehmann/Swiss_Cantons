package Cantons;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CantonView {
	
	final private CantonModel model;
	final private Stage stage;
	
	//elements in the GUI
	protected ChoiceBox<String> cantons;
	protected Button submitButton;
	protected final Image ALLCANTONS = new Image("/cantons.png"); //TODO add Picture
	protected ImageView cantonView;
	

	public CantonView(Stage stage, CantonModel model) {
		this.model = model;
		this.stage = stage;
		
		BorderPane root = new BorderPane();
		VBox center = new VBox();
		
		this.cantons = new ChoiceBox<String>();
		this.submitButton = new Button("Submit");
		this.cantonView = new ImageView(ALLCANTONS);
		
		cantons.getItems().addAll("Basel", "Bern", "Zürich");
		
		center.getChildren().addAll(this.cantons, this.submitButton);
		
		root.setTop(cantonView);
		root.setCenter(center);
		
		Scene scene = new Scene(root);
		//TODO Style sheet 
		stage.setScene(scene);
		stage.setTitle("Kanton App");
		
		
		
		
	}

	
	

	public void start() {
		stage.show();
		
		
	}

		
	

}
