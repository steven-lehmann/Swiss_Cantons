package Cantons;

import javafx.event.ActionEvent;

public class CantonController {
	
	private CantonView view;
	private CantonModel model;

	public CantonController(CantonModel model, CantonView view) {
		
		//Anzeigen
		
		view.displayButton.setOnAction(this::display);
		view.cantonsDisplay.setOnAction(this::display);
		
		//Bearbeiten
		view.editButton.setOnAction(this::edit);
		//view.cantonsEdit.setOnAction(this::edit);
		
		//Löschen
		view.deleteButton.setOnAction(this::delete);
		//view.cantonsDelete.setOnAction(this::delete);
		
		
		
	
	}
	
	public void display(ActionEvent e) {
		System.out.println("Test2");
	}
	
	public void edit(ActionEvent e) {
		System.out.println("Test2");
		
	}
	public void delete(ActionEvent e) {
		System.out.println("Test3");
	}
	

}
