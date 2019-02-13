import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Mastermind {
	
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		boolean geuse = false;
		int userNumber=0;
		int randomNumber=0;
		
		randomNumber = getRandom(randomNumber);
		while(true) {
			userNumber = getNumber(userNumber);
			if(checking(randomNumber, userNumber, geuse)) {
				System.out.println("\nherzlich glückwunsch Sie haben Gewonnen");
				break;
			}
		}
		
		
		
		
	}
	
	
	public static int getNumber(int inNum) {
		
		int row = 0;
		
		while(true){
			System.out.print("\ngeben Sie ein ziffer XXXX zahl: " );
			row = Mastermind.scan.nextInt();
			
			if(row >= 1000 && row <= 9999) {
				
				int first=   row/1000;
				int second=  row%1000/100;
				int third=   row%100/10;
				int fourth=  row%10;
				
				if(first==second || first ==third || first==fourth || second==third || second==fourth || third==fourth) {
					
					System.out.println("\nError!!! Sie haben geleiche ziffer gegeben!!");
					row=0;
				}else {
					inNum = row;
					break;
				}
				
			}else {
				System.out.println("\nError!!! Die Anzahl ist groß oder klein !!! noch mal versuchen.");
			}
		}
		return inNum;
		
	}
	
	
	
	
	
	public static int getRandom(int randNum) {
		
		int row;
		while(true) {
			
			row = ThreadLocalRandom.current().nextInt(1000, 9999);
			int first=   row/1000;
			int second=  row%1000/100;
			int third=   row%100/10;
			int fourth=  row%10;
			
			if(first==second || first ==third || first==fourth || second==third || second==fourth || third==fourth) {
				row=0;
			}else {
				randNum = row;
				break;
			}
		}
		return randNum;
	}
	
	
	
	
	
	
	public static boolean checking(int randNum, int userNum, boolean set) {
		
		
		int[] random = new int[4];
		int[] user = new int[4];
		char[] words = new char[4];
		int count = 0;
		
		random[0] =   randNum/1000;
		random[1] =   randNum%1000/100;
		random[2] =   randNum%100/10;
		random[3] =   randNum%10;
		
		user[0]  =   userNum/1000;
		user[1]  =   userNum%1000/100;
		user[2]  =   userNum%100/10;
		user[3]  =   userNum%10;
		
		System.out.print("\nihre Erginesrn sind: ");
		for(int i=0; i<4; i++) {
			if(random[i]==user[i]) {
				words[i]='R';
				count++;
				if(count==4) {
					set = true;
				}
			}else {
				words[i]='F';
			}
			
			for(int b=0; b<4; b++) {
				if(i!=b) {
					if(user[i]==random[b]) {
						words[i]='P';
					}
				}
			}
			System.out.print(words[i]);
		}
		return set;
	}

}
