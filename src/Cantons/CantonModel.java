package Cantons;

import java.util.ArrayList;

public class CantonModel {

	
	
	protected ArrayList<Canton> cantonsList = new ArrayList<Canton>();
	
	
	private Canton baselLand = new Canton(CantonsSwiss.BaselLand, acronym.BL, "Liestal", language.Deutsch, 288150, 1501, 518, "Angenstein, Augusta Raurica", "Aargau, BaselStadt", "https://www.baselland.ch/");
	private Canton zürich = new Canton(CantonsSwiss.Zürich, acronym.ZH, "Zürich", language.Deutsch, 1521000, 1351, 1729, "Zürichsee, Nationalmuseum", "Schaffhausen, Aargau, Zug,  Schwyz, StGallen, Thurgau", "https://www.zh.ch/");
	private Canton bern = new Canton(CantonsSwiss.Bern, acronym.BE, "Bern", language.Deutsch, 1035000, 1353, 5959, "Bundeshaus, Rosengarten, Zytglogge", "Jura, Solothurn, Aargau, Neuenburd, Waadt,Freiburg, Luzern,  Nidwalden, \nObwalden, Uri, Wallis", "https://www.bern.ch/");
	
	
	
	public void addCantons() {
		this.cantonsList.add(baselLand);
		this.cantonsList.add(zürich);
		this.cantonsList.add(bern);
	}
	
	
	public Canton getCanton() {
		return cantonsList.get(cantonsList.size()-1);
	}
	
	public void creatCanton(CantonsSwiss can, acronym acro, String mainPlace, language lang, 
							int population, int year, int size, String attractions, String neighbour, 
							String link) {
		Canton cant = new Canton(can, acro, mainPlace, lang, population, year, size, attractions, neighbour, link);
		cantonsList.add(cant);
	}
	
    public int getSelectedCantonId(String name) {
		int id = 0;
		for(Canton c : cantonsList) {
			if(c.getName().contains(name)) {
				id = c.getID();
			} 
		}
		return id;
	}


	public int getSelectedIndex(String name) {
		int index = 0;
		for(Canton c : cantonsList) {
			if(c.getName().contains(name)) {
				index = cantonsList.indexOf(c);
			}
		}
		return index;
		
		
	}

}