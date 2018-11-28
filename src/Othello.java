import java.util.*;
public class Othello {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
				
		int[][] table = new int[8][8];
		table[3][3]=1;
		table[4][4]=1;
		table[3][4]=2;
		table[4][3]=2;
		int player1=1, player2=2;
		/*
		System.out.print("X-->: ");
		int X= scan.nextInt();
		System.out.print("Y-->: ");
		int Y= scan.nextInt();
		*/
		check(table, 1);
		
		print(table);
		
		
	}
	
	
	
	
	
	
	
	
	public static int[][] check(int[][] inTable, int player) {
		
		int[][] cells = new int[8][8];
		cells = inTable;
		int player2=1;
		
		if(player==1) {
			player2=2;
		}else {
			player2=1;
		}
		
		
		
		for(int x=0; x<cells.length; x++) {
			for(int y=0; y<cells.length; y++) {
				if((x>0 && x<7) && (y>0 && y<7)) {
					
					if(cells[x][y]==player2) {
						for(int a=x-1; a<x+2; x++) {
							for(int b=y-1; b<y+2; b++) {
								if(cells[a][b]==0) {
									cells[a][b]=3;
								}
							}
						}
					}
				}
			}
		}
		
		
		return cells;
	}
	
	
	
	
	
	
	
	
	public static void print(int[][] cells){
		
		
		
		int player1=1, player2=2;
		char word = 'A';
		System.out.println("   ____________________________________________________");
		System.out.println("   | * |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |");
		System.out.println("   ————————————————————————————————————————————————————");
		for(int x=0; x<8; x++) {
			System.out.print("   | "+word +" |  ");
			word +=1;
			for(int y=0; y<8; y++) {
				if(cells[x][y]==player1) {
					System.out.print("O");
				}else {
					if(cells[x][y]==player2) {
						System.out.print("X");
					}else {
						if(cells[x][y]==3) {
							System.out.print("+");
						}else {
							System.out.print(".");
						}
					}
				}
				
				System.out.print("  |  ");
			}
			System.out.print("\n   ————————————————————————————————————————————————————");
			System.out.print("\n");
		}
		
		
	}

}
