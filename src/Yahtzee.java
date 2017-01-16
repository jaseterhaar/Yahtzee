import java.util.*;

public class Yahtzee{
	static Dobbelstenen dobbelstenen = new Dobbelstenen();
	static Scanner invoer = new Scanner(System.in);
	static int worpCount;
	static String[] combinaties = new String[7];
	static int[] punten = new int[combinaties.length];
	static boolean [] gebruikt = new boolean[combinaties.length];
	static int [] frequency = new int[dobbelstenen.getAantalWaarden()];

	public static void main(String [] args){
		
		
		for (int i = 0; i < 6; i++) {
			dobbelstenen.worp();
			beurt();
			countFrequency();
			opties();
		}
		eindScore();

	}//Einde main method
	
	//methode voor eindscore
	static void eindScore(){
		System.out.println("Je hebt de volgende score gehaald: ");
		for (int i = 0; i < combinaties.length; i++) {
			System.out.println(combinaties[i] + punten[i]);
		}
		int totaalPunten = 0;
		for (int i = 0; i < punten.length; i++) {
			totaalPunten += punten[i];
		}
		System.out.println("Bedankt voor het spelen");
	}
	

	//methode voor het kiezen van opties
	static void opties(){
		System.out.println("Je hebt het volgende geworpen: ");
		dobbelstenen.printWaarden();
		printOpties();
		kiesOptie();

	}//einde opties()
	
	//kiesopties()
	static void kiesOptie(){
		System.out.println("Maak uw keuze: ");
		int keuze = invoer.nextInt();
		System.out.println("test kiesoptie");
		
		switch(keuze){
		case 1:
			if(gebruikt[0] == true){
				System.out.println("Optie al gebruikt. Kies opnieuw.");
				opties();
				
			} else {
				System.out.println("Ok");
				threeOfKind();
			}
			break;
			
		case 2:
			if(gebruikt[1] == true){
				System.out.println("Optie al gebruikt. Kies opnieuw.");
				opties();
			} else {
				fourOfKind();
			}
			break;
			
		case 3:
			if(gebruikt[2] == true){
				System.out.println("Optie al gebruikt. Kies opnieuw.");
				opties();
			} else {
				kleineStraat();
			}
			break;
			
		case 4:
			if(gebruikt[3] == true){
				System.out.println("Optie al gebruikt. Kies opnieuw.");
				opties();
			} else {
				groteStraat();
			}
			break;
			
		case 5:
			if(gebruikt[4] == true){
				System.out.println("Optie al gebruikt. Kies opnieuw.");
				opties();
			} else {
				fullHouse();
			}
			break;
			
		case 6:
			if(gebruikt[5] == true){
				System.out.println("Optie al gebruikt. Kies opnieuw.");
				opties();
			} else {
				kans();
			}
			break;
			
		case 7:
			if(gebruikt[6] == true){
				System.out.println("Optie al gebruikt. Kies opnieuw.");
				opties();
			} else {
				fullHouse();
			}
			break;
		}
		
	}//einde kiesopties()

	//methode voor een beurt
	static void beurt(){
		while(worpCount<3){
			System.out.println("Je hebt nog " + (3-worpCount) + " pogingen");
			dobbelstenen.worp();
			vastleggen();
			if(worpCount >= 3){
				dobbelstenen.printWaarden();
			}
		}
	}

	//methode voor het vastleggen van dobbelstenen
	static void vastleggen(){

		String keuze;


		do{
			dobbelstenen.printWaarden();
			System.out.println("Welke dobbelsteen wil je vastleggen?");
			System.out.println("Gebruik \"x\" om te gooien");
			System.out.println("Gebruik \"q\" om beurt te beeindigen.");
			keuze = invoer.nextLine();
			//vastleggen van de dobbelsteen
			for (int i = 0; i < dobbelstenen.getAantalDobbelstenen(); i++) {
				if(keuze.toLowerCase().equals(dobbelstenen.getPositie()[i][0])){
					dobbelstenen.setVast(i);	
				} 

			}//einde forloop

		}while(!keuze.toLowerCase().equals("x") && !keuze.toLowerCase().equals("q")); //einde loop

		//wat er dient te gebeuren bij x of 
		if (keuze.toLowerCase().equals("x")){
			worpCount++;
			System.out.println(worpCount);
		} else if(keuze.toLowerCase().equals("q")){
			worpCount = 4;
			System.out.println(worpCount);
		}

	}//Einde vastleggen()

