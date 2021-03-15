package Cantons;

public class Canton {
	
	public enum acronym{AG, AR, AI, BL, 
		BS, BE, FR, GE, 
		GL, GR, JU, LU, 
		NE, NW, OW, SG, 
		SH, SZ, SO, TI, 
		TG, UR, VD, VS, 
		ZH,ZG};
		
	public enum language{Deutsch, Franzöisch,
		Italienisch, Rätoromanisch};
		
	private static int IDNr = 0;
	
	private CantonsSwiss name;
	private acronym acronym;
	private language language;
	private int year;
	private int population;
	private final int ID;
	
	private static int getNextID() {
		return ++IDNr;
	}

	
	
	public Canton(CantonsSwiss name, acronym acronym, language language, int population, int year) {
		this.ID = getNextID();
		this.name = name;
		this.acronym = acronym;
		this.language = language;
		this.population = population;
		this.year = year;
		
		
	}

	public CantonsSwiss getName() {
		return name;
	}

	public void setName(CantonsSwiss name) {
		this.name = name;
	}

	public acronym getAcronym() {
		return acronym;
	}

	public void setAcronym(acronym acronym) {
		this.acronym = acronym;
	}

	public language getLanguage() {
		return language;
	}

	public void setLanguage(language language) {
		this.language = language;
	}

	public int getPopulation() {
		return this.population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int getID() {
		return ID;
	}
	

	@Override
	public String toString() {
		return "" + this.name;
	}

	
	

}
