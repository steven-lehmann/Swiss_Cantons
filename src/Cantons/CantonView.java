package Cantons;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CantonView {
	
	final private CantonModel model;
	protected static Stage stage;
	
	//elements in the GUI
	protected ChoiceBox<Canton> cantonsDisplay;
	protected Button creatButton, displayButton, editButton, deleteButton, homeButton, addNewCanton, saveAndUpdateButton;
	
	protected BorderPane root, cantonView;
	
	protected Label lbHeading, lbTeaser, lbNewCanton, lbViewCanton, lbUpdateCanton,
			lbDeleteCanton, lbName, lbSize, lbPopulation, lbAcronym, lbYear, lbLanguage,
			lbMainPlace, lbNeighbor, lbLink, lbAttractions;
	
	protected TextField txtName, txtSize, txtPopulation, txtAcronym, txtYear, 
			 txtMainPlace, txtLink;
	
	protected TextArea txtaLanguage, txtaAttractions, txtaNeighbor;
	
	protected final Image BLFLAG = new Image("/BL_Flagge.png");
	protected final Image BEFLAG = new Image("/BE_Flagge.png");
	protected final Image ZHFLAG = new Image("/ZH_Flagge.jpeg");
	protected ImageView flagView;
	
	protected final Image BLCARD = new Image("/BL_Karte.png");
	protected ImageView cardBLView;
	
	protected  Scene scene1, scene2;
	
	
	public CantonView(Stage stage, CantonModel model) {
		this.model = model;
		this.stage = stage;
		
		//Home View
		
		root = new BorderPane();
		VBox center = new VBox();
		GridPane buttonGrid = new GridPane();
				
		this.cantonsDisplay = new ChoiceBox<Canton>();

		this.creatButton = new Button("Neu");
		this.displayButton = new Button("Anzeigen");
			
				
		this.lbHeading = new Label("Willkommen");
		this.lbTeaser = new Label("Dies ist eine Übersicht der Kantone in der Schweiz ");
		this.lbNewCanton = new Label("Kanton hinzufügen:");
		this.lbViewCanton = new Label("Kanton anzeigen:");
				
		this.lbHeading.getStyleClass().add("lbHeading");
		this.lbTeaser.getStyleClass().add("lbTeaser");
		
		for(Canton c : model.cantonsList) {
			this.cantonsDisplay.getItems().addAll(c);
		}
				

		this.cantonsDisplay.getStyleClass().add("choiceBox");
				
		buttonGrid.add(this.lbNewCanton, 0, 0);
		buttonGrid.add(this.creatButton, 1, 0);
		buttonGrid.add(this.lbViewCanton, 0, 1);
		buttonGrid.add(this.cantonsDisplay, 1, 1);
		buttonGrid.add(this.displayButton, 2, 1);

			
		buttonGrid.getStyleClass().add("buttonGrid");
		this.creatButton.getStyleClass().add("buttonCanton");
		this.displayButton.getStyleClass().add("buttonCanton");
				
		center.getChildren().addAll(this.lbHeading, this.lbTeaser, buttonGrid);
			
		center.getStyleClass().add("center");
				
		root.setCenter(center);
		
		
		
		// Kanton View
		
		cantonView = new BorderPane();
		HBox middle = new HBox();
		VBox left = new VBox();
		VBox right = new VBox();
		GridPane cantonViewLeft = new GridPane();
		GridPane cantonViewRight = new GridPane();
		
		ToolBar toolbar = new ToolBar();
		
		toolbar.getStyleClass().add("toolbar");
		
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
		
		// TF können nicht geändert werden
		this.txtName.setDisable(true);
		this.txtAcronym.setDisable(true);
		this.txtMainPlace.setDisable(true);
		this.txtaLanguage.setDisable(true);
		this.txtYear.setDisable(true);
		
		this.cardBLView = new ImageView(BLCARD);
		
		this.editButton = new Button("Bearbeiten");
		this.addNewCanton = new Button("Neu hinzufügen");
		this.deleteButton = new Button("Löschen");
		this.homeButton = new Button("Home");
		this.saveAndUpdateButton = new Button("Speichern und Aktualisieren");
		
		this.homeButton.getStyleClass().add("buttonCanton");
		this.editButton.getStyleClass().add("buttonCanton");
		this.deleteButton.getStyleClass().add("buttonCanton");
		this.addNewCanton.getStyleClass().add("buttonCanton");
		this.saveAndUpdateButton.getStyleClass().add("buttonCanton");
		
		
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
		
		//TF are disable
		
		this.txtPopulation.setDisable(true);
		this.txtSize.setDisable(true);
		this.txtaAttractions.setDisable(true);
		this.txtaNeighbor.setDisable(true);
		this.txtLink.setDisable(true);
				
		this.flagView = new ImageView(BLFLAG);
				
		cantonViewRight.add(this.flagView, 0, 0, 2, 4);
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
		
		right.getChildren().add(cantonViewRight);
		
		right.getStyleClass().add("right");
		
		cantonViewRight.getStyleClass().add("cantonViewRight");
		
		//HBox füllen
		
		middle.getChildren().addAll(left, right);
		
		middle.getStyleClass().add("middle");
		
		//BorderPane füllen
		
		toolbar.getItems().addAll(this.homeButton, this.editButton, this.deleteButton, this.addNewCanton, this.saveAndUpdateButton);
		
		cantonView.setTop(toolbar);
		cantonView.setCenter(middle);
		
		//Set Scene
		
		scene1 = new Scene(root, 1400, 850);
		scene1.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene1);
		stage.setTitle("Kanton App");
		
		scene2 = new Scene(cantonView);
		scene2.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
		this.cardBLView.setFitHeight(300);
		this.cardBLView.setFitWidth(450);
			
		this.flagView.setFitHeight(150);
		this.flagView.setFitWidth(120);
		
	}

	public void start() {
		stage.show();
		
}
	
	public void changeView() {
		stage.setScene(scene2);
		stage.show();
		
		
	}

	public void backHome() {
		stage.setScene(scene1);
		stage.show();
	}

	public void updateCantonDisplay() {
		for(Canton c : model.cantonsList) {
			this.cantonsDisplay.getItems().addAll(c);
		
		}
	}

	public void setTF() {
		this.txtName.setDisable(false);
		this.txtAcronym.setDisable(false);
		this.txtMainPlace.setDisable(false);
		this.txtMainPlace.setDisable(false);
		this.txtaLanguage.setDisable(false);
		this.txtYear.setDisable(false);
		
		this.txtPopulation.setDisable(false);
		this.txtSize.setDisable(false);
		this.txtaAttractions.setDisable(false);
		this.txtaNeighbor.setDisable(false);
		this.txtLink.setDisable(false);
		
		
	}
	public void setTFDisable() {
		this.txtName.setDisable(true);
		this.txtAcronym.setDisable(true);
		this.txtMainPlace.setDisable(true);
		this.txtMainPlace.setDisable(true);
		this.txtaLanguage.setDisable(true);
		this.txtYear.setDisable(true);
		
		this.txtPopulation.setDisable(true);
		this.txtSize.setDisable(true);
		this.txtaAttractions.setDisable(true);
		this.txtaNeighbor.setDisable(true);
		this.txtLink.setDisable(true);
		
		
	}

	public void updateImage(Canton canton) {
		if(canton.getName() == CantonsSwiss.BaselLand) {
			flagView.setImage(BLFLAG);
		}
		if(canton.getName() == CantonsSwiss.Bern) {
			flagView.setImage(BEFLAG);
		}
		if(canton.getName() == CantonsSwiss.Zürich) {
			flagView.setImage(ZHFLAG);
		}
		if(canton.getName() == null) {
			flagView.setImage(null);
		}
	}
		
	
}