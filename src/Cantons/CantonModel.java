package Cantons;

import java.util.ArrayList;

import Cantons.Canton.acronym;
import Cantons.Canton.language;



public class CantonModel {
	
	ArrayList<Canton> cantonsList = new ArrayList<Canton>();
	
	
	private Canton baselLand = new Canton(CantonsSwiss.BaselLand, acronym.BL, language.Deutsch, 288150, 1501);
	private Canton zürich = new Canton(CantonsSwiss.Zürich, acronym.ZH, language.Deutsch, 1521000, 1351);
	private Canton bern = new Canton(CantonsSwiss.Bern, acronym.BE, language.Deutsch, 1035000, 1353);
	
	
	public void displayCanton() {
		//getter SetText Label 
	
	}
	
	public void creatCanton() {
		
		//getText from TField ->create new Canton -> add ArraayList
	
	}
	
	public void editCanton() {
		
		// edit just Population

	}

	public void deletCanton() {
		// get Name from TextField (displayCanton) -> delet from ArrayList -> TextField ""
	}
	
}