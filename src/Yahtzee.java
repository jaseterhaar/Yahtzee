import java.util.Scanner;

public class Yahtzee {
	static int puntenWorp = 0;
	static int aantalDb = 5;
	static char keuze;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		worp();
		System.out.println("Punten deze worp: " + puntenWorp);
		System.out.println();
		
		
		//opties
		
	}
	
	//methode voor het maken van een worp
	static void worp(){
		
		int [] worp = new int[aantalDb];
		
		//initializeren van dobbelsteenobject
		Dobbelsteen db = new Dobbelsteen();
		
		System.out.println();
		//5 dobbelstenen werpen
		for(int i=0; i<worp.length; i++){
			System.out.print(" "+ (i+1) +"  ");
		}
		System.out.println();
		for(int i=0; i<aantalDb; i++){
			db.werpen();
			worp[i] = db.uitslag;
			System.out.print("["+ worp[i] +"] ");
			puntenWorp += worp[i];
		}
		System.out.println();
		System.out.println();

	}
	
	static void opties(){
		System.out.println("a = Drie gelijke");
		System.out.println("b = Vier gelijke");
		System.out.println("c = Kleine straat");
		System.out.println("d = Grote straat");
		System.out.println("e = Full House");
		System.out.println("f = Kans");
		System.out.println("g = Yahtzee!");
		System.out.println("x = Extra gooien");
	}

}

class Dobbelsteen {
	int uitslag;
	void werpen(){
		uitslag = (int)(Math.random()*6)+1;		
	}

}
