package Cantons;

import java.util.ArrayList;

import Cantons.Canton.acronym;
import Cantons.Canton.language;



public class CantonModel {
	
	ArrayList<Canton> cantonsList = new ArrayList<Canton>();
	
	
	private Canton baselLand = new Canton(Canton.CantonsSwiss.BaselLandschaft, acronym.BL, language.Deutsch, 288150, 1501);
	private Canton zürich = new Canton(Canton.CantonsSwiss.Zürich, acronym.ZH, language.Deutsch, 1521000, 1351);
	private Canton bern = new Canton(Canton.CantonsSwiss.Bern, acronym.BE, language.Deutsch, 1035000, 1353);
	
	
	public void displayCanton() {
	
	}
	
	public void crateCanton() {
	
	}
	
	public void editCanton() {

	}
	
	public void deleteCanton() {
	
	}
	

}