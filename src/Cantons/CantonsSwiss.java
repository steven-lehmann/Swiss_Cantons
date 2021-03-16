package Cantons;

public enum CantonsSwiss {
	
	Graubünden, Bern, Wallis, Waadt, Tessin, StGallen, 
	Zürich, Freiburg, Luzern, Aargau,
	Uri, Thurgau, Schwyz, Jura, Neuenburg, Solothurn,
	Glarus, BaselLand, Obwalden, Schaffhausen, Genf,
	Nidwalden, Zug, AppenzellAusserrhoden, AppenzellInnerrhoden, BaselStadt;
	
	public boolean contains(String searchString) {
		return (this.name().contains(searchString));
	}
	
}
