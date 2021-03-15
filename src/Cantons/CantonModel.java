package Cantons;

import java.util.ArrayList;


import Cantons.Canton.acronym;
import Cantons.Canton.language;



public class CantonModel {

	
	
	ArrayList<Canton> cantonsList = new ArrayList<Canton>();
	
	
	private Canton baselLand = new Canton(CantonsSwiss.BaselLand, acronym.BL, language.Deutsch, 288150, 1501);
	private Canton zürich = new Canton(CantonsSwiss.Zürich, acronym.ZH, language.Deutsch, 1521000, 1351);
	private Canton bern = new Canton(CantonsSwiss.Bern, acronym.BE, language.Deutsch, 1035000, 1353);
	
	
	
	public void addCantons() {
		this.cantonsList.add(baselLand);
		this.cantonsList.add(zürich);
		this.cantonsList.add(bern);
	}
	
	
	public Canton getCanton() {
		//getter SetText Label
		return cantonsList.get(cantonsList.size()-1);
	}
	
	public void creatCanton(CantonsSwiss can, acronym acro, language lang, int year, int population) {
		//getText from TField ->create new Canton -> add ArraayList
		Canton cant = new Canton(can, acro, lang, year, population);
		cantonsList.add(cant);
	}
	
	public void editCanton() {
		// edit just Population

	}

	public void deletCanton() {
		// get Name from TextField (displayCanton) -> delet from ArrayList -> TextField ""
	}


	/*public int getSelectedCantonId(String name) {
		int id = 0;
		for(Canton c : cantonsList) {
			if(c.getName().contains(name)) {
				id = c.getID();
			} 
		}
		return id;
	}*/
}