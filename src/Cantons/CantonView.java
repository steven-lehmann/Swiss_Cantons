package Cantons;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CantonView {
	
	final private CantonModel model;
	final private Stage stage;
	
	//elements in the GUI
	protected ChoiceBox<String> cantons;
	protected Button createButton, displayButton, editButton, deletButton, submitButton;
	
	//protected final Image ALLCANTONS = new Image("/cantons.png");
	//protected ImageView cantonView;
	
	protected MenuBar menus = new MenuBar();
	protected Menu menuHome = new Menu("Home");
	
	protected Label lbHeading, lbTeaser, lbNewCanton, lbViewCanton, lbName, lbSize, lbPopulation,
			lbAcronym, lbYear, lbLanguage, lbMainPlace, lbNeighbor, lbLink, lbAttractions;
	
	protected TextField txtName, txtSize, txtPopulation, txtAcronym, txtYear, 
			txtLanguage, txtMainPlace, txtNeighbor, txtLink, txtAttractions;
	
	//protected final Image BLFLAG = new Image("/BLFlagge.png");
	//protected ImageView cantonBLView;
	
	//protected final Image BLCARD = new Image("/BLKarte.png");
	//protected ImageView cardBLView;
	

	public CantonView(Stage stage, CantonModel model) {
		this.model = model;
		this.stage = stage;
		
		//Home View
		
		BorderPane root = new BorderPane();
		VBox center = new VBox();
		GridPane buttonGrid = new GridPane();
				
		this.cantons = new ChoiceBox<String>();
		this.createButton = new Button("Neu");
		this.displayButton = new Button("Anzeigen");
		//this.cantonView = new ImageView(ALLCANTONS);
				
				
		lbHeading = new Label("Willkommen");
		lbTeaser = new Label("Dies ist eine Übersicht der Kanton in der Schweiz ");
		lbNewCanton = new Label("Kanton hinzufügen:");
		lbViewCanton = new Label("Kanton anzeigen:");
				
		root.setTop(menus);
		menus.getMenus().add(menuHome);
				
		cantons.getItems().addAll("Basel", "Bern", "Zürich");
		cantons.setValue("Bern");
				
				
		buttonGrid.add(this.lbNewCanton, 0, 0);
		buttonGrid.add(this.createButton, 1, 0);
		buttonGrid.add(this.lbViewCanton, 0, 1);
		buttonGrid.add(this.cantons, 1, 1);
		buttonGrid.add(this.displayButton, 2, 1);
			
				
		center.getChildren().addAll(this.lbHeading, this.lbTeaser, buttonGrid);
				
				
		root.setCenter(center);
		
		
		
		// Kanton View
		
				BorderPane cantonView = new BorderPane();
				HBox middle = new HBox();
				VBox left = new VBox();
				VBox right = new VBox();
				GridPane cantonViewLeft = new GridPane();
				GridPane cantonViewRight = new GridPane();
				
				//Linke Spalte
				
				lbName = new Label("Name: ");
				lbAcronym = new Label("Kürzel: ");
				lbMainPlace = new Label("Hauptort");
				lbLanguage = new Label("Sprache: ");
				lbYear = new Label("Beitrittsjahr: ");
				
				this.txtName = new TextField();
				this.txtAcronym = new TextField();
				this.txtMainPlace = new TextField();
				this.txtLanguage = new TextField();
				this.txtYear = new TextField();
				
				
				cantonViewLeft.add(lbName, 0, 0);
				cantonViewLeft.add(txtName, 1, 0);
				cantonViewLeft.add(lbAcronym, 0, 1);
				cantonViewLeft.add(txtAcronym, 1, 1);
				cantonViewLeft.add(lbMainPlace, 0, 2);
				cantonViewLeft.add(txtMainPlace, 1, 2);
				cantonViewLeft.add(lbLanguage, 0, 3);
				cantonViewLeft.add(txtLanguage, 1, 3);
				cantonViewLeft.add(lbYear, 0, 4);
				cantonViewLeft.add(txtYear, 1, 4);
				//cantonViewLeft.add(cardBLView, 0, 5);
				
				left.getChildren().add(cantonViewLeft);
				
				//Rechte Spalte
				
				lbPopulation = new Label("Bevölkerung: ");
				lbSize = new Label("Fläche: ");
				lbAttractions = new Label("Top 3 Sehenswürdigkeiten");
				lbNeighbor = new Label("Nachbarkantone");
				lbLink = new Label("Link");
				
				this.txtPopulation = new TextField();
				this.txtSize = new TextField();
				this.txtAttractions = new TextField();
				this.txtNeighbor = new TextField();
				this.txtLink = new TextField();
				
				
				
				//cantonViewRight.add(cantonBLView, 0, 0);
				cantonViewRight.add(lbPopulation, 0, 1);
				cantonViewRight.add(txtPopulation, 1, 1);
				cantonViewRight.add(lbSize, 0, 2);
				cantonViewRight.add(txtSize, 1, 2);
				cantonViewRight.add(lbAttractions, 0, 3);
				cantonViewRight.add(txtAttractions, 1, 3);
				cantonViewRight.add(lbNeighbor, 0, 4);
				cantonViewRight.add(txtNeighbor, 1, 4);
				cantonViewRight.add(lbLink, 0, 5);
				cantonViewRight.add(txtLink, 1, 5);
				
				right.getChildren().add(cantonViewRight);
				
				//HBox füllen
				
				middle.getChildren().addAll(left, right);
				
				//BorderPane füllen
				
				cantonView.setTop(menus);
				cantonView.setCenter(middle);

		
		//Set Scene
		
		Scene scene = new Scene(root, 1000, 800);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Kanton App");
		
		//cardBLView.setFitHeight(50);
		//cardBLView.setFitWidth(70);
		
		//cantonBLView.setFitHeight(30);
		//cantonBLView.setFitWidth(20);
		
		//Some stylings 
		//center.setAlignment(Pos.CENTER);
		//cantonView.setFitHeight(481);
		//cantonView.setFitWidth(720);
		//root.setAlignment(cantonView, Pos.CENTER);
	}

	public void start() {
		stage.show();
		
		
	}

		
	

}
