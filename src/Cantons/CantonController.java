package Cantons;

import javafx.event.ActionEvent;
import javafx.scene.Scene;


public class CantonController {
	
	private CantonView view;
	private CantonModel model;

	public CantonController(CantonModel model, CantonView view) {
		
		//Anzeigen
		
		view.displayButton.setOnAction(this::display);
		
		// Hinzufügen
		view.creatButton.setOnAction(this::creat);
		
		//Bearbeiten
		view.editButton.setOnAction(this::edit);
		//view.cantonsEdit.setOnAction(this::edit);
		
		//Löschen
		view.deleteButton.setOnAction(this::delete);
	
		view.back.setOnAction(this::home);
		
		
	
	
	}
	
	public void creat(ActionEvent e) {
		model.creatCanton();
	}
	
	public void display(ActionEvent e) {
		CantonView.changeView();
		model.displayCanton();
	}
	
	public void edit(ActionEvent e) {
		model.editCanton();
	}
	public void delete(ActionEvent e) {
		model.deletCanton();
	}
	
	public void home(ActionEvent e) {
		CantonView.backHome();
	}
	

}
