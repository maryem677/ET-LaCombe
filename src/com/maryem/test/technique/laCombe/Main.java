package com.maryem.test.technique.laCombe;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {

	public static void main(String args[]) {
	// test with user interaction
		DrinkMakerRequest drinkmakerRequest = saisie();
		display(drinkmakerRequest);
		
		
	// test without user interaction 
//		DrinkMakerRequest drinkmaker= new DrinkMakerRequest("Th",0,0.7);
//		display(drinkmaker);
		
		
	}


	private static DrinkMakerRequest saisie () {
		Scanner sc = new Scanner(System.in);
		DrinkMakerRequest drinkmakerRequest = new DrinkMakerRequest();

		drinkmakerRequest.setDrinkType(saisieTypeDrink(sc));
	
		if (drinkmakerRequest.getDrinkType().equals("O")) {
			drinkmakerRequest.setSugars(0);  // no sugar for orange juice 
			drinkmakerRequest.setPrix(saisiePrix(sc));
		}else { 
		drinkmakerRequest.setSugars(saisieQuantiteSucre(sc));
		drinkmakerRequest.setPrix(saisiePrix(sc));
		}
		return drinkmakerRequest;

	}

	public static String saisieTypeDrink(Scanner sc) {
		String drinkType;
		do{
			System.out.println("Choisir votre boisson C , T, H, Ch, Th, Hh, O");
			drinkType = sc.next();
		}
		while(!("T".equals(drinkType) || "C".equals(drinkType) || "H".equals(drinkType) || "Th".equals(drinkType) || "Hh".equals(drinkType)|| "O".equals(drinkType) || "Ch".equals(drinkType)));

		return drinkType;
	}

	public static int saisieQuantiteSucre(Scanner sc) {
		System.out.println("Combien de sucre");
		int nbreSucre = sc.nextInt();
		return nbreSucre;
	}
	public static double saisiePrix(Scanner sc) {
		System.out.println("veuillez payer");
		double prix = sc.nextDouble();
		return prix;
	}
	
	public static void display(DrinkMakerRequest drinkmakerRequest) {
		DecimalFormat df = new DecimalFormat("0.00");
		double reste;
		reste=verifMoney(drinkmakerRequest);
		if (reste==0) {
		System.out.println(drinkmakerRequest.toString());
		}else if (reste>0) {
			System.out.println("missing "+ df.format(reste*100) +" cents");
		}else if (reste<0) {
			System.out.println(drinkmakerRequest.toString());
			System.out.println("rendue : " + df.format(reste*(-100)) + " cents");
		}
	}
	public static double verifMoney(DrinkMakerRequest dmr) {
		char s=dmr.getDrinkType().charAt(0);
		double reste=0;
		switch (s) {
		case 'T': { 
			reste=0.4-dmr.getPrix();
			break;
		} 
		case 'C': { 
			reste=0.6-dmr.getPrix();
			break;
		} 
		case 'H': { 
			reste=0.5-dmr.getPrix();
			break;
		} 
		case 'O': { 
			reste=0.6-dmr.getPrix();
			break;
		} 
		 
		 
		}
		return reste;
	}
	
}


