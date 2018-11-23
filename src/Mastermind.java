import java.util.*;
public class Mastermind {
	
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		ArrayList<Integer> randomList = new ArrayList<Integer>(4);
		ArrayList<Integer> inputNumbers = new ArrayList<Integer>(4);
		boolean result = true;
		
		
		for(int x=0; x<10; x++) {
			if(x==0) {
				getRandom(randomList);
			}
			inputNumbers.clear();
			getNumber(inputNumbers);
			
			if(result == checking(randomList, inputNumbers, result)) {
				System.out.print("Wollen Sie nochmal spielen?: ");
				if(scan.nextLine().equals("y") || scan.nextLine().equals("Y")) {
					x=0;
				}else {
					if(scan.nextLine().equals("n") || scan.nextLine().equals("N")) {
						break;
					}
				}
			}
		}
	}
	
	
	public static ArrayList<Integer> getNumber(ArrayList<Integer> inNum) {
		
		
		for(int i=1; i<5; i++) {
			System.out.print("Zahl "+i+": (0/9): ");
			int row = Mastermind.scan.nextInt();
			if(row<10) {
				if(i>1) {
					if(inNum.contains(row)) {
						System.out.println("Error!! Sie haben diese Nummer schon genohmen!!");
						i--;
					}else {
						inNum.add(row);
					}
				}else {
					inNum.add(row);
				}
			}else {
				System.out.println("Error!!! Die Anzahl ist zu groﬂ!!! noch mal versuchen.");
				i--;
			}
			System.out.println("\nIhre Zahlen: "+inNum);
		}
		return inNum;
	}
	
	
	
	public static ArrayList<Integer> getRandom(ArrayList<Integer> randList) {
		
		Random rand = new Random();
		for(int i=0; i<4; i++) {
			int row = rand.nextInt(10);
			if(randList.contains(row)) {
				i--;
			}else {
				randList.add(row);
			}
		}
		return randList;
	}
	
	
	
	
	public static boolean checking(ArrayList<Integer> randNum, ArrayList<Integer> userNum, boolean set) {
		
		boolean guese = false;
		set = guese;
		int rightNumbers = 0;
		for(int s=0; s<randNum.size(); s++) {
			if(randNum.get(s).equals(userNum.get(s))) {
				System.out.println("Direkter Treffer!!");
			}
			if(randNum.contains(userNum.get(s))) {
				System.out.println("Indirekt Treffer!!");
			}
			if(randNum.get(s).equals(userNum.get(s))) {
				rightNumbers++;
				if(rightNumbers==4) {
					System.out.println("\n\n\nGl¸ckwunsch! Sie haben gewonnen!!!");
					set = true;
				}
			}
		}
		return set;
	}

}
