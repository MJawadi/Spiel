import java.util.*;
public class Mastermind {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		int zahl1 = 0, zahl2 = 0, zahl3 = 0, zahl4 = 0;
		getRandom(zahl1, zahl2, zahl3, zahl4);
		System.out.print(zahl1+zahl2+zahl3+zahl4);

	}
	
	
	public static void getNumber(int a, int b, int c, int d) {
		
		Scanner scan = new Scanner(System.in);
		for(int i=1; i<5; i++) {
			System.out.print("Zahl "+i+": (0/9): ");
			int inNum = scan.nextInt();
			if(inNum<10) {
				switch(i) {
				case 1: a=inNum;
				case 2: b=inNum;
				case 3: c=inNum;
				case 4: d=inNum;
				}
			}else {
				System.out.println("Error!!! Die Anzahl ist zu groß!!! noch mal versuchen.");
				i--;
			}
		}
		scan.close();
		
	}
	
	
	public static void getRandom(int a, int b, int c, int d) {
		
		Random rand = new Random();
		for(int j=1; j<5; j++) {
			switch(j) {
			case 1: a = rand.nextInt(10);
			case 2: b = rand.nextInt(10);
			case 3: c = rand.nextInt(10);
			case 4:	d = rand.nextInt(10);
			}
			if(a==b || a==c || a==d || b==d || c==d) {
				j=1;
			}
		}
	}

}
