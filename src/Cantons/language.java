package Cantons;

public enum language {
	Deutsch, Französisch,
	Italienisch, Rätoromanisch;
	
	public boolean equals(String searchString) {
		return (this.name().equals(searchString));
	}
}
