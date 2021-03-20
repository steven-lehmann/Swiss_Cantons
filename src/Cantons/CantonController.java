package Cantons;


import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



public class CantonController {
	
	private CantonView view;
	private CantonModel model;

	public CantonController(CantonModel model, CantonView view) {
		this.view = view;
		this.model = model;
		
		view.txtName.textProperty().addListener(
				(observable, oldValue, newValue) -> validateName(newValue));
		view.txtYear.textProperty().addListener(
				(observable, oldValue, newValue) -> validateInt(newValue));
		view.txtaLanguage.textProperty().addListener(
				(observable, oldValue, newValue) -> validateLanguage(newValue));
		view.txtAcronym.textProperty().addListener(
				(observable, oldValue, newValue) -> validateAcronym(newValue));

		//Anzeigen
		view.displayButton.setOnAction(this::display);
		
		//Hinzufügen
		view.creatButton.setOnAction(this::add);
		
		//Bearbeiten
		view.editButton.setOnAction(this::edit);
		
		//Löschen
		view.deleteButton.setOnAction(this::delete);
	
		view.homeButton.setOnAction(this::home);
		//neuer Kanton hinzufügen
		view.addNewCanton.setOnAction(this::addNewCanton);
		
		//speichern und aktualisieren
		view.saveAndUpdateButton.setOnAction(this::updateFields);
	
	}
	
	public void addNewCanton(ActionEvent e) throws NumberFormatException {
		try {
		CantonsSwiss cantons = CantonsSwiss.valueOf(view.txtName.getText());
		language languag = language.valueOf(view.txtaLanguage.getText());
		String mainPlace = view.txtMainPlace.getText();
		acronym acro = acronym.valueOf(view.txtAcronym.getText());
		String yearStr = view.txtYear.getText();
		int year = Integer.parseInt(yearStr);
		String popStr = view.txtPopulation.getText();
		int population = Integer.parseInt(popStr);
		String size = view.txtSize.getText();
		int sizeInt = Integer.parseInt(size);
		String attractions = view.txtaAttractions.getText();
		String neighbour = view.txtaNeighbor.getText();
		String link = view.txtLink.getText();
	    model.creatCanton(cantons, acro, mainPlace, languag, population, year, sizeInt, attractions, neighbour,link);
		updateView(model.getCanton());
		view.cantonsDisplay.getItems().add(model.getCanton());
		view.setTFDisable();
		
		}catch(IllegalArgumentException error){
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Input not valid");
			errorAlert.setContentText("Bitte alle Pflichtfelder korrekt ausfüllen!");
			errorAlert.showAndWait();

		}
	}
	
	private void updateView(Canton canton) {
		if (canton != null) {
			view.txtName.setText(canton.getName().name());
			view.txtAcronym.setText(canton.getAcronym().name());
			view.txtMainPlace.setText(canton.getMainPlace());
			view.txtaLanguage.setText(canton.getLanguage().name());
			view.txtYear.setText(Integer.toString(canton.getYear()));
			view.txtPopulation.setText(Integer.toString(canton.getPopulation()));
			view.txtSize.setText(Integer.toString(canton.getSize()));
			view.txtaAttractions.setText(canton.getAttractions());
			view.txtaNeighbor.setText(canton.getNeighbour());
			view.txtLink.setText(canton.getLink());
		} else {
			view.txtName.setText("");
			view.txtAcronym.setText("");
			view.txtMainPlace.setText("");
			view.txtaLanguage.setText("");
			view.txtYear.setText("");
			view.txtPopulation.setText("");
			view.txtSize.setText("");
			view.txtaAttractions.setText("");
			view.txtaNeighbor.setText("");
			view.txtLink.setText("");
		}
	}

	public void display(ActionEvent e) {
		view.changeView();
		Canton canton = view.cantonsDisplay.getSelectionModel().getSelectedItem();
		this.updateView(canton);
		view.updateImage(canton);
		view.addNewCanton.setDisable(true);
		view.saveAndUpdateButton.setDisable(true);
		view.txtName.getStyleClass().remove("inputOk");
		view.txtYear.getStyleClass().remove("inputOk");
		view.txtAcronym.getStyleClass().remove("inputOk");
		view.txtaLanguage.getStyleClass().remove("inputOk");
		
	}
	
	public void edit(ActionEvent e) {
		view.txtPopulation.setDisable(false);
		view.txtYear.setDisable(false);
		view.txtaAttractions.setDisable(false);
		view.txtLink.setDisable(false);
		view.saveAndUpdateButton.setDisable(false);
		view.deleteButton.setDisable(true);
	
	}
	
