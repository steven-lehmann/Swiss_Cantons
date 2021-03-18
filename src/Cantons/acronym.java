package Cantons;

public enum acronym {
	AG, AR, AI, BL, 
	BS, BE, FR, GE, 
	GL, GR, JU, LU, 
	NE, NW, OW, SG, 
	SH, SZ, SO, TI, 
	TG, UR, VD, VS, 
	ZH, ZG;
	
	public boolean equals(String searchString) {
		return (this.name().equals(searchString));
	}

}
