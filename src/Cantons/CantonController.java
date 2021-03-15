package Cantons;

import java.util.Scanner;

import Cantons.Canton.acronym;
import Cantons.Canton.language;
import javafx.event.ActionEvent;
import javafx.scene.Scene;


public class CantonController {
	
	private CantonView view;
	private CantonModel model;
	private Scanner scan;

	public CantonController(CantonModel model, CantonView view) {
		this.view = view;
		this.model = model;
		
		//Anzeigen
		
		view.displayButton.setOnAction(this::display);
		
		// Hinzufügen
		view.creatButton.setOnAction(this::add);
		
		//Bearbeiten
		view.editButton.setOnAction(this::edit);
		//view.cantonsEdit.setOnAction(this::edit);
		
		//Löschen
		view.deleteButton.setOnAction(this::delete);
	
		view.homeButton.setOnAction(this::home);
		
		view.saveButton.setOnAction(this::save);
	
	}
	
	public void save(ActionEvent e) {
		
		CantonsSwiss cantons = CantonsSwiss.valueOf(view.txtName.getText());
		language languag = language.valueOf(view.txtaLanguage.getText());
		acronym acro = acronym.valueOf(view.txtAcronym.getText());
		/*String cantStr = view.txtName.getText();
		CantonsSwiss cantons = CantonsSwiss.valueOf(cantStr);
		String acrStr = view.txtAcronym.getText();
		acronym acro = acronym.valueOf(acrStr);
		String langStr = view.txtaLanguage.getText();
		language languag = language.valueOf(langStr);*/
		String yearStr = view.txtYear.getText();
		int year = Integer.parseInt(yearStr);
		String popStr = view.txtPopulation.getText();
		int population = Integer.parseInt(popStr);
	
		model.creatCanton(cantons, acro, languag, year, population);
		updateView(model.getCanton());
		view.cantonsDisplay.getItems().add(model.getCanton());
	}
	
	private void updateView(Canton canton) {
		if (canton != null) {
			view.txtName.setText(canton.getName().name());
			view.txtAcronym.setText(canton.getAcronym().name());
			view.txtaLanguage.setText(canton.getLanguage().name());
			view.txtYear.setText(Integer.toString(canton.getYear()));
			view.txtPopulation.setText(Integer.toString(canton.getPopulation()));
		} else {
			view.txtName.setText("");
			view.txtAcronym.setText("");
			view.txtYear.setText("");
			view.txtaLanguage.setText("");
			view.txtPopulation.setText("");
		}
	}

	public void display(ActionEvent e) {
		Canton canton = view.cantonsDisplay.getSelectionModel().getSelectedItem();
		CantonView.changeView();
		this.updateView(canton);
	}
	
	public void edit(ActionEvent e) {
		//model.editCanton();
	}
	public void delete(ActionEvent e) {
		//model.deletCanton();
	}
	
	public void home(ActionEvent e) {
		CantonView.backHome();
	}

	private void add(ActionEvent actionevent1) {
		CantonView.changeView();
	}
	

}
