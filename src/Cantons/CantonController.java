package Cantons;



import Cantons.Canton.acronym;
import Cantons.Canton.language;
import javafx.event.ActionEvent;



public class CantonController {
	
	private CantonView view;
	private CantonModel model;

	public CantonController(CantonModel model, CantonView view) {
		this.view = view;
		this.model = model;
		
		
		
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
	
	public void addNewCanton(ActionEvent e) {
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
		String name = view.txtName.getText();
		int index = model.getSelectedIndex(name);
		Canton cant = model.cantonsList.get(index);
		String yearNew = view.txtYear.getText();
		String popNew = view.txtPopulation.getText();
		String attractionNew = view.txtPopulation.getText();
		String linkNew = view.txtPopulation.getText();
		int popInt = Integer.parseInt(popNew);
		int yearInt = Integer.parseInt(yearNew);
		cant.setYear(yearInt);
		cant.setPopulation(popInt);
		view.saveAndUpdateButton.setDisable(true);
		view.deleteButton.setDisable(false);
		view.txtPopulation.setDisable(true);
		view.txtYear.setDisable(true);
		view.txtaAttractions.setDisable(true);
		view.txtLink.setDisable(true);
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
		view.changeView();
		view.setTF();
		this.updateView(null);
		view.editButton.setDisable(true);
		view.deleteButton.setDisable(true);
		view.saveAndUpdateButton.setDisable(true);
		view.addNewCanton.setDisable(false);
		
	}
	

}
