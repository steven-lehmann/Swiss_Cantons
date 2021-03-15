package Cantons;

import java.util.ArrayList;


import Cantons.Canton.acronym;
import Cantons.Canton.language;



public class CantonModel {

	
	
	protected ArrayList<Canton> cantonsList = new ArrayList<Canton>();
	
	
	private Canton baselLand = new Canton(CantonsSwiss.BaselLand, acronym.BL, language.Deutsch, 288150, 1501);
	private Canton zürich = new Canton(CantonsSwiss.Zürich, acronym.ZH, language.Deutsch, 1521000, 1351);
	private Canton bern = new Canton(CantonsSwiss.Bern, acronym.BE, language.Deutsch, 1035000, 1353);
	
	
	
	public void addCantons() {
		this.cantonsList.add(baselLand);
		this.cantonsList.add(zürich);
		this.cantonsList.add(bern);
	}
	
	
	public Canton getCanton() {
		return cantonsList.get(cantonsList.size()-1);
	}
	
	public void creatCanton(CantonsSwiss can, acronym acro, language lang, int population, int year) {
		Canton cant = new Canton(can, acro, lang, population, year);
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