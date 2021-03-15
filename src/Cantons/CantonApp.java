package Cantons;

import javafx.application.Application;
import javafx.stage.Stage;

public class CantonApp extends Application {
	
	private CantonModel model;
	private CantonView view;
	private CantonController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		model = new CantonModel();
		model.addCantons();
		
		view = new CantonView(primaryStage, model);
		
		controller = new CantonController(model, view);
		
		view.start();
	}

	public static void main(String[] args) {
	launch();

	}

}
