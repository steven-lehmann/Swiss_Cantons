package Cantons;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CantonDetailView {
	
	//Class der zweiten Ansicht exrahiert von der Hauptansicht
	//Noch nicht der stage übergebbar

	final private CantonModel model;
	final private Stage stage;
	
	//elements in the GUI
	protected ChoiceBox<CantonsSwiss> cantonsDisplay;
	protected Button displayButton, editButton, deleteButton, submitButton;
		
	protected MenuBar menus = new MenuBar();
	protected Menu menuHome = new Menu("Home");
	
	protected Label lbName, lbSize, lbPopulation, lbAcronym, lbYear, lbLanguage,
			lbMainPlace, lbNeighbor, lbLink, lbAttractions;
	
	protected TextField txtName, txtSize, txtPopulation, txtAcronym, txtYear, 
			 txtMainPlace, txtLink;
	
	protected TextArea txtaLanguage, txtaAttractions, txtaNeighbor;
	
	protected final Image BLFLAG = new Image("/BL_Flagge.png");
	protected final Image BEFLAG = new Image("/BE.png");
	protected ImageView cantonBLView;
	
	protected final Image BLCARD = new Image("/BL_Karte.png");
	protected ImageView cardBLView;
	
	//View Main and Canton 
	protected BorderPane cantonView;
	
	public CantonDetailView(Stage stage, CantonModel model) {
		
		this.model = model;
		this.stage = stage;
		
	// Kanton View

		cantonView = new BorderPane();
		HBox middle = new HBox();
		VBox left = new VBox();
		VBox right = new VBox();
		GridPane cantonViewLeft = new GridPane();
		GridPane cantonViewRight = new GridPane();
		
		cantonView.getStyleClass().add("cantonView");
				
		//Linke Spalte
				
		this.lbName = new Label("Name: ");
		this.lbAcronym = new Label("Kürzel: ");
		this.lbMainPlace = new Label("Hauptort: ");
		this.lbLanguage = new Label("Sprache: ");
		this.lbYear = new Label("Beitrittsjahr: ");
		
		this.txtName = new TextField();
		this.txtAcronym = new TextField();
		this.txtMainPlace = new TextField();
		this.txtaLanguage = new TextArea();
		this.txtYear = new TextField();
		
		this.cardBLView = new ImageView(BLCARD);
		
		
		cantonViewLeft.add(this.lbName, 0, 0);
		cantonViewLeft.add(this.txtName, 1, 0);
		cantonViewLeft.add(this.lbAcronym, 0, 1);
		cantonViewLeft.add(this.txtAcronym, 1, 1);
		cantonViewLeft.add(this.lbMainPlace, 0, 2);
		cantonViewLeft.add(this.txtMainPlace, 1, 2);
		cantonViewLeft.add(this.lbLanguage, 0, 3);
		cantonViewLeft.add(this.txtaLanguage, 1, 3);
		cantonViewLeft.add(this.lbYear, 0, 4);
		cantonViewLeft.add(this.txtYear, 1, 4);
		cantonViewLeft.add(this.cardBLView, 0, 5, 3, 5);
		
		left.getChildren().add(cantonViewLeft);
		
		left.getStyleClass().add("left");
		
		cantonViewLeft.getStyleClass().add("cantonViewLeft");
		
		//Rechte Spalte
		
		this.lbPopulation = new Label("Bevölkerung: ");
		this.lbSize = new Label("Fläche: ");
		this.lbAttractions = new Label("Sehenswürdigkeiten: ");
		this.lbNeighbor = new Label("Nachbarkantone: ");
		this.lbLink = new Label("Link: ");
		
		this.txtPopulation = new TextField();
		this.txtSize = new TextField();
		this.txtaAttractions = new TextArea();
		this.txtaNeighbor = new TextArea();
		this.txtLink = new TextField();
				
		this.cantonBLView = new ImageView(BEFLAG);
				
		cantonViewRight.add(this.cantonBLView, 0, 0, 2, 4);
		cantonViewRight.add(this.lbPopulation, 0, 4);
		cantonViewRight.add(this.txtPopulation, 1, 4);
		cantonViewRight.add(this.lbSize, 0, 5);
		cantonViewRight.add(this.txtSize, 1, 5);
		cantonViewRight.add(this.lbAttractions, 0, 6);
		cantonViewRight.add(this.txtaAttractions, 1, 6);
		cantonViewRight.add(this.lbNeighbor, 0, 7);
		cantonViewRight.add(this.txtaNeighbor, 1, 7);
		cantonViewRight.add(this.lbLink, 0, 8);
		cantonViewRight.add(this.txtLink, 1, 8);
		cantonViewRight.add(this.editButton, 1, 10);
		cantonViewRight.add(this.deleteButton, 2, 10);
		
		right.getChildren().add(cantonViewRight);
		
		right.getStyleClass().add("right");
		
		cantonViewRight.getStyleClass().add("cantonViewRight");
		
		//HBox füllen
		
		middle.getChildren().addAll(left, right);
		
		middle.getStyleClass().add("middle");
		
		//BorderPane füllen
		
		cantonView.setTop(menus);
		cantonView.setCenter(middle);

		
		//Set Scene
		
		Scene scene2 = new Scene(cantonView);
		scene2.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene2);
		stage.setTitle("Kanton App");
		
		
		//Style Images
		
		this.cardBLView.setFitHeight(300);
		this.cardBLView.setFitWidth(450);
			
		this.cantonBLView.setFitHeight(200);
		this.cantonBLView.setFitWidth(150);
	
	}
		
		
	
}
