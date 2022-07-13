package com.maryem.test.technique.laCombe;

public class DrinkMakerRequest {
	
	private final String SEPARATOR = ":";
	
	private String drinkType;
	
	private Integer sugars;
	
	private double prix;
	
	public DrinkMakerRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DrinkMakerRequest(String drinkType, Integer sugars, double prix) {
		super();
		this.drinkType = drinkType;
		this.sugars = sugars;
		this.prix=prix;

	}
	

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDrinkType() {
		return String.valueOf(drinkType);
	}

	public void setDrinkType(String drinkType) {
		this.drinkType = drinkType;
	}

	public String getSugars() {
		if (sugars!=null && sugars.intValue() == 0)
			return "";
		else
			return sugars.toString();
	}

	public void setSugars(Integer sugars) {
		this.sugars = sugars;
	}

	public String getStick() {
		if (sugars!=null && sugars.intValue()==0)
			return "";
		else
			return "0";
	}
	
	@Override
	public String toString() {
		return getDrinkType() + SEPARATOR +
				getSugars() + SEPARATOR +
				getStick() ;
	}

	
	

}