	static void combinaties(){
		combinaties[0] = "3 gelijken    ";
		combinaties[1] = "4 gelijken    ";
		combinaties[2] = "kleine straat ";
		combinaties[3] = "grote straat  ";
		combinaties[4] = "full house    ";
		combinaties[5] = "kans          ";
		combinaties[6] = "yahtzee       ";
	}// einde combinaties()

	static void printOpties(){
		combinaties();
		System.out.println("Maak een keuze uit de volgende opties:");
		for (int i = 0; i < combinaties.length; i++) {
			System.out.println((i+1) + " = " + combinaties[i]);
		}
	}//einde printOpties()

	//Count frequency
	static void countFrequency(){

		//door de dobbelstenen heen loopen
		for (int i = 0; i < dobbelstenen.getWaarden().length; i++) {
			switch(dobbelstenen.getWaarden()[i]){
			case 1:
				frequency[0]++;
				break;
			case 2:
				frequency[1]++;
				break;
			case 3:
				frequency[2]++;
				break;
			case 4:
				frequency[3]++;
				break;
			case 5:
				frequency[4]++;
				break;
			case 6:
				frequency[5]++;
				break;
			}//einde switch
		}//einde for		
	}//einde countFrequency()
	/////////////////////////////
	/////////////////////////////
	/////////////////////////////
	/////////////////////////////
	/////////////////////////////
	//grote straat
	static void kleineStraat(){
		if (frequency[0] == 1 && 
				frequency[1] == 1 && 
				frequency[2] == 1 && 
				frequency[3] == 1){
			System.out.println("kleine straat");
			punten[2] = 30;
		} else if ( frequency[1] == 1 && 
				frequency[2] == 1 && 
				frequency[3] == 1 && 
				frequency[4] == 1){
			System.out.println("kleine straat");
			punten[2] = 30;
		} else if ( frequency[2] == 1 && 
				frequency[3] == 1 && 
				frequency[4] == 1 && 
				frequency[5] == 1){
			System.out.println("kleine straat");
			punten[2] = 30;
		}
		
		gebruikt[2] = true;
	}

	//kleine straat
	static void groteStraat(){
		if(	frequency[0] == 1 && 
				frequency[1] == 1 && 
				frequency[2] == 1 && 
				frequency[3] == 1 && 
				frequency[4] == 1){
			System.out.println("grote straat");
			punten[3] = 40;
		} else if(	frequency[1] == 1 && 
				frequency[2] == 1 && 
				frequency[3] == 1 && 
				frequency[4] == 1 && 
				frequency[5] == 1){
			System.out.println("grote straat");
			punten[3] = 40;
		}
		gebruikt[3] = true;
	}
	//yahtzee
	static void yahtzee(){
		boolean yahtzee = false;
		for (int i = 0; i < frequency.length; i++) {
			if(frequency[i]==5){

				yahtzee = true;
			}		
		}
		if(yahtzee == true){
			punten[6] = 50;
		} else {
			punten[6] = 0;
		}
		
		gebruikt[6] = true;
	}

	//kans
	static void kans(){
		punten[5] = dobbelstenen.getTotaalWaarde();
		System.out.println(dobbelstenen.getTotaalWaarde());
		gebruikt[5] = true;
	}



	//full house
	static void fullHouse(){
		boolean two = false;
		boolean three = false;
		for (int i = 0; i < frequency.length; i++) {
			if(frequency[i] == 2){
				two = true;
			} else if(frequency[i] == 3){
				three = true;
			}
		}

		if(three == true && two == true){
			punten[4] = 25;
		} else {
			punten[4] = 0;
		}
		gebruikt[4] = true;
	}

	//fourOfKind
	static void fourOfKind(){
		boolean fourOfKind = false;
		for (int i = 0; i < frequency.length; i++) {
			if(frequency[i]>=4){

				fourOfKind = true;
			}		
		}
		if(fourOfKind == true){
			punten[1] = dobbelstenen.getTotaalWaarde();
		} else {
			punten[1] = 0;
		}
		gebruikt[1] = true;
	}

	//threeOfKind
	static void threeOfKind(){
		boolean threeOfKind = false;
		for (int i = 0; i < frequency.length; i++) {
			if(frequency[i]>=3){

				threeOfKind = true;
			}		
		}
		if(threeOfKind == true){
			punten[0] = dobbelstenen.getTotaalWaarde();
		} else {
			punten[0] = 0;
		}
		gebruikt[0] = true;
	}

	/////////////////////////////

}//Einde class Yahtzee