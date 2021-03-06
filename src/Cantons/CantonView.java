package Cantons;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CantonView {
	
	final private CantonModel model;
	final private Stage stage;
	
	//elements in the GUI
	protected ChoiceBox<String> cantons;
	protected Button createButton, displayButton;
	//protected final Image ALLCANTONS = new Image("/cantons.png");
	//protected ImageView cantonView;
	protected MenuBar menus = new MenuBar();
	protected Menu menuHome = new Menu("Home");
	
	protected Label lbHeading, lbTeaser, lbNewCanton, lbViewCanton;
	

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
		
		
		buttonGrid.add(this.lbNewCanton, 0,0);
		buttonGrid.add(this.createButton, 1,0);
		buttonGrid.add(this.lbViewCanton, 0,1);
		buttonGrid.add(this.cantons, 1,1);
		buttonGrid.add(this.displayButton, 2,1);
		
		center.getChildren().addAll(this.lbHeading, this.lbTeaser, buttonGrid);
		
		root.setCenter(center);
		
		Scene scene = new Scene(root, 800, 700);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Kanton App");
		
		
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
