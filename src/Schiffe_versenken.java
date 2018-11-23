import java.util.*;
public class Schiffe_versenken {
	
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		int[] y = new int[6];
		int[] x = new int[6];
		
		
		
		System.out.print("  Enemy's Ships"+"          y"+"      My Ships"
				+ "\n                        |6|"+""+""
				+ "\n                        |5|"+""+""
				+ "\n                        |4|"+""+""
				+ "\n                        |3|"+""+""
				+ "\n                        |2|"+""+""
				+ "\n                        |1|");
		System.out.println("\n-6__-5__-4__-3__-2__-1__|x|___1__2__3__4__5__6");
		
		for(int a=1; a<7; a++) {
			for(int i=1; i<7; i++) {
				System.out.print(" "+i*a);
			}
			System.out.print("\n");
		}
		
		System.out.print("Enter coordinates here ->");
		System.out.print("X: ");
		scan.nextInt();
		System.out.print("Y: ");
		scan.nextInt();
		
	}
	
	
	public static int[] makingShip(int[] ship, int numOfShips) {
		
		Random rn = new Random();
		
		int[] w = new int[6];
		
		for(int b=1; b<numOfShips; b++) {
			int x = rn.nextInt(7);
			int y = rn.nextInt(7);
		}
		
		for(int w=0; w<ship.length; w++) {
			for(int a=0; a<y.length; a++) {
				
			}
		}
		return ship;
	}
	
}

