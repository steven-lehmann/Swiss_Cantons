package Cantons;

public class Canton {
		
	private static int IDNr = 0;
	
	private CantonsSwiss name;
	private acronym acronym;
	private language language;
	private String mainPlace;
	private String attractions;
	private String neighbour;
	private String link;
	private int size;
	private int year;
	private int population;
	private final int ID;
	
	private static int getNextID() {
		return ++IDNr;
	}
	
	public Canton(CantonsSwiss name, acronym acronym, String mainPlace, language language, int population, 
			int year, int size, String attractions, String neighbour, String link) {
		this.ID = getNextID();
		this.name = name;
		this.acronym = acronym;
		this.mainPlace = mainPlace;
		this.language = language;
		this.population = population;
		this.year = year;
		this.size = size;
		this.attractions = attractions;
		this.neighbour = neighbour;
		this.link = link;
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
	
	
	public String getMainPlace() {
		return mainPlace;
	}



	public void setMainPlace(String mainPlace) {
		this.mainPlace = mainPlace;
	}



	public String getAttractions() {
		return attractions;
	}



	public void setAttractions(String attractions) {
		this.attractions = attractions;
	}



	public String getNeighbour() {
		return neighbour;
	}



	public void setNeighbour(String neighbour) {
		this.neighbour = neighbour;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public int getSize() {
		return size;
	}



	public void setSize(int size) {
		this.size = size;
	}




	@Override
	public String toString() {
		return "" + this.name;
	}

	
	

}