	public void updateFields(ActionEvent e) {
		try {
		String name = view.txtName.getText();
		int index = model.getSelectedIndex(name);
		Canton cant = model.cantonsList.get(index);
		String yearNew = view.txtYear.getText();
		String popNew = view.txtPopulation.getText();
		String attractionNew = view.txtaAttractions.getText();
		String linkNew = view.txtLink.getText();
		int popInt = Integer.parseInt(popNew);
		int yearInt = Integer.parseInt(yearNew);
		cant.setYear(yearInt);
		cant.setPopulation(popInt);
		cant.setAttractions(attractionNew);
		cant.setLink(linkNew);
		view.saveAndUpdateButton.setDisable(true);
		view.deleteButton.setDisable(false);
		view.txtPopulation.setDisable(true);
		view.txtYear.setDisable(true);
		view.txtaAttractions.setDisable(true);
		view.txtLink.setDisable(true);
<<<<<<< HEAD
		view.txtName.getStyleClass().remove("inputOk");
		view.txtYear.getStyleClass().remove("inputOk");
		view.txtAcronym.getStyleClass().remove("inputOk");
		view.txtaLanguage.getStyleClass().remove("inputOk");
=======
		}catch(NumberFormatException error) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Input not valid");
			errorAlert.setContentText("Bevölkerung und Beitrittsjahr müssen Integer Werte sein!");
			errorAlert.showAndWait();
		}
>>>>>>> branch 'main' of https://github.com/steven-lehmann/Swiss_Cantons.git
	}
	

	public void delete(ActionEvent e) {
		String name = view.txtName.getText();
		model.cantonsList.remove(model.getSelectedCantonId(name)-1);
		this.updateView(null);
		view.cantonsDisplay.getItems().clear();
		view.updateCantonDisplay();
		view.flagView.setImage(null);
			
	}
	
	public void home(ActionEvent e) {
		view.backHome();
		view.setTFDisable();
		view.editButton.setDisable(false);
		view.deleteButton.setDisable(false);
		view.saveAndUpdateButton.setDisable(false);
	}

	private void add(ActionEvent actionevent1) {
		view.flagView.setImage(null);
		view.cardView.setImage(null);
		view.changeView();
		view.setTF();
		this.updateView(null);
		view.editButton.setDisable(true);
		view.deleteButton.setDisable(true);
		view.saveAndUpdateButton.setDisable(true);
		view.addNewCanton.setDisable(false);
		
	}
	
	private void validateName(String newValue) {
		boolean valid = false;
		CantonsSwiss[] cantons = CantonsSwiss.values();
		for(CantonsSwiss c : cantons) {
			if(c.equals(newValue)) {
				valid = true;
			}
		}
		
		view.txtName.getStyleClass().remove("inputNotOk");
		view.txtName.getStyleClass().remove("inputOk");
		if (valid) {
			view.txtName.getStyleClass().add("inputOk");
		} else {
			view.txtName.getStyleClass().add("inputNotOk");
		}
	}
	
	private void validateLanguage(String newValue) {
		boolean valid = false;
		language[] lang = language.values();
		for(language l : lang) {
			if(l.equals(newValue)) {
				valid = true;
			}
		}
		
		view.txtaLanguage.getStyleClass().remove("inputNotOk");
		view.txtaLanguage.getStyleClass().remove("inputOk");
		if (valid) {
			view.txtaLanguage.getStyleClass().add("inputOk");
		} else {
			view.txtaLanguage.getStyleClass().add("inputNotOk");
		}
	}
	
	private void validateAcronym(String newValue) {
		boolean valid = false;
		acronym[] acro = acronym.values();
		for(acronym a : acro) {
			if(a.equals(newValue)) {
				valid = true;
			}
		}
		
		view.txtAcronym.getStyleClass().remove("inputNotOk");
		view.txtAcronym.getStyleClass().remove("inputOk");
		if (valid) {
			view.txtAcronym.getStyleClass().add("inputOk");
		} else {
			view.txtAcronym.getStyleClass().add("inputNotOk");
		}
	}
	
	private void validateInt(String newValue) {
		boolean validInt = false;
		
		if(newValue.length() >= 2 && newValue.length() < 5) {
			validInt = true;
		}
		
		view.txtYear.getStyleClass().remove("inputNotOk");
		view.txtYear.getStyleClass().remove("inputOk");
		if (validInt) {
			view.txtYear.getStyleClass().add("inputOk");
		} else {
			view.txtYear.getStyleClass().add("inputNotOk");
		}
	}
}
